package com.example.demo.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by Edi on 01-May-17.
 */
public class RequestHeaderAuthenticationFilterImpl extends RequestHeaderAuthenticationFilter {
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        //        super.unsuccessfulAuthentication(request, response, failed);
        //
        //        // see comments in Servlet API around using sendError as an alternative
        //        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}