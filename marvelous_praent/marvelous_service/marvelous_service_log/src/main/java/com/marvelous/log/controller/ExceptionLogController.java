package com.marvelous.log.controller;
import com.marvelous.log.service.ExceptionLogService;
import pojo.ExceptionLog;
import com.github.pagehelper.PageInfo;
import marvelous.entity.Result;
import marvelous.entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:wuwenzhaoxi
 * @Description:
 * @Date 2020/7/7 1:52
 *****/
@Api(value = "ExceptionLogController")
@RestController
@RequestMapping("/exceptionLog")
@CrossOrigin
public class ExceptionLogController {

    @Autowired
    private ExceptionLogService exceptionLogService;

    /***
     * ExceptionLog分页条件搜索实现
     * @param exceptionLog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ExceptionLog条件分页查询",notes = "分页条件查询ExceptionLog方法详情",tags = {"ExceptionLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ExceptionLog对象",value = "传入JSON数据",required = false) ExceptionLog exceptionLog, @PathVariable  int page, @PathVariable  int size){
        //调用ExceptionLogService实现分页条件查询ExceptionLog
        PageInfo<ExceptionLog> pageInfo = exceptionLogService.findPage(exceptionLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ExceptionLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ExceptionLog分页查询",notes = "分页查询ExceptionLog方法详情",tags = {"ExceptionLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ExceptionLogService实现分页查询ExceptionLog
        PageInfo<ExceptionLog> pageInfo = exceptionLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param exceptionLog
     * @return
     */
    @ApiOperation(value = "ExceptionLog条件查询",notes = "条件查询ExceptionLog方法详情",tags = {"ExceptionLogController"})
    @PostMapping(value = "/search" )
    public Result<List<ExceptionLog>> findList(@RequestBody(required = false) @ApiParam(name = "ExceptionLog对象",value = "传入JSON数据",required = false) ExceptionLog exceptionLog){
        //调用ExceptionLogService实现条件查询ExceptionLog
        List<ExceptionLog> list = exceptionLogService.findList(exceptionLog);
        return new Result<List<ExceptionLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ExceptionLog根据ID删除",notes = "根据ID删除ExceptionLog方法详情",tags = {"ExceptionLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用ExceptionLogService实现根据主键删除
        exceptionLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ExceptionLog数据
     * @param exceptionLog
     * @param id
     * @return
     */
    @ApiOperation(value = "ExceptionLog根据ID修改",notes = "根据ID修改ExceptionLog方法详情",tags = {"ExceptionLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ExceptionLog对象",value = "传入JSON数据",required = false) ExceptionLog exceptionLog,@PathVariable String id){
        //设置主键值
        exceptionLog.setUid(id);
        //调用ExceptionLogService实现修改ExceptionLog
        exceptionLogService.update(exceptionLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ExceptionLog数据
     * @param exceptionLog
     * @return
     */
    @ApiOperation(value = "ExceptionLog添加",notes = "添加ExceptionLog方法详情",tags = {"ExceptionLogController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ExceptionLog对象",value = "传入JSON数据",required = true) ExceptionLog exceptionLog){
        //调用ExceptionLogService实现添加ExceptionLog
        exceptionLogService.add(exceptionLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ExceptionLog数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ExceptionLog根据ID查询",notes = "根据ID查询ExceptionLog方法详情",tags = {"ExceptionLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<ExceptionLog> findById(@PathVariable String id){
        //调用ExceptionLogService实现根据主键查询ExceptionLog
        ExceptionLog exceptionLog = exceptionLogService.findById(id);
        return new Result<ExceptionLog>(true,StatusCode.OK,"查询成功",exceptionLog);
    }

    /***
     * 查询ExceptionLog全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ExceptionLog",notes = "查询所ExceptionLog有方法详情",tags = {"ExceptionLogController"})
    @GetMapping
    public Result<List<ExceptionLog>> findAll(){
        //调用ExceptionLogService实现查询所有ExceptionLog
        List<ExceptionLog> list = exceptionLogService.findAll();
        return new Result<List<ExceptionLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
