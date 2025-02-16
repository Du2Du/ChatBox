package com.du2du.chat_box.model.dto.form;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

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
public class UserFormDTO {
  UUID uuid;
  String name;
  String profilePicture;
  LocalDate birthDate;
}
