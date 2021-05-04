/*
 * SysUser.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * Mon Mar 08 14:39:42 CST 2021 Created
 */
package com.meteor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @date   Mon Mar 08 14:39:42 CST 2021
 **/
public class SysUser implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户类别,0-超级管理员;1-普通管理员;2-学校负责人;3-学生
     */
    private Integer userType;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别,0-女;1-男;2-保密
     */
    private Integer userSex;

    /**
     * 身份证号码
     */
    private String identityNumber;

    /**
     * 手机
     */
    private String userPhone;

    /**
     * 邮箱
     */
    private String userMail;

    /**
     * 用户状态,0-正常;1-禁用
     */
    private Integer userStatus;

    /**
     * 学校id
     */
    private Long schoolId;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 学院名称
     */
    private String collegeName;

    /**
     * 年级
     */
    private String userGrade;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 删除标记（0正常，1删除）
     */
    private Integer delFlag;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long modifyUserId;

    /**
     * 修改时间
     */
    private Date modifyTime;

    //rivate static final long serialVersionUID = 4569376327507395584L;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户类别,0-超级管理员;1-普通管理员;2-学校负责人;3-学生
     *
     * @return user_type - 用户类别,0-超级管理员;1-普通管理员;2-学校负责人;3-学生
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类别,0-超级管理员;1-普通管理员;2-学校负责人;3-学生
     *
     * @param userType 用户类别,0-超级管理员;1-普通管理员;2-学校负责人;3-学生
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取角色编码
     *
     * @return role_code - 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编码
     *
     * @param roleCode 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return user_pwd - 密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置密码
     *
     * @param userPwd 密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取性别,0-女;1-男;2-保密
     *
     * @return user_sex - 性别,0-女;1-男;2-保密
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 设置性别,0-女;1-男;2-保密
     *
     * @param userSex 性别,0-女;1-男;2-保密
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取身份证号码
     *
     * @return identity_number - 身份证号码
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * 设置身份证号码
     *
     * @param identityNumber 身份证号码
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    /**
     * 获取手机
     *
     * @return user_phone - 手机
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置手机
     *
     * @param userPhone 手机
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取邮箱
     *
     * @return user_mail - 邮箱
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * 设置邮箱
     *
     * @param userMail 邮箱
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * 获取用户状态,0-正常;1-禁用
     *
     * @return user_status - 用户状态,0-正常;1-禁用
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态,0-正常;1-禁用
     *
     * @param userStatus 用户状态,0-正常;1-禁用
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取学校id
     *
     * @return school_id - 学校id
     */
    public Long getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校id
     *
     * @param schoolId 学校id
     */
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称
     *
     * @param schoolName 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * 获取学院名称
     *
     * @return college_name - 学院名称
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置学院名称
     *
     * @param collegeName 学院名称
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * 获取年级
     *
     * @return user_grade - 年级
     */
    public String getUserGrade() {
        return userGrade;
    }

    /**
     * 设置年级
     *
     * @param userGrade 年级
     */
    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * 获取专业名称
     *
     * @return major_name - 专业名称
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 设置专业名称
     *
     * @param majorName 专业名称
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    /**
     * 获取班级名称
     *
     * @return class_name - 班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置班级名称
     *
     * @param className 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取删除标记（0正常，1删除）
     *
     * @return del_flag - 删除标记（0正常，1删除）
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记（0正常，1删除）
     *
     * @param delFlag 删除标记（0正常，1删除）
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取创建人
     *
     * @return create_user_id - 创建人
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人
     *
     * @param createUserId 创建人
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return modify_user_id - 修改人
     */
    public Long getModifyUserId() {
        return modifyUserId;
    }

    /**
     * 设置修改人
     *
     * @param modifyUserId 修改人
     */
    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userType=").append(userType);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", userName=").append(userName);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", userSex=").append(userSex);
        sb.append(", identityNumber=").append(identityNumber);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userMail=").append(userMail);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", collegeName=").append(collegeName);
        sb.append(", userGrade=").append(userGrade);
        sb.append(", majorName=").append(majorName);
        sb.append(", className=").append(className);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyUserId=").append(modifyUserId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}