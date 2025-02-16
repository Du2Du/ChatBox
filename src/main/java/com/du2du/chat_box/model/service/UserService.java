package com.du2du.chat_box.model.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.du2du.chat_box.model.dto.form.UserFormDTO;
import com.du2du.chat_box.model.entity.impl.User;
import com.du2du.chat_box.model.repository.UserRespository;

@Service
public class UserService {

  @Autowired
  UserRespository userRespository;

  @Transactional
  public ResponseEntity<UserFormDTO> updateUser(UUID uuid, UserFormDTO dto) {
    User user = userRespository.getReferenceById(uuid);
    if (Objects.isNull(user))
      return ResponseEntity.notFound().build();
    user.setName(dto.getName());
    user.setProfilePicture(dto.getProfilePicture());
    user.setBirthDate(dto.getBirthDate());
    userRespository.save(user);
    return ResponseEntity.ok(dto);
  }
}
