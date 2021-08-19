package com.fc.controller;

import com.fc.request.user.UserQueryParam;
import com.fc.response.UserVo;
import com.fc.service.IUserService;
import com.fc.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value = "user", tags = "用户管理模块", description = "编写者:代登科")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public R<UserVo> login(@Validated @RequestBody UserQueryParam queryParam){
        String userName = userService.login(queryParam).getUserName();
        return  R.to(userService.login(queryParam));
    }

}
