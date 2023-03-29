package io.github.returntmp.titanms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "tbl_syslog")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 2713975405735052081L;
    @TableId(type = IdType.ASSIGN_ID)//雪花算法生成id
    private Long id;
    @TableField(value = "log_id")
    private String logId;//日志ID
    @TableField(value = "user_name")
    private String userName;//用户名字
    @TableField(value = "user_ip")
    private String userIp;//用户IP
    @TableField(value = "req_method")
    private String requestMethod;//请求方法
    @TableField(value = "req_desc")
    private String requestDesc;//方法描述
    @TableField(value = "ob_id")
    private Long obId;//操作对象的id
    @TableField(value = "creat_time")
    private Date createTime;//记录日期
}
