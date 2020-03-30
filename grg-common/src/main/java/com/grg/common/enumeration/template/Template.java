package com.grg.common.enumeration.template;

/**
 * @fileName: Template
 * @author: Lee
 * @date: 2020/3/16 9:37
 * @description: 枚举接口
 * @version: v1.0.0
 */
public interface Template extends BaseTemplate {

    /**
     * 是否成功
     *
     * @return success 是否成功
     */
    boolean isSuccess();

    /**
     * descEn
     *
     * @return descEn 英文描述
     */
    String getDescEn();

}
