package com.du2du.chat_box.model.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.du2du.chat_box.model.dto.form.LoginFormDTO;
import com.du2du.chat_box.model.entity.impl.User;
import com.du2du.chat_box.model.repository.UserRespository;

import ch.qos.logback.core.subst.Token;

@Service
public class AuthenticationService {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRespository userRespository;

  @Autowired
  TokenService tokenService;

  public ResponseEntity<?> authenticateUser(LoginFormDTO dto) {
    UserDetails user = userRespository.findByName(dto.getName());

    if (Objects.isNull(user))
      user = this.registerUser(dto);
    return authenticate(dto);
  }

  public ResponseEntity<?> authenticate(LoginFormDTO dto) {
    try {
      UsernamePasswordAuthenticationToken userPass = new UsernamePasswordAuthenticationToken(dto.getName(),
          dto.getPassword());
      Authentication authentication = this.authenticationManager.authenticate(userPass);

      String token = tokenService.generateToken((User) authentication.getPrincipal());
      return ResponseEntity.ok(token);
    } catch (AuthenticationException exception) {
      return ResponseEntity.internalServerError()
          .body("Bad credentials".equalsIgnoreCase(exception.getMessage()) ? "Senha inválida" : exception.getMessage());
    }
  }

  @Transactional
  public User registerUser(LoginFormDTO dto) {
    User entity = userRespository.save(User.builder()
        .name(dto.getName())
        .password(new BCryptPasswordEncoder().encode(dto.getPassword()))
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build());
    return entity;
  }
}
