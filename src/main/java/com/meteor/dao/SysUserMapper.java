/*
 * SysUserMapper.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * Mon Mar 08 14:39:42 CST 2021 Created
 */
package com.meteor.dao;

import com.meteor.annotation.SimpleRepository;
import com.meteor.domain.SysUser;

import java.util.List;

/**
 * @author Administrator
 */
@SimpleRepository("sysUserMapper")
public interface SysUserMapper{

    SysUser getUser(long userId);

    List<SysUser> getList();

    void updateUser(long userId);

}