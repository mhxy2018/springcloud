package com.grg.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @fileName: BaseEntity
 * @author: Lee
 * @date: 2020/3/13 16:46
 * @description: 基础实体类
 * @version: v1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "基础实体类")
public class BaseEntity<T> extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", hidden = true)
    protected String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建日期", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @TableField(fill = FieldFill.INSERT)
    protected Date createTime;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", hidden = true)
    protected String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @TableField(fill = FieldFill.UPDATE)
    protected Date updateTime;

}
