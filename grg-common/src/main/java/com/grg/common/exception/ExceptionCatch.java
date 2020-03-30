package com.grg.common.exception;

import com.google.common.collect.ImmutableMap;
import com.grg.common.dto.output.Response;
import com.grg.common.enumeration.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * 统一异常捕获类，控制器增强
 *
 * @author Lee
 * @version v1.0
 * @date 2019/9/2 11:03
 */
@Slf4j
@ControllerAdvice
public class ExceptionCatch {

    /**
     * 定义map，配置异常类型所对应的错误代码
     */
    private static ImmutableMap<Class<? extends Throwable>, ResponseCode> exceptions;
    /**
     * 定义map的builder对象，去构建ImmutableMap
     */
    private static ImmutableMap.Builder<Class<? extends Throwable>, ResponseCode> builder = ImmutableMap.builder();

    /**
     * 捕获ConsumerException此类异常
     *
     * @param e 发生ConsumerException异常时进入此方法
     * @return 响应消息
     */
    @ExceptionHandler(ConsumerException.class)
    @ResponseBody
    public Response customException(ConsumerException e) {
        //记录日志
        log.error("catch consumerException:{}", ExceptionUtils.getStackTrace(e));
        return new Response().code(e.getCode()).msg(e.getMsg());
    }

    /**
     * 捕获NumberFormatException此类异常
     *
     * @param e 发生NumberFormatException异常时进入此方法
     * @return 响应消息
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public Response numberFormatException(NumberFormatException e) {
        //记录日志
        log.error("catch BindException:{}", ExceptionUtils.getStackTrace(e));
        String msg = ResponseCode.PARAM_FORMAT_ERROR.getDisplayName();
        return new Response().err(ResponseCode.PARAM_FORMAT_ERROR).msg(msg);
    }

    /**
     * 捕获MethodArgumentNotValidException此类异常
     *
     * @param e 发生MethodArgumentNotValidException异常时进入此方法
     * @return 响应消息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response methodArgumentNotValidException(MethodArgumentNotValidException e) {
        //记录日志
        log.error("catch MethodArgumentNotValidException:{}", ExceptionUtils.getStackTrace(e));
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        String msg = ResponseCode.PARAM_ERROR.getDisplayName() + " - " + message;
        return new Response().err(ResponseCode.PARAM_ERROR).msg(msg);
    }

    /**
     * 捕获BindException此类异常
     *
     * @param e 发生BindException异常时进入此方法
     * @return 响应消息
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Response bindException(BindException e) {
        //记录日志
        log.error("catch BindException:{}", ExceptionUtils.getStackTrace(e));
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
//        String messages = e.getAllErrors().get(0).getDefaultMessage()
//        log.debug("messages={}", messages)
        String msg = ResponseCode.PARAM_ERROR.getDisplayName();
        int msgLength = 20;
        if (StringUtils.isBlank(message)) {
            msg = msg + "";
        } else if (message.length() < msgLength) {
            msg += " - " + message;
        } else {
            String eName = "NumberFormatException";
            if (message.contains(eName)) {
                msg = ResponseCode.PARAM_FORMAT_ERROR.getDisplayName() + " - " + "参数类型错误";
                return new Response().err(ResponseCode.PARAM_FORMAT_ERROR).msg(msg);
            }
        }
        return new Response().err(ResponseCode.PARAM_ERROR).msg(msg);
    }

    /**
     * 捕获Exception此类异常
     *
     * @param e 发生Exception异常时进入此方法
     * @return 响应消息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exception(Exception e) {
        // 记录日志
        log.error("catch Exception:{}", ExceptionUtils.getStackTrace(e));
        if (exceptions == null) {
            // EXCEPTIONS构建成功
            exceptions = builder.build();
        }
        // 从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应9999异常
        ResponseCode resultCode = exceptions.get(e.getClass());
        if (resultCode != null) {
            return new Response().err(resultCode);
        } else {
            // 返回系统繁忙
            return new Response().err(ResponseCode.SYS_BUSY);
        }
    }

    static {
        // 定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class, ResponseCode.PARAM_INVALID);
        builder.put(NumberFormatException.class, ResponseCode.PARAM_FORMAT_ERROR);
        builder.put(HttpRequestMethodNotSupportedException.class, ResponseCode.REQUEST_NOT_SUPPORTED);
        exceptions = builder.build();
    }
}
