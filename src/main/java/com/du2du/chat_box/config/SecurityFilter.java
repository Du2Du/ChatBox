package com.du2du.chat_box.config;

import java.io.IOException;
import java.util.Objects;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.du2du.chat_box.model.repository.UserRespository;
import com.du2du.chat_box.model.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  TokenService tokenService;

  @Autowired
  UserRespository userRespository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String token = recoverToken(request);
    if (Objects.nonNull(token)) {
      String subject = tokenService.validateToken(token);
      UserDetails user = userRespository.findByName(subject);
      if (Objects.nonNull(user)) {
        UsernamePasswordAuthenticationToken authorization = new UsernamePasswordAuthenticationToken(user, null,
            user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authorization);
      }
    }
    filterChain.doFilter(request, response);
  }

  private String recoverToken(HttpServletRequest request) {
    String header = request.getHeader("Authorization");
    if (Objects.isNull(header))
      return null;
    return header.replace("Bearer ", "");
  }

}
