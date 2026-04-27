package org.example.arkbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.arkbackend.entity.User;

@Mapper
public interface UserMapper {
    /**
     * 根据ID查询用户
     */
    User selectById(Long id);

    /**
     * 根据用户名查询用户
     */
    User selectByUsername(String username);

    /**
     * 新增用户
     */
    int insert(User user);

    /**
     * 更新用户
     */
    int updateByUser(User user);

    /**
     * 删除用户
     */
    int deleteById(Long id);

}
