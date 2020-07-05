package com.marvelous.admin.controller;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import marvelous.entity.Result;
import marvelous.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.SysDictData;
import com.marvelous.admin.service.SysDictDataService;

import java.util.List;

/****
 * @Author:wuwenzhaoxi
 * @Description:
 * @Date 2020/7/7 1:52
 *****/
@Api(value = "SysDictDataController")
@RestController
@RequestMapping("/sysDictData")
@CrossOrigin
public class SysDictDataController {

    @Autowired
    private SysDictDataService sysDictDataService;

    /***
     * SysDictData分页条件搜索实现
     * @param sysDictData
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysDictData条件分页查询",notes = "分页条件查询SysDictData方法详情",tags = {"SysDictDataController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysDictData对象",value = "传入JSON数据",required = false) SysDictData sysDictData, @PathVariable  int page, @PathVariable  int size){
        //调用SysDictDataService实现分页条件查询SysDictData
        PageInfo<SysDictData> pageInfo = sysDictDataService.findPage(sysDictData, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysDictData分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysDictData分页查询",notes = "分页查询SysDictData方法详情",tags = {"SysDictDataController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysDictDataService实现分页查询SysDictData
        PageInfo<SysDictData> pageInfo = sysDictDataService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysDictData
     * @return
     */
    @ApiOperation(value = "SysDictData条件查询",notes = "条件查询SysDictData方法详情",tags = {"SysDictDataController"})
    @PostMapping(value = "/search" )
    public Result<List<SysDictData>> findList(@RequestBody(required = false) @ApiParam(name = "SysDictData对象",value = "传入JSON数据",required = false) SysDictData sysDictData){
        //调用SysDictDataService实现条件查询SysDictData
        List<SysDictData> list = sysDictDataService.findList(sysDictData);
        return new Result<List<SysDictData>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictData根据ID删除",notes = "根据ID删除SysDictData方法详情",tags = {"SysDictDataController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysDictDataService实现根据主键删除
        sysDictDataService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysDictData数据
     * @param sysDictData
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictData根据ID修改",notes = "根据ID修改SysDictData方法详情",tags = {"SysDictDataController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysDictData对象",value = "传入JSON数据",required = false) SysDictData sysDictData,@PathVariable String id){
        //设置主键值
        sysDictData.setUid(id);
        //调用SysDictDataService实现修改SysDictData
        sysDictDataService.update(sysDictData);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysDictData数据
     * @param sysDictData
     * @return
     */
    @ApiOperation(value = "SysDictData添加",notes = "添加SysDictData方法详情",tags = {"SysDictDataController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysDictData对象",value = "传入JSON数据",required = true) SysDictData sysDictData){
        //调用SysDictDataService实现添加SysDictData
        sysDictDataService.add(sysDictData);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysDictData数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictData根据ID查询",notes = "根据ID查询SysDictData方法详情",tags = {"SysDictDataController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysDictData> findById(@PathVariable String id){
        //调用SysDictDataService实现根据主键查询SysDictData
        SysDictData sysDictData = sysDictDataService.findById(id);
        return new Result<SysDictData>(true,StatusCode.OK,"查询成功",sysDictData);
    }

    /***
     * 查询SysDictData全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysDictData",notes = "查询所SysDictData有方法详情",tags = {"SysDictDataController"})
    @GetMapping
    public Result<List<SysDictData>> findAll(){
        //调用SysDictDataService实现查询所有SysDictData
        List<SysDictData> list = sysDictDataService.findAll();
        return new Result<List<SysDictData>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
