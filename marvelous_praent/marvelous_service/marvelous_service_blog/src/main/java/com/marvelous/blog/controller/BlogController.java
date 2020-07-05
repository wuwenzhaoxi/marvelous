package com.marvelous.blog.controller;
import marvelous.entity.Result;
import pojo.Blog;
import com.marvelous.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
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
@Api(value = "BlogController")
@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;

    /***
     * Blog分页条件搜索实现
     * @param blog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Blog条件分页查询",notes = "分页条件查询Blog方法详情",tags = {"BlogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Blog对象",value = "传入JSON数据",required = false) Blog blog, @PathVariable  int page, @PathVariable  int size){
        //调用BlogService实现分页条件查询Blog
        PageInfo<Blog> pageInfo = blogService.findPage(blog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Blog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Blog分页查询",notes = "分页查询Blog方法详情",tags = {"BlogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BlogService实现分页查询Blog
        PageInfo<Blog> pageInfo = blogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param blog
     * @return
     */
    @ApiOperation(value = "Blog条件查询",notes = "条件查询Blog方法详情",tags = {"BlogController"})
    @PostMapping(value = "/search" )
    public Result<List<Blog>> findList(@RequestBody(required = false) @ApiParam(name = "Blog对象",value = "传入JSON数据",required = false) Blog blog){
        //调用BlogService实现条件查询Blog
        List<Blog> list = blogService.findList(blog);
        return new Result<List<Blog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Blog根据ID删除",notes = "根据ID删除Blog方法详情",tags = {"BlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用BlogService实现根据主键删除
        blogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Blog数据
     * @param blog
     * @param id
     * @return
     */
    @ApiOperation(value = "Blog根据ID修改",notes = "根据ID修改Blog方法详情",tags = {"BlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Blog对象",value = "传入JSON数据",required = false) Blog blog,@PathVariable String id){
        //设置主键值
        blog.setUid(id);
        //调用BlogService实现修改Blog
        blogService.update(blog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Blog数据
     * @param blog
     * @return
     */
    @ApiOperation(value = "Blog添加",notes = "添加Blog方法详情",tags = {"BlogController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Blog对象",value = "传入JSON数据",required = true) Blog blog){
        //调用BlogService实现添加Blog
        blogService.add(blog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Blog数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Blog根据ID查询",notes = "根据ID查询Blog方法详情",tags = {"BlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Blog> findById(@PathVariable String id){
        //调用BlogService实现根据主键查询Blog
        Blog blog = blogService.findById(id);
        return new Result<Blog>(true,StatusCode.OK,"查询成功",blog);
    }

    /***
     * 查询Blog全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Blog",notes = "查询所Blog有方法详情",tags = {"BlogController"})
    @GetMapping
    public Result<List<Blog>> findAll(){
        //调用BlogService实现查询所有Blog
        List<Blog> list = blogService.findAll();
        return new Result<List<Blog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
