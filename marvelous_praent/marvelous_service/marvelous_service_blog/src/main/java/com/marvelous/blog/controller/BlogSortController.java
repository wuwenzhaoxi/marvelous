package com.marvelous.blog.controller;
import pojo.BlogSort;
import com.marvelous.blog.service.BlogSortService;
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
@Api(value = "BlogSortController")
@RestController
@RequestMapping("/blogSort")
@CrossOrigin
public class BlogSortController {

    @Autowired
    private BlogSortService blogSortService;

    /***
     * BlogSort分页条件搜索实现
     * @param blogSort
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "BlogSort条件分页查询",notes = "分页条件查询BlogSort方法详情",tags = {"BlogSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "BlogSort对象",value = "传入JSON数据",required = false) BlogSort blogSort, @PathVariable  int page, @PathVariable  int size){
        //调用BlogSortService实现分页条件查询BlogSort
        PageInfo<BlogSort> pageInfo = blogSortService.findPage(blogSort, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * BlogSort分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "BlogSort分页查询",notes = "分页查询BlogSort方法详情",tags = {"BlogSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BlogSortService实现分页查询BlogSort
        PageInfo<BlogSort> pageInfo = blogSortService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param blogSort
     * @return
     */
    @ApiOperation(value = "BlogSort条件查询",notes = "条件查询BlogSort方法详情",tags = {"BlogSortController"})
    @PostMapping(value = "/search" )
    public Result<List<BlogSort>> findList(@RequestBody(required = false) @ApiParam(name = "BlogSort对象",value = "传入JSON数据",required = false) BlogSort blogSort){
        //调用BlogSortService实现条件查询BlogSort
        List<BlogSort> list = blogSortService.findList(blogSort);
        return new Result<List<BlogSort>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "BlogSort根据ID删除",notes = "根据ID删除BlogSort方法详情",tags = {"BlogSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用BlogSortService实现根据主键删除
        blogSortService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改BlogSort数据
     * @param blogSort
     * @param id
     * @return
     */
    @ApiOperation(value = "BlogSort根据ID修改",notes = "根据ID修改BlogSort方法详情",tags = {"BlogSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "BlogSort对象",value = "传入JSON数据",required = false) BlogSort blogSort,@PathVariable String id){
        //设置主键值
        blogSort.setUid(id);
        //调用BlogSortService实现修改BlogSort
        blogSortService.update(blogSort);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增BlogSort数据
     * @param blogSort
     * @return
     */
    @ApiOperation(value = "BlogSort添加",notes = "添加BlogSort方法详情",tags = {"BlogSortController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "BlogSort对象",value = "传入JSON数据",required = true) BlogSort blogSort){
        //调用BlogSortService实现添加BlogSort
        blogSortService.add(blogSort);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询BlogSort数据
     * @param id
     * @return
     */
    @ApiOperation(value = "BlogSort根据ID查询",notes = "根据ID查询BlogSort方法详情",tags = {"BlogSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<BlogSort> findById(@PathVariable String id){
        //调用BlogSortService实现根据主键查询BlogSort
        BlogSort blogSort = blogSortService.findById(id);
        return new Result<BlogSort>(true,StatusCode.OK,"查询成功",blogSort);
    }

    /***
     * 查询BlogSort全部数据
     * @return
     */
    @ApiOperation(value = "查询所有BlogSort",notes = "查询所BlogSort有方法详情",tags = {"BlogSortController"})
    @GetMapping
    public Result<List<BlogSort>> findAll(){
        //调用BlogSortService实现查询所有BlogSort
        List<BlogSort> list = blogSortService.findAll();
        return new Result<List<BlogSort>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
