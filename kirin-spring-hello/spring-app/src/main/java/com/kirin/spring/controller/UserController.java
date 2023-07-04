package com.kirin.spring.controller;

import com.kirin.spring.anno.ApiVersion;
import com.kirin.spring.entitys.JsonResponse;
import com.kirin.spring.request.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/{v}/user")
@Slf4j
public class UserController {


    @PostMapping("/old/add")
    public JsonResponse oldAdd(@RequestBody UserRequest userRequest) {
        if (userRequest.getNickName() == null) {
            return JsonResponse.fail("user name should not be empty");
        } else if (userRequest.getNickName().length() < 1 || userRequest.getNickName().length() > 10) {
            return JsonResponse.fail("user name length should between 1-10");
        }
        if (userRequest.getAge() < 1 || userRequest.getAge() > 100) {
            return JsonResponse.fail("invalid age");
        }
        // ...
        return JsonResponse.success();
    }

    @PostMapping("/new/add")
    public JsonResponse newAdd(@Valid @RequestBody UserRequest userRequest) {
        // ...
        return JsonResponse.success();
    }

    @GetMapping("get")
    public UserRequest getUser() {
        return UserRequest.builder().age(18).nickName("kirin, default").build();
    }

    @ApiVersion("1.0.0")
    @GetMapping("get")
    public UserRequest getUserV1() {
        return UserRequest.builder().age(18).nickName("kirin, v1.0.0").build();
    }

    @ApiVersion("1.1.0")
    @GetMapping("get")
    public UserRequest getUserV11() {
        return UserRequest.builder().age(19).nickName("kirin, v1.1.0").build();
    }

    @ApiVersion("1.1.2")
    @GetMapping("get")
    public UserRequest getUserV112() {
        return UserRequest.builder().age(19).nickName("kirin, v1.1.2").build();
    }

}
