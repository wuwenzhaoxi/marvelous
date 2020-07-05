package com.marvelous.admin.controller;

import com.github.pagehelper.PageInfo;
import com.marvelous.admin.service.CategoryMenuService;
import io.swagger.annotations.*;
import marvelous.entity.Result;
import marvelous.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.CategoryMenu;


import java.util.List;

/****
 * @Author:wuwenzhaoxi
 * @Description:
 * @Date 2020/7/7 1:52
 *****/
@Api(value = "CategoryMenuController")
@RestController
@RequestMapping("/categoryMenu")
@CrossOrigin
public class CategoryMenuController {

    @Autowired
    private CategoryMenuService categoryMenuService;

    /***
     * CategoryMenu分页条件搜索实现
     * @param categoryMenu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "CategoryMenu条件分页查询",notes = "分页条件查询CategoryMenu方法详情",tags = {"CategoryMenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "CategoryMenu对象",value = "传入JSON数据",required = false) CategoryMenu categoryMenu, @PathVariable  int page, @PathVariable  int size){
        //调用CategoryMenuService实现分页条件查询CategoryMenu
        PageInfo<CategoryMenu> pageInfo = categoryMenuService.findPage(categoryMenu, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * CategoryMenu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "CategoryMenu分页查询",notes = "分页查询CategoryMenu方法详情",tags = {"CategoryMenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CategoryMenuService实现分页查询CategoryMenu
        PageInfo<CategoryMenu> pageInfo = categoryMenuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param categoryMenu
     * @return
     */
    @ApiOperation(value = "CategoryMenu条件查询",notes = "条件查询CategoryMenu方法详情",tags = {"CategoryMenuController"})
    @PostMapping(value = "/search" )
    public Result<List<CategoryMenu>> findList(@RequestBody(required = false) @ApiParam(name = "CategoryMenu对象",value = "传入JSON数据",required = false) CategoryMenu categoryMenu){
        //调用CategoryMenuService实现条件查询CategoryMenu
        List<CategoryMenu> list = categoryMenuService.findList(categoryMenu);
        return new Result<List<CategoryMenu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "CategoryMenu根据ID删除",notes = "根据ID删除CategoryMenu方法详情",tags = {"CategoryMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用CategoryMenuService实现根据主键删除
        categoryMenuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改CategoryMenu数据
     * @param categoryMenu
     * @param id
     * @return
     */
    @ApiOperation(value = "CategoryMenu根据ID修改",notes = "根据ID修改CategoryMenu方法详情",tags = {"CategoryMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "CategoryMenu对象",value = "传入JSON数据",required = false) CategoryMenu categoryMenu,@PathVariable String id){
        //设置主键值
        categoryMenu.setUid(id);
        //调用CategoryMenuService实现修改CategoryMenu
        categoryMenuService.update(categoryMenu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增CategoryMenu数据
     * @param categoryMenu
     * @return
     */
    @ApiOperation(value = "CategoryMenu添加",notes = "添加CategoryMenu方法详情",tags = {"CategoryMenuController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "CategoryMenu对象",value = "传入JSON数据",required = true) CategoryMenu categoryMenu){
        //调用CategoryMenuService实现添加CategoryMenu
        categoryMenuService.add(categoryMenu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询CategoryMenu数据
     * @param id
     * @return
     */
    @ApiOperation(value = "CategoryMenu根据ID查询",notes = "根据ID查询CategoryMenu方法详情",tags = {"CategoryMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<CategoryMenu> findById(@PathVariable String id){
        //调用CategoryMenuService实现根据主键查询CategoryMenu
        CategoryMenu categoryMenu = categoryMenuService.findById(id);
        return new Result<CategoryMenu>(true,StatusCode.OK,"查询成功",categoryMenu);
    }

    /***
     * 查询CategoryMenu全部数据
     * @return
     */
    @ApiOperation(value = "查询所有CategoryMenu",notes = "查询所CategoryMenu有方法详情",tags = {"CategoryMenuController"})
    @GetMapping
    public Result<List<CategoryMenu>> findAll(){
        //调用CategoryMenuService实现查询所有CategoryMenu
        List<CategoryMenu> list = categoryMenuService.findAll();
        return new Result<List<CategoryMenu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
