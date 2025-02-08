package com.du2du.chat_box.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/hello")
public class HelloController {
  
  @GetMapping
  public ResponseEntity<String> getMethodName(@RequestParam String param) {
      return ResponseEntity.ok("Ola");
  }
  
}
