package com.tao.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tao.spring.dto.RespBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, AccessDeniedException e)
            throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter out = httpServletResponse.getWriter();

        RespBean error = RespBean.error("权限不足，请联系管理员!");

        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }
}