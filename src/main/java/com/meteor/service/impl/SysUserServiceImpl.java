package com.meteor.service.impl;

import com.meteor.annotation.SimpleAutowired;
import com.meteor.annotation.SimpleService;
import com.meteor.dao.SysUserMapper;
import com.meteor.domain.SysUser;
import com.meteor.service.SysUserService;

/**
 * @ClassName SysUserServiceImpl
 * @Description: TODO
 * @Author Admin
 * @Date 2021/5/3
 * @Version V1.0
 **/
@SimpleService("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @SimpleAutowired("sysUserMapper")
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(long userId) {
        return sysUserMapper.getUser(userId);
    }

}
