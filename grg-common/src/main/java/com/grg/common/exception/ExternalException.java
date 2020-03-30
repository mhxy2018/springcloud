package com.grg.common.exception;

import com.grg.common.enumeration.ResponseCode;
import com.grg.common.exception.base.BaseException;

/**
 * Copyright (C), 2010-2020, 广州广电运通智能科技有限公司
 *
 * @fileName: ExternalException.java
 * @author: Lee
 * @date: 2020/3/5 15:59
 * @description: 自定义外部接口异常
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号            描述
 */
public class ExternalException extends BaseException {

    public ExternalException(String respId, ResponseCode responseCode) {
        super(respId, responseCode);
    }

    public ExternalException(String respId, ResponseCode responseCode, String msg) {
        super(respId, responseCode, msg);
    }

}

