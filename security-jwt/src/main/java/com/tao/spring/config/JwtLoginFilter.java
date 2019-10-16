package com.tao.spring.config;

import com.tao.spring.service.UserService;
import com.tao.spring.util.JwtTokenUtil;
import com.tao.spring.util.ResponseUtil;
import com.tao.spring.wrapper.Status;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 处理登录请求
 *
 * @author DongTao
 * @since 2019-10-14
 */
@Slf4j
@Component
public class JwtLoginFilter extends OncePerRequestFilter {

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/**/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // other public endpoints of your API may be appended to this array
            "/login"
    };

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        if (request.getRequestURI().contains("js") || request.getRequestURI().contains("css")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (Arrays.asList(AUTH_WHITELIST).contains(request.getRequestURI())
                || request.getRequestURI().contains("/v2/api-docs")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = JwtTokenUtil.getJwtFromRequest(request);

        if (StringUtils.isNotBlank(jwt)) {
            try {
                String username = JwtTokenUtil.getProperties(jwt);

                UserDetails userDetails = userService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } catch (SecurityException e) {
                log.error(e.getMessage());
            }
        } else {
            ResponseUtil.renderJson(response, Status.UNAUTHORIZED, null);
        }

    }
}
