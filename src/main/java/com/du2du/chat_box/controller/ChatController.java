package com.du2du.chat_box.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.du2du.chat_box.model.dto.list.UserChatDTO;
import com.du2du.chat_box.model.service.ChatService;

@Controller
@RequestMapping("/v1/chat")
public class ChatController{

  @Autowired
  ChatService chatService;

  @GetMapping("search/user/{name}")
  public ResponseEntity<UserChatDTO> searchUser(@PathVariable("name") String name) {
      return chatService.searchUser(name);
  }
  
}