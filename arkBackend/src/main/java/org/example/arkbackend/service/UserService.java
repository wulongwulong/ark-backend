package org.example.arkbackend.service;

import org.example.arkbackend.vo.UserVO;
import org.example.arkbackend.dto.UserRegisterDTO;
import org.example.arkbackend.dto.UserUpdateDTO;

/**
 * 用户服务接口
 *
 * <p>负责用户相关的业务逻辑定义，包括：
 * <ul>
 *     <li>用户注册</li>
 *     <li>用户查询</li>
 *     <li>用户删除</li>
 * </ul>
 *
 * @author markWu
 * @since 2026-04-22
 */
public interface UserService {
    /**
     * 根据用户ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserVO getUserById(Long id);

    /**
     * 根据用户名查询用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    UserVO getUserByName(String name);

    /**
     * 用户注册
     *
     * @param dto 注册信息
     * @return 注册结果
     */
    String register(UserRegisterDTO dto);


    /**
     * 更新用户信息
     *
     * @param dto 用户更新信息
     * @return 更新结果
     */
    String updateUser(UserUpdateDTO dto);


    /**
     * 根据用户ID删除用户
     *
     * @param id 用户ID
     */
    Boolean deleteUser(Long id);

}
