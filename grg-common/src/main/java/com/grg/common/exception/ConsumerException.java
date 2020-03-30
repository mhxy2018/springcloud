package com.grg.common.exception;


import com.grg.common.enumeration.ResponseCode;
import com.grg.common.exception.base.BaseException;

/**
 * Copyright (C), 2010-2020, 广州广电运通智能科技有限公司
 *
 * @fileName: ConsumerException.java
 * @author: Lee
 * @date: 2020/3/5 15:45
 * @description: 自定义异常
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号            描述
 */
public class ConsumerException extends BaseException {

    public ConsumerException(ResponseCode responseCode) {
        super(responseCode);
    }

    public ConsumerException(ResponseCode responseCode, String msg) {
        super(responseCode, msg);
    }

}
