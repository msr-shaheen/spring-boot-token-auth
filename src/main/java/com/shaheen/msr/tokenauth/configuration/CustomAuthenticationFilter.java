package com.shaheen.msr.tokenauth.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@Slf4j
public class CustomAuthenticationFilter extends OncePerRequestFilter {
    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader(HEADER);
        if (header == null || !header.startsWith(PREFIX)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return ;

        }
        String user = "user1";
        //log.info("User : {} , Token : {}", user, header);

        if(!header.contains(".")){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return ;
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                user, null, getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


    private Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.asList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_USER";
            }
        });
    }
}
