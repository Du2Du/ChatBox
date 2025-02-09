package com.du2du.chat_box.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.du2du.chat_box.model.dto.form.LoginFormDTO;
import com.du2du.chat_box.model.service.AuthenticationService;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  AuthenticationService bo;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginFormDTO dto) {
    return bo.authenticateUser(dto);
  }

}
