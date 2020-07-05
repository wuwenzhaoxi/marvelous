package com.marvelous.admin.controller;
import marvelous.entity.Result;
import marvelous.entity.StatusCode;
import pojo.SysDictType;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.marvelous.admin.service.SysDictTypeService;

import java.util.List;

/****
 * @Author:wuwenzhaoxi
 * @Description:
 * @Date 2020/7/7 1:52
 *****/
@Api(value = "SysDictTypeController")
@RestController
@RequestMapping("/sysDictType")
@CrossOrigin
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    /***
     * SysDictType分页条件搜索实现
     * @param sysDictType
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysDictType条件分页查询",notes = "分页条件查询SysDictType方法详情",tags = {"SysDictTypeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysDictType对象",value = "传入JSON数据",required = false) SysDictType sysDictType, @PathVariable  int page, @PathVariable  int size){
        //调用SysDictTypeService实现分页条件查询SysDictType
        PageInfo<SysDictType> pageInfo = sysDictTypeService.findPage(sysDictType, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysDictType分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysDictType分页查询",notes = "分页查询SysDictType方法详情",tags = {"SysDictTypeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysDictTypeService实现分页查询SysDictType
        PageInfo<SysDictType> pageInfo = sysDictTypeService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysDictType
     * @return
     */
    @ApiOperation(value = "SysDictType条件查询",notes = "条件查询SysDictType方法详情",tags = {"SysDictTypeController"})
    @PostMapping(value = "/search" )
    public Result<List<SysDictType>> findList(@RequestBody(required = false) @ApiParam(name = "SysDictType对象",value = "传入JSON数据",required = false) SysDictType sysDictType){
        //调用SysDictTypeService实现条件查询SysDictType
        List<SysDictType> list = sysDictTypeService.findList(sysDictType);
        return new Result<List<SysDictType>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictType根据ID删除",notes = "根据ID删除SysDictType方法详情",tags = {"SysDictTypeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysDictTypeService实现根据主键删除
        sysDictTypeService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysDictType数据
     * @param sysDictType
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictType根据ID修改",notes = "根据ID修改SysDictType方法详情",tags = {"SysDictTypeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysDictType对象",value = "传入JSON数据",required = false) SysDictType sysDictType,@PathVariable String id){
        //设置主键值
        sysDictType.setUid(id);
        //调用SysDictTypeService实现修改SysDictType
        sysDictTypeService.update(sysDictType);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysDictType数据
     * @param sysDictType
     * @return
     */
    @ApiOperation(value = "SysDictType添加",notes = "添加SysDictType方法详情",tags = {"SysDictTypeController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysDictType对象",value = "传入JSON数据",required = true) SysDictType sysDictType){
        //调用SysDictTypeService实现添加SysDictType
        sysDictTypeService.add(sysDictType);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysDictType数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictType根据ID查询",notes = "根据ID查询SysDictType方法详情",tags = {"SysDictTypeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysDictType> findById(@PathVariable String id){
        //调用SysDictTypeService实现根据主键查询SysDictType
        SysDictType sysDictType = sysDictTypeService.findById(id);
        return new Result<SysDictType>(true,StatusCode.OK,"查询成功",sysDictType);
    }

    /***
     * 查询SysDictType全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysDictType",notes = "查询所SysDictType有方法详情",tags = {"SysDictTypeController"})
    @GetMapping
    public Result<List<SysDictType>> findAll(){
        //调用SysDictTypeService实现查询所有SysDictType
        List<SysDictType> list = sysDictTypeService.findAll();
        return new Result<List<SysDictType>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
