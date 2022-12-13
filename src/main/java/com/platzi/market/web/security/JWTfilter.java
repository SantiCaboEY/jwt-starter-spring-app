package com.platzi.market.web.security;

import com.platzi.market.web.dto.ApiException;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTfilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTfilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        logger.info("jwt filter");
        if(token == null) {
            throw new ApiException("Authentication Header not found");
        }
        filterChain.doFilter(request, response);

    }
}
