package com.xw.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        logger.error("",ex);
        try (OutputStream outputStream = response.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream);) {
            if (ex instanceof BusinessException) {
                writer.write("业务异常");
            } else if (ex instanceof ParameterException) {
                writer.write("参数异常");
            } else {
                writer.write("系统内部异常");
            }
        } catch (IOException e) {
            logger.error("", e);
        }
        return null;
    }
}