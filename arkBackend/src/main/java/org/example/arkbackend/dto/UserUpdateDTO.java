package org.example.arkbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank(message ="名不能为空")
    private String username;

    @NotBlank(message ="密码不能为空")
    private String password;
}