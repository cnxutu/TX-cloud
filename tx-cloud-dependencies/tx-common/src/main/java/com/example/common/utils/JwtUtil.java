package com.example.common.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author xutu
 * @since 2022-06-27
 * JWT工具类
 */
@Component
@Data
@Slf4j
public class JwtUtil {
    /**
     * JWT 添加至HTTP HEAD中的前缀
     */
    private static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 请求头中JWT信息的HeaderName
     */
    public static final String AUTH_HEADER = "Authorization";
    /**
     * 失效时间，7天，单位：秒
     */
    public static final String DURATION = "604800";
    /**
     * 失效时间，2天，单位：秒
     */
    public static final String DURATION_TWO_DAY = "172800";
    /**
     * 失效时间，30分钟，单位：秒
     */
    public static final String THIRD_DURATION = "1800";
    /**
     * 混淆MD5签名用的随机字符串
     */
    public static final String MD5_KEY = "randomKey";

    public static final String secret = "defaultSecret";

    public static final String USER_ID = "userId";
    /**
     * 是否是app登录，是则加入该字段
     */
    public static final String IS_APP = "app";
    /**
     * 是否是小程序用户登录，是则加入该字段
     */
    public static final String IS_MINI_PROGRAM = "mini_program";

    /**
     * 是否是超级管理员
     */
    public static final String IS_ADMIN = "admin";

    public static final String SOURCE = "source";


    /**
     * 加密密钥明文
     */
    private static String jwtPlainSecret;
    /**
     * 加密密钥key
     */
    private static SecretKey jwtSecretKey;


    /**
     * 解析token是否正确,不正确会报异常<br>
     */
    public static void parseToken(String token) throws JwtException {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 获取jwt中的userId
     */
    public static Long getUserId(String token) {
        if (null == getClaimFromToken(token) || null == getClaimFromToken(token).get(USER_ID)) {
            return null;
        }
        return Long.parseLong(getClaimFromToken(token).get(USER_ID).toString());
    }

    /**
     * 通过请求头获取jwt中的userId
     */
    public static Long getUserId(HttpServletRequest request) {
        String token = getToken(request);
        return getUserId(token);
    }

    /**
     * 通过请求头获取token
     */
    public static String getToken(HttpServletRequest request) {
        return request.getHeader(AUTH_HEADER);
    }


    /**
     * 判断是否是小程序用户登录
     *
     * @param token token
     * @return true：小程序用户，false：非小程序用户
     */
    public static boolean isMiniProgram(String token) {
        return null != getClaimFromToken(token).get(IS_MINI_PROGRAM);
    }

    /**
     * 判断是否是App用户登陆
     *
     * @param token token
     * @return true：小程序用户，false：非小程序用户
     */
    public static boolean isAPP(String token) {
        return null != getClaimFromToken(token).get(IS_APP);
    }


    /**
     * 获取jwt的payload部分
     */
    public static Claims getClaimFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取jwt失效时间
     */
    public static Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token).getExpiration();
    }

    /**
     * <pre>
     *  验证token是否失效
     *  true:过期   false:没过期
     * </pre>
     */
    public static Boolean isTokenExpired(String token) {
        try {
            final Date expiration = getExpirationDateFromToken(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    /**
     * 生成token(通过用户名和签名时候用的随机数)
     */
    public static String generateToken(String account, Map<String, Object> claims) {
        claims.put(MD5_KEY, claims.get("randomKey"));
        return doGenerateToken(claims, account);
    }

    /**
     * 生成token(通过用户名和签名时候用的随机数)
     */
    public static String generateMiniProgramToken(String account, Map<String, Object> claims) {
        claims.put(MD5_KEY, claims.get("randomKey"));
        return doGenerateTwoDayToken(claims, account);
    }

    /**
     * 生成token
     */
    private static String doGenerateTwoDayToken(Map<String, Object> claims, String subject) {
        // jwt的签发时间
        Date iat = new Date();
        // jwt的过期时间
        Date expirationDate = DateUtil.offset(iat, DateField.SECOND, Integer.parseInt(JwtUtil.DURATION_TWO_DAY));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(iat)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成token
     */
    private static String doGenerateToken(Map<String, Object> claims, String subject) {
        // jwt的签发时间
        Date iat = new Date();
        // jwt的过期时间
        Date expirationDate = DateUtil.offset(iat, DateField.SECOND, Integer.parseInt(JwtUtil.DURATION));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(iat)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 获取混淆MD5签名用的随机字符串
     */
    public static String getRandomKey() {
        return getRandomString(6);
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
