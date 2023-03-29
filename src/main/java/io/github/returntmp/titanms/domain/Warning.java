package io.github.returntmp.titanms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "tbl_warning")
public class Warning {
    @TableId(type = IdType.ASSIGN_ID)//雪花算法生成id
    private Long id;
    @TableField(value = "ticket_id")
    private Long ticketId;//告警所对应的操作票id
    @TableField(value = "warning_flag")
    private int flag;//0表示服装上的告警、1表示操作上的告警
    @TableField(value = "warning_desc")
    private String description;//哪一种类型的告警
    /*
    * flag:0
    *   0:安全帽
    *   1:工作服
    *   2:绝缘手套
    * flag:1
    *   id:操作项目的id
    * */
    @TableField(value = "warning_time")
    private Date time;//告警时间
}
