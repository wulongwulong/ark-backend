package org.example.arkbackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.arkbackend.vo.UserVO;
import org.example.arkbackend.dto.UserRegisterDTO;
import org.example.arkbackend.dto.UserUpdateDTO;
import org.example.arkbackend.entity.User;
import org.example.arkbackend.mapper.UserMapper;
import org.example.arkbackend.service.UserService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public String register(UserRegisterDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

//        // ✅ 在这里赋值
//        user.setCreateTime(LocalDateTime.now());

        userMapper.insert(user);
        return "注册成功";
    }

    @Override
    public String updateUser(UserUpdateDTO dto) {
        return "";
    }

    @Override
    public UserVO getUserById(Long id) {
        log.info("根据ID查询用户：{}", id);

        User user = userMapper.selectById(id);
        if (user == null) {
            return null;
        }

        return toVO(user);
    }

    @Override
    public UserVO getUserByName(String name) {
        log.info("根据用户名查询用户：{}", name);

        User user = userMapper.selectByUsername(name);
        if (user == null) {
            return null;
        }

        return toVO(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("删除用户：{}", id);
        userMapper.deleteById(id);
    }

    private UserVO toVO(User user) {
        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setCreateTime(user.getCreateTime());
        return vo;
    }
}
