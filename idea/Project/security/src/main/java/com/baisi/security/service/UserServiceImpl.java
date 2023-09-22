package com.baisi.security.service;
import com.baisi.security.entity.User;
import com.baisi.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 用户业务层实现
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<GrantedAuthority> roles =
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
//        return new User("cxk", new BCryptPasswordEncoder().encode("123"),roles);
//    }

    public List<User> getAll() {
        List<com.baisi.security.entity.User> d =  userMapper.getAll();
        return d;
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public Integer add(User user) {
        return userMapper.add(user);
    }

    @Override
    public Integer remove(Integer id) {
        return userMapper.remove(id);
    }

    @Override
    public List<Integer> getByIds(Integer userId) {
        return userMapper.getByIds(userId);
    }

}
