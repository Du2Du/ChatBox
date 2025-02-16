package com.du2du.chat_box.model.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.du2du.chat_box.model.entity.impl.User;

public interface UserRespository extends JpaRepository<User, UUID>{
  User findByName(String name);
}
