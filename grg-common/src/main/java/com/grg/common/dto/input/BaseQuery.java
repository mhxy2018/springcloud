package com.grg.common.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @fileName: BaseQuery
 * @author: Lee
 * @date: 2020/3/15 0:01
 * @description: 基础查询类
 * @version: v1.0.0
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "基础查询类")
public class BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 每页显示记录数 */
    @ApiModelProperty(value = "分页大小", example = "10")
    private int pageSize = 10;
    /** 当前记录起始索引 */
    @ApiModelProperty(value = "当前页", example = "1")
    private int pageNo = 1;
    /** 排序列 */
    @ApiModelProperty(value = "排序列", example = "updateTime")
    private String orderByColumn;
    /** 排序的方向 "desc" 或者 "asc". */
    @ApiModelProperty(value = "排序的方向(asc-1,desc-0)", example = "0")
    private Integer isAsc;

}
