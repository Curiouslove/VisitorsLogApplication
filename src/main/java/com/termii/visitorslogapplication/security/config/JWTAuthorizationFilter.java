package com.termii.visitorslogapplication.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.termii.visitorslogapplication.security.config.SecurityConstants.*;


@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);

        log.info(header);

        if(header == null || !header.startsWith(TOKEN_PREFIX)){
            log.info("header is null");
            chain.doFilter(request, response);
            return;
        }

        log.info("Setting security context");
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(request));

        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token = request.getHeader(HEADER_STRING);

        log.info("Token string -> {}", token);

        if(token != null){
            String username = JWT.require(Algorithm.HMAC512(SECRET.getBytes())).build().verify(token.replace(TOKEN_PREFIX, "")).getSubject();
            log.info("Username after detokenizing -> {}", username);

            if(username != null){
                log.info("Returning username password token ->");
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }

            return null;

        }

        return  null;
    }


}
