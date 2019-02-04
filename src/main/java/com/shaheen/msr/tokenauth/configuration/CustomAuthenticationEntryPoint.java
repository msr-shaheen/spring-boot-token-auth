package com.shaheen.msr.tokenauth.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED);


        /*response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        log.info("AuthenticationException : {}",response.getHeader("error"));
        Map<String, Object> data = new HashMap<>();
        data.put(
                "timestamp22",
                Calendar.getInstance().getTime());
        data.put(
                "exception22",
                exception.getMessage());

        response.getOutputStream()
                .print(objectMapper.writeValueAsString(data));*/

    }
}
