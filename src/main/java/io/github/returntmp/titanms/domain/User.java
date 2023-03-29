package io.github.returntmp.titanms.domain;

import com.baomidou.mybatisplus.annotation.TableField;

public class User {//现场侧登录
    private Integer id;
    private String userName;//用户名
    @TableField(value = "pwd",select = false)
    private String userPwd;//密码
}
