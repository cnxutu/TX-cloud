package com.example.common.utils;


import javax.servlet.http.HttpServletRequest;

/**
 * @author xutu
 * @since 2022-06-27
 * 用户请求工具类
 */
public class RequestUtil {


    /**
     * 获取当前请求的用户标识
     *
     * @return
     */
    public static Long getRequestUserId() {
        HttpServletRequest request = WebUtil.getRequest();
        if (null != request) {
            return JwtUtil.getUserId(request);
        }
        return null;
    }

    /**
     * 获取设备标识
     *
     * @return
     */
    public static String getRequestGid() {
        HttpServletRequest request = WebUtil.getRequest();
        if (null != request) {
            return request.getHeader("X-Session-Id");
        }
        return "";
    }

    /**
     * 获取request lock ID
     *
     * @return
     */
    public static String getRequestId() {
        HttpServletRequest request = WebUtil.getRequest();
        return request.getAttribute(WebUtil.LOCK_REQUEST_ID).toString();
    }

    /**
     * 获取request token
     *
     * @return token
     */
    public static String getToken() {
        HttpServletRequest request = WebUtil.getRequest();
        if (null != request) {
            return JwtUtil.getToken(request);
        }
        return null;
    }
}
