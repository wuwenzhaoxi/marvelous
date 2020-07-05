package com.marvelous.blog.controller;
import pojo.Tag;
import com.marvelous.blog.service.TagService;
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
@Api(value = "TagController")
@RestController
@RequestMapping("/tag")
@CrossOrigin
public class TagController {

    @Autowired
    private TagService tagService;

    /***
     * Tag分页条件搜索实现
     * @param tag
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Tag条件分页查询",notes = "分页条件查询Tag方法详情",tags = {"TagController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Tag对象",value = "传入JSON数据",required = false) Tag tag, @PathVariable  int page, @PathVariable  int size){
        //调用TagService实现分页条件查询Tag
        PageInfo<Tag> pageInfo = tagService.findPage(tag, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Tag分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Tag分页查询",notes = "分页查询Tag方法详情",tags = {"TagController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TagService实现分页查询Tag
        PageInfo<Tag> pageInfo = tagService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param tag
     * @return
     */
    @ApiOperation(value = "Tag条件查询",notes = "条件查询Tag方法详情",tags = {"TagController"})
    @PostMapping(value = "/search" )
    public Result<List<Tag>> findList(@RequestBody(required = false) @ApiParam(name = "Tag对象",value = "传入JSON数据",required = false) Tag tag){
        //调用TagService实现条件查询Tag
        List<Tag> list = tagService.findList(tag);
        return new Result<List<Tag>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Tag根据ID删除",notes = "根据ID删除Tag方法详情",tags = {"TagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用TagService实现根据主键删除
        tagService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Tag数据
     * @param tag
     * @param id
     * @return
     */
    @ApiOperation(value = "Tag根据ID修改",notes = "根据ID修改Tag方法详情",tags = {"TagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Tag对象",value = "传入JSON数据",required = false) Tag tag,@PathVariable String id){
        //设置主键值
        tag.setUid(id);
        //调用TagService实现修改Tag
        tagService.update(tag);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Tag数据
     * @param tag
     * @return
     */
    @ApiOperation(value = "Tag添加",notes = "添加Tag方法详情",tags = {"TagController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Tag对象",value = "传入JSON数据",required = true) Tag tag){
        //调用TagService实现添加Tag
        tagService.add(tag);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Tag数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Tag根据ID查询",notes = "根据ID查询Tag方法详情",tags = {"TagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Tag> findById(@PathVariable String id){
        //调用TagService实现根据主键查询Tag
        Tag tag = tagService.findById(id);
        return new Result<Tag>(true,StatusCode.OK,"查询成功",tag);
    }

    /***
     * 查询Tag全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Tag",notes = "查询所Tag有方法详情",tags = {"TagController"})
    @GetMapping
    public Result<List<Tag>> findAll(){
        //调用TagService实现查询所有Tag
        List<Tag> list = tagService.findAll();
        return new Result<List<Tag>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
