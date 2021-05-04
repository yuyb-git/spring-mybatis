package com.meteor.service;

import com.meteor.domain.SysUser;

/**
 * @ClassName SysUserService
 * @Description: TODO
 * @Author Admin
 * @Date 2021/5/3
 * @Version V1.0
 **/
public interface SysUserService {

    SysUser getUser(long userId);

}
