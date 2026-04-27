package org.example.arkbackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.arkbackend.vo.UserVO;
import org.example.arkbackend.dto.UserRegisterDTO;
import org.example.arkbackend.dto.UserUpdateDTO;
import org.example.arkbackend.entity.User;
import org.example.arkbackend.mapper.UserMapper;
import org.example.arkbackend.service.UserService;
import org.springframework.dao.DuplicateKeyException;
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

        try {
            userMapper.insert(user);
            return "注册成功";
        } catch (DuplicateKeyException e) {
            return "用户名已存在";
        }

    }

    @Override
    public String updateUser(UserUpdateDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        int affectedRows = userMapper.updateByUser(user);

        if (affectedRows == 0) {
            return "用户不存在";
        }

        return "更新成功";
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
    public Boolean deleteUser(Long id) {
        log.info("删除用户：{}", id);
        int affectedRows = userMapper.deleteById(id);
        if (affectedRows == 0) {
            return false;
        }else {
            return true ;
        }

    }

    private UserVO toVO(User user) {
        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setCreateTime(user.getCreateTime());
        return vo;
    }
}
