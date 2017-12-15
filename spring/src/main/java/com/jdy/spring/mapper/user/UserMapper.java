package com.jdy.spring.mapper.user;

import com.jdy.spring.dao.JUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Mapper
public interface UserMapper {
    public JUser readUser(String username);

    public List<GrantedAuthority> readAuthority(String username);

    public void createUser(JUser user);

    public void createAuthority(JUser user);

    public void deleteUser(String username);

    public void deleteAuthority(String username);

}
