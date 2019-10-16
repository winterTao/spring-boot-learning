package com.tao.spring.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * @author DongTao
 * @since 2019-10-14
 */
public class JwtTokenUtil {

    /**
     * token名字
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * 前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 用户自定义密钥
     */
    public static final String SECRET = "jwt_secret_user_defined";
    public static final String ISS = "user_defined";

    /**
     * 过期时间 毫秒
     */
    public static final long EXPIRATION = 24L * 60L * 60L * 1000L;

    public static String createToken(String issuer, String subject, long expiration) {
        return createToken(issuer, subject, expiration, null);
    }

    /**
     * 创建 token
     *
     * @param issuer 签发人
     * @param subject 主体,即用户信息的JSON
     * @param expiration 有效时间(秒)
     * @param claims 自定义参数
     */
    public static String createToken(String issuer, String subject, long expiration,
            Claims claims) {
        return Jwts.builder()
                // JWT_ID：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
//                .setId(id)
                // 签名算法以及密匙
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 自定义属性
                .setClaims(null)
                // 主题：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userId，roleId之类的，作为用户的唯一标志。
                .setSubject(subject)
                // 受众
//                .setAudience(loginName)
                // 签发人
                .setIssuer(Optional.ofNullable(issuer).orElse(ISS))
                // 签发时间
                .setIssuedAt(new Date())
                // 过期时间
                .setExpiration(new Date(
                        System.currentTimeMillis() + (expiration > 0 ? expiration : EXPIRATION)))
                .compact();
    }

    /**
     * 从 token 中获取主题信息
     */
    public static String getProperties(String token) {
        return getTokenBody(token).getSubject();
    }

    /**
     * 校验是否过期
     */
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 获得 token 的 body
     */
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从 request 的 header 中获取 JWT
     *
     * @param request 请求
     * @return JWT
     */
    public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
