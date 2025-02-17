package com.du2du.chat_box.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.du2du.chat_box.model.dto.form.UserFormDTO;
import com.du2du.chat_box.model.service.UserService;



@Controller
@RequestMapping("/v1/user")
public class UserController {

  @Autowired
  UserService userService;
  
  @PutMapping("update/{uuid}")
  public ResponseEntity<UserFormDTO> updateUserEntity(@PathVariable("uuid") UUID uuid, @RequestBody UserFormDTO entity) {
      return userService.updateUser(uuid, entity);
  }
}
