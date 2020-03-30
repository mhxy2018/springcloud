package com.grg.common.exception.base;

import com.grg.common.enumeration.ResponseCode;
import com.grg.common.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @fileName: BaseException
 * @author: Lee
 * @date: 2020/3/16 13:53
 * @description: 基础异常类
 * @version: v1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误代码
     */
    private ResponseCode responseCode;

    /**
     * 请求流水
     */
    private String respId;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    public BaseException() {
    }

    public BaseException(ResponseCode responseCode) {
        this.responseCode = responseCode;
        this.code = responseCode.getValue();
        this.msg = responseCode.getDisplayName();
    }

    public BaseException(ResponseCode responseCode, String msg) {
        this(responseCode);
        if (StringUtils.isNotEmpty(msg)) {
            this.msg = responseCode.getDisplayName() + " - <" + msg + ">";
        }
    }

    public BaseException(String respId, ResponseCode responseCode) {
        this(responseCode);
        if (StringUtils.isNotEmpty(respId)) {
            this.respId = respId;
        }
    }

    public BaseException(String respId, ResponseCode responseCode, String msg) {
        this(respId, responseCode);
        if (StringUtils.isNotEmpty(msg)) {
            this.msg = responseCode.getDisplayName() + " - <" + msg + ">";
        }
    }

    public BaseException(String respId, ResponseCode responseCode, String msg, Object[] args) {
        this(respId, responseCode, msg);
        this.args = args;
    }

    @Override
    public String getMessage() {
        if (StringUtils.isEmpty(msg)) {
            return responseCode.getDisplayName();
        }
        return msg;
    }
}
