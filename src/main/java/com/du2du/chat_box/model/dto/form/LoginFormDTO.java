package com.du2du.chat_box.model.dto.form;

import org.springframework.beans.factory.annotation.Value;

import com.password4j.Password;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginFormDTO {
  private String name;
  private String password;
}
