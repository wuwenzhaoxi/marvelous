package com.marvelous.file.controller;
import pojo.ResourceSort;
import com.marvelous.admin.service.ResourceSortService;
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
@Api(value = "ResourceSortController")
@RestController
@RequestMapping("/resourceSort")
@CrossOrigin
public class ResourceSortController {

    @Autowired
    private ResourceSortService resourceSortService;

    /***
     * ResourceSort分页条件搜索实现
     * @param resourceSort
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ResourceSort条件分页查询",notes = "分页条件查询ResourceSort方法详情",tags = {"ResourceSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ResourceSort对象",value = "传入JSON数据",required = false) ResourceSort resourceSort, @PathVariable  int page, @PathVariable  int size){
        //调用ResourceSortService实现分页条件查询ResourceSort
        PageInfo<ResourceSort> pageInfo = resourceSortService.findPage(resourceSort, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ResourceSort分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ResourceSort分页查询",notes = "分页查询ResourceSort方法详情",tags = {"ResourceSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ResourceSortService实现分页查询ResourceSort
        PageInfo<ResourceSort> pageInfo = resourceSortService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param resourceSort
     * @return
     */
    @ApiOperation(value = "ResourceSort条件查询",notes = "条件查询ResourceSort方法详情",tags = {"ResourceSortController"})
    @PostMapping(value = "/search" )
    public Result<List<ResourceSort>> findList(@RequestBody(required = false) @ApiParam(name = "ResourceSort对象",value = "传入JSON数据",required = false) ResourceSort resourceSort){
        //调用ResourceSortService实现条件查询ResourceSort
        List<ResourceSort> list = resourceSortService.findList(resourceSort);
        return new Result<List<ResourceSort>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ResourceSort根据ID删除",notes = "根据ID删除ResourceSort方法详情",tags = {"ResourceSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用ResourceSortService实现根据主键删除
        resourceSortService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ResourceSort数据
     * @param resourceSort
     * @param id
     * @return
     */
    @ApiOperation(value = "ResourceSort根据ID修改",notes = "根据ID修改ResourceSort方法详情",tags = {"ResourceSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ResourceSort对象",value = "传入JSON数据",required = false) ResourceSort resourceSort,@PathVariable String id){
        //设置主键值
        resourceSort.setUid(id);
        //调用ResourceSortService实现修改ResourceSort
        resourceSortService.update(resourceSort);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ResourceSort数据
     * @param resourceSort
     * @return
     */
    @ApiOperation(value = "ResourceSort添加",notes = "添加ResourceSort方法详情",tags = {"ResourceSortController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ResourceSort对象",value = "传入JSON数据",required = true) ResourceSort resourceSort){
        //调用ResourceSortService实现添加ResourceSort
        resourceSortService.add(resourceSort);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ResourceSort数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ResourceSort根据ID查询",notes = "根据ID查询ResourceSort方法详情",tags = {"ResourceSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<ResourceSort> findById(@PathVariable String id){
        //调用ResourceSortService实现根据主键查询ResourceSort
        ResourceSort resourceSort = resourceSortService.findById(id);
        return new Result<ResourceSort>(true,StatusCode.OK,"查询成功",resourceSort);
    }

    /***
     * 查询ResourceSort全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ResourceSort",notes = "查询所ResourceSort有方法详情",tags = {"ResourceSortController"})
    @GetMapping
    public Result<List<ResourceSort>> findAll(){
        //调用ResourceSortService实现查询所有ResourceSort
        List<ResourceSort> list = resourceSortService.findAll();
        return new Result<List<ResourceSort>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
