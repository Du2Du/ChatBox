package com.du2du.chat_box.model.dto.list;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.du2du.chat_box.model.entity.impl.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserChatDTO {

  UUID uuid;
  ZonedDateTime lastOnline;
  String name;
  String profilePicture;

  public UserChatDTO(User user) {
    this.uuid = user.getUuid();
    this.name = user.getName();
    this.profilePicture = user.getProfilePicture();
  }

}
