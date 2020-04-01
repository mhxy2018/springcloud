package com.grg.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.grg.common.dto.input.BaseAdd;
import com.grg.common.dto.input.BaseQuery;
import com.grg.common.dto.input.BaseUpdate;
import com.grg.common.dto.output.Response;
import com.grg.common.enumeration.ResponseCode;
import com.grg.common.exception.ConsumerException;
import com.grg.common.utils.excel.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2010-2020, 广州广电运通智能科技有限公司
 *
 * @author lye7
 * @date 2020/3/30 上午10:09
 * @description 控制器模板
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号            描述
 */
@Slf4j
@RestController
@RequestMapping("/xxx")
@Api(description = "xxx-前端控制器")
public class Example {

    @GetMapping(value = "/listPage")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息分页查询", notes = "xxx - xxx信息分页查询", httpMethod = "GET", response = Response.class)
    public <T> Response<T> listPage(BaseQuery dto) {
        try {
            log.debug("xxx - xxx信息分页查询");
            // 业务代码 TODO
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息分页查询失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.QUERY_ERROR);
        }
    }

    @GetMapping(value = "/getOne/{id}")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息详情查询", notes = "xxx - xxx信息详情查询", httpMethod = "GET", response = Response.class)
    @ApiImplicitParam(value = "xxx id", name = "id", required = true, example = "1")
    public <T> Response<T> getOne(@NotBlank(message = "{required}") @PathVariable String id) {
        try {
            log.debug("xxx - xxx信息详情查询");
            // 业务代码 TODO
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息详情查询失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.QUERY_ERROR);
        }
    }

    @PutMapping(value = "/update", produces = "application/json;charset=utf-8")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息更新", notes = "xxx - xxx信息更新", httpMethod = "PUT", response = Response.class)
    public <T> Response<T> update(@Valid @RequestBody BaseUpdate dto) {
        try {
            log.debug("xxx - xxx信息更新");
            // 业务代码 TODO
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息更新失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.UPDATE_ERROR);
        }
    }

    @PutMapping(value = "/enable", produces = "application/json;charset=utf-8")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息状态更新", notes = "xxx - xxx信息状态更新", httpMethod = "PUT", response = Response.class)
    public <T> Response<T> enable(@Valid @RequestBody BaseUpdate dto) {
        try {
            log.debug("xxx - xxx信息状态更新");
            // 业务代码 TODO
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息状态更新失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.UPDATE_ERROR);
        }
    }

    @PostMapping(value = "/add", produces = "application/json;charset=utf-8")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息添加", notes = "xxx - xxx信息添加", httpMethod = "POST", response = Response.class)
    public <T> Response<T> add(@Valid @RequestBody BaseAdd dto) {
        try {
            log.debug("xxx - xxx信息添加");
            // 业务代码 TODO
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息添加失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.INSERT_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json;charset=utf-8")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息删除", notes = "xxx - xxx信息删除", httpMethod = "DELETE", response = Response.class)
    public <T> Response<T> delete(@NotBlank(message = "{required}") @PathVariable String id) {
        try {
            log.debug("xxx - xxx信息删除");
            // 业务代码 TODO
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息删除失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.DELETE_ERROR);
        }
    }

    @PostMapping(value = "/exportTemplate", produces = "application/json;charset=utf-8")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息模板导出", notes = "xxx - xxx信息模板导出", httpMethod = "POST", response = Response.class)
    public <T> Response<T> exportExcelTemplate(HttpServletResponse resp) {
        try {
            log.debug("xxx - xxx信息模板导出");
            // 业务代码 TODO
            ExcelUtil<Object> excelUtil = new ExcelUtil<>(Object.class);
            excelUtil.exportExcel(null, resp, "object");
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息模板导出失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.EXPORT_ERROR);
        }
    }

    @PostMapping(value = "/export", produces = "application/json;charset=utf-8")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息导出", notes = "xxx - xxx信息导出", httpMethod = "POST", response = Response.class)
    public <T> Response<T> exportExcel(@Valid @RequestBody BaseQuery dto, HttpServletResponse resp) {
        try {
            log.debug("xxx - xxx信息导出");
            // 业务代码 TODO
            List<Object> rows = new ArrayList<>();
            ExcelUtil<Object> excelUtil = new ExcelUtil<>(Object.class);
            excelUtil.exportExcel(rows, resp, "object");
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息导出失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.EXPORT_ERROR);
        }
    }

    @PostMapping(value = "/import", produces = "application/json;charset=utf-8")
    @JsonView()
    @ApiOperation(value = "xxx - xxx信息导出", notes = "xxx - xxx信息导出", httpMethod = "POST", response = Response.class)
    public <T> Response<T> importExcel(MultipartFile file) {
        try {
            log.debug("xxx - xxx信息导入");
            if (file == null) {
                log.debug("xxx - xxx信息导入上传文件为空");
                return new Response<T>().err(ResponseCode.IMPORT_FILE_EMPTY);
            }
            ExcelUtil<Object> excelUtil = new ExcelUtil<>(Object.class);
            List<Object> rows = excelUtil.importExcel(file.getInputStream());
            // 业务代码 TODO
            return new Response<T>();
        } catch (ConsumerException ce) {
            return new Response<T>().error(ce);
        } catch (Exception e) {
            log.error("xxx - xxx信息导入失败：{}", ExceptionUtils.getStackTrace(e));
            return new Response<T>().err(ResponseCode.IMPORT_ERROR);
        }
    }


}
