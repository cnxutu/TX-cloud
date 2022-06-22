package com.example.springbootdemo.clickhouse.controller;

import com.alibaba.excel.event.AbstractIgnoreExceptionReadListener;

import java.sql.*;


public class Test01 {

    static void dropAndCreateTable(String url, String user, String password, String table) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(
                    String.format(
                            "drop table if exists %1$s; create table %1$s(a String, b Nullable(String)) engine=Memory",
                            table));
        }
    }

    static void batchInsert(String url, String user, String password, String table) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // not that fast as it's based on string substitution and large sql statement
            String sql = String.format("insert into %1$s values(?, ?)", table);
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "a");
                ps.setString(2, "b");
                ps.addBatch();
                ps.setString(1, "c");
                ps.setString(2, null);
                ps.addBatch();
                ps.executeBatch();
            }

            // faster when inserting massive data
            sql = String.format("insert into %1$s", table);
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "a");
                ps.setString(2, "b");
                ps.addBatch();
                ps.setString(1, "c");
                ps.setString(2, null);
                ps.addBatch();
                ps.executeBatch();
            }

            // fastest approach as it does not need to issue additional query for metadata
            sql = String.format("insert into %1$s select a, b from input('a String, b Nullable(String)')", table);
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "a");
                ps.setString(2, "b");
                ps.addBatch();
                ps.setString(1, "c");
                ps.setString(2, null);
                ps.addBatch();
                ps.executeBatch();
            }
        }
    }

    static int query(String url, String user, String password, String table) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from " + table)) {
            while (rs.next()) {
                ResultSetMetaData metaData = rs.getMetaData();
                String columnName1 = metaData.getColumnName(1);
                String columnName2 = metaData.getColumnName(2);
                String columnName3 = metaData.getColumnName(3);
                String columnName4 = metaData.getColumnName(4);

                String columnValue1 = rs.getString(columnName1);
                String columnValue2 = rs.getString(columnName2);
                String columnValue3 = rs.getString(columnName3);
                String columnValue4 = rs.getString(columnName4);

                System.out.println("进行数据展示：\n");
                System.out.println(columnName1 + "\t" + columnName2 + "\t" + columnName3 + "\t" + columnName4);
                System.out.println(columnValue1 + "\t" + columnValue2 + "\t" + columnValue3 + "\t" + columnValue4);
            }


            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println(metaData);

            int count = 0;
            while (rs.next()) {
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
//        String url = String.format("jdbc:ch://localhost:8023/helloworld", System.getProperty("chHost", "localhost"),
//                Integer.parseInt(System.getProperty("chPort", "8123")));
//        String user = System.getProperty("chUser", "default");
//        String password = System.getProperty("chPassword", "");
//        String table = "jdbc_example_basic";

        String url = "jdbc:ch://localhost:8123/helloworld";
        String user = "";
        String password = "";
        String table = "my_first_table";


        try {
//            dropAndCreateTable(url, user, password, table);
//            batchInsert(url, user, password, table);
            query(url, user, password, table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
