package zcs.oauthserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zcs.oauthserver.mapper.RoleMapper;
import zcs.oauthserver.mapper.UserMapper;
import zcs.oauthserver.model.User;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceDetail implements UserDetailsService {
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Autowired
    public UserServiceDetail(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", s);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        user.setAuthorities(roleMapper.selectByUserId(user.getId()));
        return user;
    }
}
