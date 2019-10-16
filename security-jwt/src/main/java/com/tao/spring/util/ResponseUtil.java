package com.tao.spring.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tao.spring.wrapper.ApiResponse;
import com.tao.spring.wrapper.BaseException;
import com.tao.spring.wrapper.IStatus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * response通用工具类
 *
 * @author XuYiCheng
 * @since 2019-09-19
 */
@Slf4j
public class ResponseUtil {


    /**
     * 往 response 写出 json
     *
     * @param response 响应
     * @param status 状态
     * @param data 返回数据
     */
    public static void renderJson(HttpServletResponse response, IStatus status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            response.getWriter()
                    .write(JSON.toJSONString(ApiResponse.ofStatus(status, data), false));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }

    /**
     * 往 response 写出 json
     *
     * @param response 响应
     * @param exception 异常
     */
    public static void renderJson(HttpServletResponse response, BaseException exception) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            response.getWriter()
                    .write(JSON.toJSONString(ApiResponse.ofException(exception), false));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }

    public static void write(HttpServletResponse response, Object o) {
        try {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            //json返回
            out.println(JSON.toJSONString(o, SerializerFeature.WriteMapNullValue));
            out.flush();
            out.close();
        } catch (Exception e) {
            log.error("e={}", e.getMessage());
        }
    }
}