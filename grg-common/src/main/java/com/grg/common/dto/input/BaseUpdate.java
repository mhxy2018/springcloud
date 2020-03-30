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
 * @fileName: BaseUpdate
 * @author: Lee
 * @date: 2020/3/18 12:33
 * @description: 基础更新类
 * @version: v1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(description = "基础更新类")
public class BaseUpdate implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", hidden = true)
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
