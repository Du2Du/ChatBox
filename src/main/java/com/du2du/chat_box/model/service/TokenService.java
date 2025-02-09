package com.du2du.chat_box.model.service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.du2du.chat_box.model.entity.impl.User;

@Service
public class TokenService {

  @Value("${token.secret}")
  String secretToken;

  public String generateToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretToken);
      String token = JWT.create().withIssuer("chat-box").withSubject(user.getName())
          .withExpiresAt(Date.from(this.getExpirationDateInstant())).sign(algorithm);
      return token;
    } catch (Exception e) {
      throw new RuntimeException("Erro ao gerar token de usuário");
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretToken);
      return JWT.require(algorithm).withIssuer("chat-box").build().verify(token).getSubject();
    } catch (Exception e) {
      throw new RuntimeException("Erro ao validar o token de usuário");
    }
  }

  private Instant getExpirationDateInstant() {
    return LocalDate.now().plusYears(100).atStartOfDay().toInstant(java.time.ZoneOffset.of("-03:00"));
  }
}
