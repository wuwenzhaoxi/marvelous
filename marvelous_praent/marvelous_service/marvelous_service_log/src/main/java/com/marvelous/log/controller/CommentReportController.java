package com.marvelous.log.controller;
import com.marvelous.log.service.CommentReportService;
import pojo.CommentReport;
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
@Api(value = "CommentReportController")
@RestController
@RequestMapping("/commentReport")
@CrossOrigin
public class CommentReportController {

    @Autowired
    private CommentReportService commentReportService;

    /***
     * CommentReport分页条件搜索实现
     * @param commentReport
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "CommentReport条件分页查询",notes = "分页条件查询CommentReport方法详情",tags = {"CommentReportController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "CommentReport对象",value = "传入JSON数据",required = false) CommentReport commentReport, @PathVariable  int page, @PathVariable  int size){
        //调用CommentReportService实现分页条件查询CommentReport
        PageInfo<CommentReport> pageInfo = commentReportService.findPage(commentReport, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * CommentReport分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "CommentReport分页查询",notes = "分页查询CommentReport方法详情",tags = {"CommentReportController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CommentReportService实现分页查询CommentReport
        PageInfo<CommentReport> pageInfo = commentReportService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param commentReport
     * @return
     */
    @ApiOperation(value = "CommentReport条件查询",notes = "条件查询CommentReport方法详情",tags = {"CommentReportController"})
    @PostMapping(value = "/search" )
    public Result<List<CommentReport>> findList(@RequestBody(required = false) @ApiParam(name = "CommentReport对象",value = "传入JSON数据",required = false) CommentReport commentReport){
        //调用CommentReportService实现条件查询CommentReport
        List<CommentReport> list = commentReportService.findList(commentReport);
        return new Result<List<CommentReport>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "CommentReport根据ID删除",notes = "根据ID删除CommentReport方法详情",tags = {"CommentReportController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用CommentReportService实现根据主键删除
        commentReportService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改CommentReport数据
     * @param commentReport
     * @param id
     * @return
     */
    @ApiOperation(value = "CommentReport根据ID修改",notes = "根据ID修改CommentReport方法详情",tags = {"CommentReportController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "CommentReport对象",value = "传入JSON数据",required = false) CommentReport commentReport,@PathVariable String id){
        //设置主键值
        commentReport.setUid(id);
        //调用CommentReportService实现修改CommentReport
        commentReportService.update(commentReport);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增CommentReport数据
     * @param commentReport
     * @return
     */
    @ApiOperation(value = "CommentReport添加",notes = "添加CommentReport方法详情",tags = {"CommentReportController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "CommentReport对象",value = "传入JSON数据",required = true) CommentReport commentReport){
        //调用CommentReportService实现添加CommentReport
        commentReportService.add(commentReport);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询CommentReport数据
     * @param id
     * @return
     */
    @ApiOperation(value = "CommentReport根据ID查询",notes = "根据ID查询CommentReport方法详情",tags = {"CommentReportController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<CommentReport> findById(@PathVariable String id){
        //调用CommentReportService实现根据主键查询CommentReport
        CommentReport commentReport = commentReportService.findById(id);
        return new Result<CommentReport>(true,StatusCode.OK,"查询成功",commentReport);
    }

    /***
     * 查询CommentReport全部数据
     * @return
     */
    @ApiOperation(value = "查询所有CommentReport",notes = "查询所CommentReport有方法详情",tags = {"CommentReportController"})
    @GetMapping
    public Result<List<CommentReport>> findAll(){
        //调用CommentReportService实现查询所有CommentReport
        List<CommentReport> list = commentReportService.findAll();
        return new Result<List<CommentReport>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
