package com.du2du.chat_box.model.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.du2du.chat_box.model.dto.list.UserChatDTO;
import com.du2du.chat_box.model.entity.impl.User;
import com.du2du.chat_box.model.repository.UserRespository;

@Service
public class ChatService {

  @Autowired
  UserRespository userRespository;

  public ResponseEntity<UserChatDTO> searchUser(String name) {
    User user = userRespository.findByName(name);
    if (Objects.isNull(user))
      return ResponseEntity.notFound().build();
    UserChatDTO dto = new UserChatDTO(user);
    // dto.setLastOnline();
    return ResponseEntity.ok(dto);
  }

}
