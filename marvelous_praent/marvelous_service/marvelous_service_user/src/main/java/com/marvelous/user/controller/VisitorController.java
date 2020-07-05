package com.marvelous.user.controller;
import pojo.Visitor;
import com.marvelous.user.service.VisitorService;
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
@Api(value = "VisitorController")
@RestController
@RequestMapping("/visitor")
@CrossOrigin
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    /***
     * Visitor分页条件搜索实现
     * @param visitor
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Visitor条件分页查询",notes = "分页条件查询Visitor方法详情",tags = {"VisitorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Visitor对象",value = "传入JSON数据",required = false) Visitor visitor, @PathVariable  int page, @PathVariable  int size){
        //调用VisitorService实现分页条件查询Visitor
        PageInfo<Visitor> pageInfo = visitorService.findPage(visitor, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Visitor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Visitor分页查询",notes = "分页查询Visitor方法详情",tags = {"VisitorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用VisitorService实现分页查询Visitor
        PageInfo<Visitor> pageInfo = visitorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param visitor
     * @return
     */
    @ApiOperation(value = "Visitor条件查询",notes = "条件查询Visitor方法详情",tags = {"VisitorController"})
    @PostMapping(value = "/search" )
    public Result<List<Visitor>> findList(@RequestBody(required = false) @ApiParam(name = "Visitor对象",value = "传入JSON数据",required = false) Visitor visitor){
        //调用VisitorService实现条件查询Visitor
        List<Visitor> list = visitorService.findList(visitor);
        return new Result<List<Visitor>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Visitor根据ID删除",notes = "根据ID删除Visitor方法详情",tags = {"VisitorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用VisitorService实现根据主键删除
        visitorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Visitor数据
     * @param visitor
     * @param id
     * @return
     */
    @ApiOperation(value = "Visitor根据ID修改",notes = "根据ID修改Visitor方法详情",tags = {"VisitorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Visitor对象",value = "传入JSON数据",required = false) Visitor visitor,@PathVariable String id){
        //设置主键值
        visitor.setUid(id);
        //调用VisitorService实现修改Visitor
        visitorService.update(visitor);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Visitor数据
     * @param visitor
     * @return
     */
    @ApiOperation(value = "Visitor添加",notes = "添加Visitor方法详情",tags = {"VisitorController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Visitor对象",value = "传入JSON数据",required = true) Visitor visitor){
        //调用VisitorService实现添加Visitor
        visitorService.add(visitor);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Visitor数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Visitor根据ID查询",notes = "根据ID查询Visitor方法详情",tags = {"VisitorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Visitor> findById(@PathVariable String id){
        //调用VisitorService实现根据主键查询Visitor
        Visitor visitor = visitorService.findById(id);
        return new Result<Visitor>(true,StatusCode.OK,"查询成功",visitor);
    }

    /***
     * 查询Visitor全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Visitor",notes = "查询所Visitor有方法详情",tags = {"VisitorController"})
    @GetMapping
    public Result<List<Visitor>> findAll(){
        //调用VisitorService实现查询所有Visitor
        List<Visitor> list = visitorService.findAll();
        return new Result<List<Visitor>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
