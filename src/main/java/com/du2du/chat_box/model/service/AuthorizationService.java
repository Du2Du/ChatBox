package com.du2du.chat_box.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.du2du.chat_box.model.repository.UserRespository;

@Service
public class AuthorizationService implements UserDetailsService {

  @Autowired
  UserRespository userRespository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRespository.findByName(username);
  }

}
