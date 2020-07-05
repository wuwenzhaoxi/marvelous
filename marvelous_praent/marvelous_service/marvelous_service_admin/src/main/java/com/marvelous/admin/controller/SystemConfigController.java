package com.marvelous.admin.controller;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import marvelous.entity.Result;
import marvelous.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.SystemConfig;
import com.marvelous.admin.service.SystemConfigService;

import java.util.List;

/****
 * @Author:wuwenzhaoxi
 * @Description:
 * @Date 2020/7/7 1:52
 *****/
@Api(value = "SystemConfigController")
@RestController
@RequestMapping("/systemConfig")
@CrossOrigin
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    /***
     * SystemConfig分页条件搜索实现
     * @param systemConfig
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SystemConfig条件分页查询",notes = "分页条件查询SystemConfig方法详情",tags = {"SystemConfigController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SystemConfig对象",value = "传入JSON数据",required = false) SystemConfig systemConfig, @PathVariable  int page, @PathVariable  int size){
        //调用SystemConfigService实现分页条件查询SystemConfig
        PageInfo<SystemConfig> pageInfo = systemConfigService.findPage(systemConfig, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SystemConfig分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SystemConfig分页查询",notes = "分页查询SystemConfig方法详情",tags = {"SystemConfigController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SystemConfigService实现分页查询SystemConfig
        PageInfo<SystemConfig> pageInfo = systemConfigService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param systemConfig
     * @return
     */
    @ApiOperation(value = "SystemConfig条件查询",notes = "条件查询SystemConfig方法详情",tags = {"SystemConfigController"})
    @PostMapping(value = "/search" )
    public Result<List<SystemConfig>> findList(@RequestBody(required = false) @ApiParam(name = "SystemConfig对象",value = "传入JSON数据",required = false) SystemConfig systemConfig){
        //调用SystemConfigService实现条件查询SystemConfig
        List<SystemConfig> list = systemConfigService.findList(systemConfig);
        return new Result<List<SystemConfig>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SystemConfig根据ID删除",notes = "根据ID删除SystemConfig方法详情",tags = {"SystemConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SystemConfigService实现根据主键删除
        systemConfigService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SystemConfig数据
     * @param systemConfig
     * @param id
     * @return
     */
    @ApiOperation(value = "SystemConfig根据ID修改",notes = "根据ID修改SystemConfig方法详情",tags = {"SystemConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SystemConfig对象",value = "传入JSON数据",required = false) SystemConfig systemConfig,@PathVariable String id){
        //设置主键值
        systemConfig.setUid(id);
        //调用SystemConfigService实现修改SystemConfig
        systemConfigService.update(systemConfig);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SystemConfig数据
     * @param systemConfig
     * @return
     */
    @ApiOperation(value = "SystemConfig添加",notes = "添加SystemConfig方法详情",tags = {"SystemConfigController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SystemConfig对象",value = "传入JSON数据",required = true) SystemConfig systemConfig){
        //调用SystemConfigService实现添加SystemConfig
        systemConfigService.add(systemConfig);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SystemConfig数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SystemConfig根据ID查询",notes = "根据ID查询SystemConfig方法详情",tags = {"SystemConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SystemConfig> findById(@PathVariable String id){
        //调用SystemConfigService实现根据主键查询SystemConfig
        SystemConfig systemConfig = systemConfigService.findById(id);
        return new Result<SystemConfig>(true,StatusCode.OK,"查询成功",systemConfig);
    }

    /***
     * 查询SystemConfig全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SystemConfig",notes = "查询所SystemConfig有方法详情",tags = {"SystemConfigController"})
    @GetMapping
    public Result<List<SystemConfig>> findAll(){
        //调用SystemConfigService实现查询所有SystemConfig
        List<SystemConfig> list = systemConfigService.findAll();
        return new Result<List<SystemConfig>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
