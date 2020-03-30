package com.grg.common.dto.input;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @fileName: BaseAdd
 * @author: Lee
 * @date: 2020/3/18 12:34
 * @description: 基础添加类
 * @version: v1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(description = "基础添加类")
public class BaseAdd  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", hidden = true)
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建日期", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
