package org.example.arkbackend;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    //get请求 （条件查询）
    @GetMapping("/info")
    public Map<String, Object>  getUser(@RequestParam String username) {

        Map<String, Object> result = new HashMap<>();
        result.put("id", 123);
        result.put("name", username);

        return result;
    }

    //get请求 （查单个资源）
    @GetMapping("/info/{id}")
    public  Map<String, Object> getUserInfo(@PathVariable Long id) {
//        System.out.println("id: " + id);
//        return "用户ID是：" + id;
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", "test");

        return result;
    }

    //post请求
    @PostMapping("/register")
    public String register(@Valid @RequestBody UserRegisterDTO userRegisterDTO){
        System.out.println("接口被调用了");
        return "12345";
    }

    //put请求
    @PutMapping("/update")
    public String update(@RequestBody UserRegisterDTO dto) {
        return "更新：" + dto.getUserName();
    }

    //delete请求
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "删除用户：" + id;
    }


}
