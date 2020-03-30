package com.grg.common.dto.output;

import com.grg.common.enumeration.ResponseCode;
import com.grg.common.exception.base.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @fileName: Response
 * @author: Lee
 * @date: 2020/3/18 12:34
 * @description: 响应类
 * @version: v1.0.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Response", description = "返回参数")
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 3L;

    @ApiModelProperty(value = "返回码", required = true, example = "100000")
    private String code;

    @ApiModelProperty(value = "返回消息", required = true, example = "success")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public Response() {
        this.code = ResponseCode.SUCCESS.getValue();
        this.msg = ResponseCode.SUCCESS.getDisplayName();
    }

    /**
     * 更改错误码
     *
     * @param responseCode 响应码枚举
     * @return Response
     */
    public Response<T> err(ResponseCode responseCode) {
        this.code = responseCode.getValue();
        this.msg = responseCode.getDisplayName();
        return this;
    }

    public Response<T> error(BaseException be) {
        this.code = be.getCode();
        this.msg = be.getMsg();
        return this;
    }


    public Response<T> code(String code) {
        this.setCode(code);
        return this;
    }

    public Response<T> msg(String message) {
        this.setMsg(message);
        return this;
    }

    public Response<T> data(T data) {
        this.setData(data);
        return this;
    }
}
