package io.github.returntmp.titanms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName(value = "tbl_opitem")
public class OpItem {
    @TableId(type = IdType.AUTO)//自增的id生成策略
    private int id;//操作项目id
    private Integer op;//操作术语
    @TableField(value = "ob_type")
    private Integer obType;//应用设备种类
    @TableField(value = "ob_name")
    private String obName;//应用设备的名称
    @TableField(value = "op_description")
    private String opDescription;//操作的额外说明
    @TableField(value = "secure_description")
    private String secureDescription;//保障操作的描述
    @TableField(value = "complete_time")
    private Date completeTime;//操作完成时间

}
