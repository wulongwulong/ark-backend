package org.example.arkbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 注册 bean
 */
@Data
public class UserRegisterDTO {

    @NotBlank(message ="注册名不能为空")
    private String username ;

    @NotBlank(message = "密码不能为空")
    private String password ;

}
