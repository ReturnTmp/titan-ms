package io.github.returntmp.titanms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "tbl_ticket")
public class Ticket {
    @TableId(type = IdType.ASSIGN_ID)//雪花算法生成id
    private Long id;//操作票编号
    @TableField(value = "company_name")
    private String companyName;//公司名称
    private String task;//操作任务
    @TableField(value = "begin_time")
    private Date beginTime;//操作开始时间
    @TableField(value = "end_time")
    private Date endTime;//操作结束时间
    @TableField(value = "opitem_sealed")
    private String opItemSealed;//存入数据库的操作项目
    @TableField(exist = false)
    @JsonProperty(value = "opItem")
    private List<Integer> opItem;//操作项目，从数据库里面取出来的
    @TableField(exist = false)
    private List<OpItem> opItemList;//操作项目集合，用于前端展示，不存入数据库
    private String remark;//备注
    private String operator;//操作人
    private String guardian;//监护人
    private String charge;//值班负责人
    private String leader;//值长
    private String evaluation;//评价情况
    @TableField(value = "checker")
    private String checker;//检查人
    @TableField(value = "check_time")
    private Date checkTime;//检查时间
    @TableField(value = "ispost")
    private boolean isPost;//是否已经下发
}
