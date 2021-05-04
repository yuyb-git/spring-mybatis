DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
                            `user_id` bigint(20) NOT NULL COMMENT '用户id',
                            `user_type` tinyint(4) NOT NULL COMMENT '用户类别,0-超级管理员;1-普通管理员;2-学校负责人;3-学生',
                            `role_code` varchar(30) NOT NULL COMMENT '角色编码',
                            `user_name` varchar(30) NOT NULL COMMENT '用户名',
                            `user_pwd` varchar(32) NOT NULL COMMENT '密码',
                            `real_name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
                            `nick_name` varchar(30) NOT NULL DEFAULT '' COMMENT '昵称',
                            `user_sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别,0-女;1-男;2-保密',
                            `identity_number` varchar(20) NOT NULL DEFAULT '' COMMENT '身份证号码',
                            `user_phone` varchar(14) NOT NULL DEFAULT '' COMMENT '手机',
                            `user_mail` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
                            `user_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态,0-正常;1-禁用',
                            `school_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '学校id',
                            `school_name` varchar(50) NOT NULL DEFAULT '' COMMENT '学校名称',
                            `college_name` varchar(30) NOT NULL DEFAULT '' COMMENT '学院名称',
                            `user_grade` char(5) NOT NULL DEFAULT '' COMMENT '年级',
                            `major_name` varchar(30) NOT NULL DEFAULT '' COMMENT '专业名称',
                            `class_name` varchar(30) NOT NULL DEFAULT '' COMMENT '班级名称',
                            `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0正常，1删除）',
                            `create_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `modify_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '修改人',
                            `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            PRIMARY KEY (`user_id`),
                            KEY `idx_scid` (`school_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理后台-用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_type`,`role_code`,`user_name`,`user_pwd`,`real_name`,`nick_name`,`user_sex`,`identity_number`,`user_phone`,`user_mail`,`user_status`,`school_id`,`school_name`,`college_name`,`user_grade`,`major_name`,`class_name`,`del_flag`,`create_user_id`,`create_time`,`modify_user_id`,`modify_time`) values
(1,0,'admin','admin','e10adc3949ba59abbe56e057f20f883e','超级管理员','123455',0,'','','123@qq.com',0,0,'','','','','',0,0,'2021-03-20 09:54:36',0,'2021-04-24 17:59:07'),
(573124890945937408,0,'admin','manager','e10adc3949ba59abbe56e057f20f883e','manager','',1,'','','123@qq.com',0,0,'','','','','',0,1,'2021-03-27 09:54:47',1,'2021-03-27 09:54:47'),
(573125897759252480,0,'admin','gly','e10adc3949ba59abbe56e057f20f883e','管理员','',0,'','','121',0,0,'','','','','',1,1,'2021-03-27 09:58:47',1,'2021-04-24 16:16:17'),
(573128747092566016,0,'admin','zz','e10adc3949ba59abbe56e057f20f883e','自动','',0,'','','zz',0,0,'','','','','',1,1,'2021-03-27 10:10:07',1,'2021-04-24 16:16:12');