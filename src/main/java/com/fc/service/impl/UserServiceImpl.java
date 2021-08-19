package com.fc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fc.entity.UserEntity;
import com.fc.mapper.UserMapper;
import com.fc.request.user.UserQueryParam;
import com.fc.response.UserVo;
import com.fc.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * @author ddk
 * @date 2021/8/15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements IUserService {


    @Override
    public UserVo login(UserQueryParam queryParam) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getUserName,queryParam.getUserName())
                .eq(UserEntity::getUserPassword,queryParam.getUserPassword());
        Integer count = super.baseMapper.selectCount(queryWrapper);
        Assert.isTrue(!(count<=0),"用户名或密码错误");
        UserEntity userEntity = super.baseMapper.selectOne(queryWrapper);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userEntity,userVo);
        //逻辑判空
        return userVo;
    }
}
