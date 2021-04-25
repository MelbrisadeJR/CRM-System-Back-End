package com.melbrisade.project.exceptions;

import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MailExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attr = new HashMap<>();

        if (ex instanceof ServiceAccessException) {
            response.setStatus(HttpServletResponse.SC_OK);
            attr.put("code", ((ServiceAccessException) ex).get().getStatusCode());
            attr.put("message", ((ServiceAccessException) ex).get().getResponseMessage());
        } else if (ex instanceof WebApplicationException) {
            response.setStatus(((WebApplicationException) ex).getResponse().getStatus());
            attr.put("code", ((WebApplicationException) ex).getResponse().getStatus());
            attr.put("message", ((WebApplicationException) ex).getResponse().getEntity());
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            attr.put("code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            attr.put("message", ex.getMessage() == null ? ex : ex.getMessage());
            log.error("{ }", ex);
        }
        view.setAttributesMap(attr);
        modelAndView.setView(view);
        return modelAndView;
    }
}
