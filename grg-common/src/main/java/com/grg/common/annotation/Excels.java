package com.grg.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (C), 2010-2020, 广州广电运通智能科技有限公司
 * @fileName:     Excels.java
 * @author:       Lee
 * @date:         2020/3/6 10:48
 * @description:  Excel注解集
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号            描述
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excels
{
    Excel[] value();
}