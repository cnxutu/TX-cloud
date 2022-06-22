package com.example.springbootdemo.clickhouse.controller;


import com.clickhouse.jdbc.ClickHouseDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/clickhouse")
public class ClickHouseOpsController {


    @Value("${spring.clickhouse.url}")
    private String url;

    @Value("${spring.clickhouse.user}")
    private String user;

    @Value("${spring.clickhouse.password}")
    private String password;


    @GetMapping("/selectTest")
    public void selectTest() {

//        try {
//            int count = query(connection, "my_first_table");
//            System.out.println("查询到的记录数为：" + count);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    static int query(Connection conn, String table) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from " + table)) {
            int count = 0;
            while (rs.next()) {
                count++;
            }
            return count;
        }
    }


}
