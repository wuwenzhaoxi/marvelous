package com.marvelous.blog.controller;
import pojo.Comment;
import com.marvelous.blog.service.CommentService;
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
@Api(value = "CommentController")
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    /***
     * Comment分页条件搜索实现
     * @param comment
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Comment条件分页查询",notes = "分页条件查询Comment方法详情",tags = {"CommentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Comment对象",value = "传入JSON数据",required = false) Comment comment, @PathVariable  int page, @PathVariable  int size){
        //调用CommentService实现分页条件查询Comment
        PageInfo<Comment> pageInfo = commentService.findPage(comment, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Comment分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Comment分页查询",notes = "分页查询Comment方法详情",tags = {"CommentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CommentService实现分页查询Comment
        PageInfo<Comment> pageInfo = commentService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param comment
     * @return
     */
    @ApiOperation(value = "Comment条件查询",notes = "条件查询Comment方法详情",tags = {"CommentController"})
    @PostMapping(value = "/search" )
    public Result<List<Comment>> findList(@RequestBody(required = false) @ApiParam(name = "Comment对象",value = "传入JSON数据",required = false) Comment comment){
        //调用CommentService实现条件查询Comment
        List<Comment> list = commentService.findList(comment);
        return new Result<List<Comment>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Comment根据ID删除",notes = "根据ID删除Comment方法详情",tags = {"CommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用CommentService实现根据主键删除
        commentService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Comment数据
     * @param comment
     * @param id
     * @return
     */
    @ApiOperation(value = "Comment根据ID修改",notes = "根据ID修改Comment方法详情",tags = {"CommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Comment对象",value = "传入JSON数据",required = false) Comment comment,@PathVariable String id){
        //设置主键值
        comment.setUid(id);
        //调用CommentService实现修改Comment
        commentService.update(comment);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Comment数据
     * @param comment
     * @return
     */
    @ApiOperation(value = "Comment添加",notes = "添加Comment方法详情",tags = {"CommentController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Comment对象",value = "传入JSON数据",required = true) Comment comment){
        //调用CommentService实现添加Comment
        commentService.add(comment);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Comment数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Comment根据ID查询",notes = "根据ID查询Comment方法详情",tags = {"CommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Comment> findById(@PathVariable String id){
        //调用CommentService实现根据主键查询Comment
        Comment comment = commentService.findById(id);
        return new Result<Comment>(true,StatusCode.OK,"查询成功",comment);
    }

    /***
     * 查询Comment全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Comment",notes = "查询所Comment有方法详情",tags = {"CommentController"})
    @GetMapping
    public Result<List<Comment>> findAll(){
        //调用CommentService实现查询所有Comment
        List<Comment> list = commentService.findAll();
        return new Result<List<Comment>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
