package org.example.arkbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.arkbackend.dto.UserRegisterDTO;
import org.example.arkbackend.dto.UserUpdateDTO;
import org.example.arkbackend.exception.BusinessException;
import org.example.arkbackend.service.UserService;
import org.example.arkbackend.common.Result;
import org.example.arkbackend.common.ResultCodeEnum;
import org.example.arkbackend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户增删改查接口
 *
 * @author markWu
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //get请求 （条件查询）
    @GetMapping("/info")
    public Result<UserVO> getUser(@RequestParam String username) {
        UserVO user = userService.getUserByName(username);
        if (user == null) {
            return Result.fail(ResultCodeEnum.USER_NOT_FOUND);
        }
        return Result.success(user);
    }

    //get请求 （查单个资源）
    @GetMapping("/info/{id}")
    public Result<UserVO> getUserInfo(@PathVariable Long id) {
        UserVO user = userService.getUserById(id);
        if (user == null) {
            return Result.fail(ResultCodeEnum.USER_NOT_FOUND);
        }
        return Result.success(user);
    }

    //post请求
    @PostMapping("/register")
    public Result<String> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        String result = userService.register(userRegisterDTO);
        return Result.success(result);
    }

    //put请求
    @PutMapping("/update")
    public Result<String> update(@RequestBody UserUpdateDTO dto) {
        String result = userService.updateUser(dto);
        return Result.success(result);
    }

    //delete请求
    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
//        return "删除用户：" + id;

        if (id <= 0) {
//            return Result.fail("id不合法");
            return Result.fail(ResultCodeEnum.PARAM_ERROR, "id不合法");
        }

        if (id == 999) {
            throw new BusinessException(ResultCodeEnum.USER_NOT_FOUND);
        }

        userService.deleteUser(id);
        return Result.success(null);

    }


}
