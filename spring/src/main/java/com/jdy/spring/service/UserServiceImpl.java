package com.jdy.spring.service;

import com.jdy.spring.dao.JUser;
import com.jdy.spring.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JUser user = userMapper.readUser(username);
        user.setAuthorities(getAuthorities(username));
        return user;
    }

    public Collection<GrantedAuthority> getAuthorities(String username) {
       /* List<String> string_authorities = userMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;*/
        Collection<GrantedAuthority> authorities = userMapper.readAuthority(username);
        return authorities;
    }

    @Override
    public JUser readUser(String username) {
        JUser user = userMapper.readUser(username);
        user.setAuthorities(userMapper.readAuthority(username));
        return user;
    }

    @Override
    public void createUser(JUser user) {
        String rawPassword = user.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        user.setPassword(encodedPassword);
        userMapper.createUser(user);
        userMapper.createAuthority(user);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
        userMapper.deleteAuthority(username);
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}
