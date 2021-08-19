package com.fc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fc.entity.UserEntity;
import com.fc.request.user.UserQueryParam;
import com.fc.response.UserVo;

public interface IUserService extends IService<UserEntity> {

    UserVo login(UserQueryParam queryParam);
}
