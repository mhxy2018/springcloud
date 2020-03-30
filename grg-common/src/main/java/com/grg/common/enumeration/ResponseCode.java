/*
 * *
 *   * Copyright (C), 2010-2019, 广州广电运通智能科技有限公司
 *   * FileName:     ResponseCode.java
 *   * Author:       wenzijian
 *   * Date:         12/25  8:50:24
 *   * History:
 *   * <author>      <time>          <version>          <desc>
 *   * 作者姓名       修改时间         版本号             描述
 *
 */

package com.grg.common.enumeration;

/**
 * Copyright (C), 2010-2020, 广州广电运通智能科技有限公司
 * @fileName:     ResponseCode.java
 * @author:       Lee
 * @date:         2020/3/16 9:35
 * @description:  系统返回码枚举类
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号            描述
 */
public enum ResponseCode   {

    // 通用类
    SUCCESS                   ("000000", "响应成功"),
    FAILED                    ("009999", "响应失败"),
    YES                       ("009998", "是"),
    NO                        ("009997", "否"),
    VALID                     ("009996", "有效"),
    INVALID 	              ("009995", "无效"),
    OPENED                    ("009994", "开启"),
    CLOSED                    ("009993", "停用"),
    MALE                      ("009992", "男"),
    FEMALE                    ("009991", "女"),

    //系统类
    SYS_ERROR                 ("000001", "系统错误"),
    SYS_BUSY                  ("000002", "系统繁忙"),
    L_SERVICE_ERROR           ("000003", "本地服务错误"),
    L_SERVICE_UNKNOWN         ("000004", "本地服务暂停"),
    R_SERVICE_ERROR           ("000005", "远程服务错误"),
    R_SERVICE_UNKNOWN         ("000006", "远程服务暂停"),
    JOB_EXPIRED               ("000007", "任务超时"),
    DATA_FORMAT_ERROR         ("000008", "无效的数据格式"),
    RPC_ERROR                 ("000009", "RPC调用错误"),
    REQUEST_NOT_SUPPORTED     ("000010", "不支持的http请求类型"),

    //签名类
    SIGN_MISS           	  ("001000", "缺少签名参数"),
    SIGN_INVALID			  ("001001", "无效签名"),
    SIGN_ADD_EXCEPTION        ("001002", "加签异常"),
    SIGN_ADD_FAILED           ("001003", "加签失败"),
    SIGN_MISMATCH             ("001998", "签名不匹配"),
    SIGN_FAILED               ("001999", "验签失败"),

    //参数类
    PARAM_ERROR               ("002000", "参数错误"),
    PARAM_MISS                ("002001", "缺少必选参数"),
    PARAM_INVALID             ("002002", "存在非法参数"),
    PARAM_FORMAT_ERROR        ("002003", "参数格式错误"),
    PARAM_VALUE_ERROR         ("002004", "参数值错误"),
    PARAM_VALUE_LARGE         ("002005", "参数内容过长"),

    //CRDB
    SQL_EXCEPTION             ("003000", "数据库操作异常"),
    QUERY_ERROR               ("003001", "查询失败"),
    INSERT_ERROR              ("003002", "添加失败"),
    UPDATE_ERROR              ("003003", "更新失败"),
    DELETE_ERROR              ("003004", "删除失败"),
    DATA_NOT_EXIST            ("003005", "数据不存在或查询结果为空"),
    DATA_IS_EXIST             ("003006", "数据已存在"),

    //EXCEPTION异常
    UNAUTHENTICATED_EXCEPTION ("003007", "未经身份验证"),
    INSUFFICIENT_PERMISSIONS  ("003008", "权限不足"),

    HEARTBEAT_NOT_EXIST       ("003009", "设备未接入心跳"),
    HEARTBEAT_OFF_LINE        ("003010", "设备已失去心跳"),
    CHILDREN_NOT_EMPTY        ("003011", "该地点下的出入口不为空"),
    DEVICE_ADDRESS_IS_EMPTY   ("003012", "设备安放地址为空，不允许启用操作"),

    //excel类
    IMPORT_ERROR              ("003101", "导入Excel失败"),
    IMPORT_FILE_EMPTY         ("003102", "上传文件为空"),
    EXPORT_ERROR              ("003103", "导出Excel失败"),




    ;

    private ResponseCode(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }
    private String value;

    private String displayName;

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }

}
