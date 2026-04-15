package org.example.arkbackend;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.lang.model.element.NestingKind;

/**
 * 注册 bean
 */
@Data
public class UserRegisterDTO {

    @NotBlank(message ="注册名不能为空")
    private String userName ;

    @NotBlank(message = "密码不能为空")
    private String password ;

}
