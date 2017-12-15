package com.jdy.spring.service;

import com.jdy.spring.dao.JUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

public interface UserService extends UserDetailsService {
    Collection<GrantedAuthority> getAuthorities(String username);

    public JUser readUser(String username);

    public void createUser(JUser user);

    public void deleteUser(String username);

    public PasswordEncoder passwordEncoder();

}
