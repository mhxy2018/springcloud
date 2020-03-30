package com.grg.common.enumeration.template;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: BaseTemplate
 * @author: Lee
 * @date: 2020/3/16 9:43
 * @description: 基础枚举接口
 * @version: v1.0.0
 */
public interface BaseTemplate<E extends Enum<?>, T> {

    /**
     * code
     *
     * @return code 枚举code
     */
    T getCode();

    /**
     * desc
     * @return desc 中文描述
     */
    String getDesc();

}
