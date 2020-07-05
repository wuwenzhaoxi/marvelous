package com.marvelous.file.controller;
import pojo.File;
import com.marvelous.admin.service.FileService;
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
@Api(value = "FileController")
@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Autowired
    private FileService fileService;

    /***
     * File分页条件搜索实现
     * @param file
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "File条件分页查询",notes = "分页条件查询File方法详情",tags = {"FileController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "File对象",value = "传入JSON数据",required = false) File file, @PathVariable  int page, @PathVariable  int size){
        //调用FileService实现分页条件查询File
        PageInfo<File> pageInfo = fileService.findPage(file, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * File分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "File分页查询",notes = "分页查询File方法详情",tags = {"FileController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FileService实现分页查询File
        PageInfo<File> pageInfo = fileService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param file
     * @return
     */
    @ApiOperation(value = "File条件查询",notes = "条件查询File方法详情",tags = {"FileController"})
    @PostMapping(value = "/search" )
    public Result<List<File>> findList(@RequestBody(required = false) @ApiParam(name = "File对象",value = "传入JSON数据",required = false) File file){
        //调用FileService实现条件查询File
        List<File> list = fileService.findList(file);
        return new Result<List<File>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "File根据ID删除",notes = "根据ID删除File方法详情",tags = {"FileController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用FileService实现根据主键删除
        fileService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改File数据
     * @param file
     * @param id
     * @return
     */
    @ApiOperation(value = "File根据ID修改",notes = "根据ID修改File方法详情",tags = {"FileController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "File对象",value = "传入JSON数据",required = false) File file,@PathVariable String id){
        //设置主键值
        file.setUid(id);
        //调用FileService实现修改File
        fileService.update(file);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增File数据
     * @param file
     * @return
     */
    @ApiOperation(value = "File添加",notes = "添加File方法详情",tags = {"FileController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "File对象",value = "传入JSON数据",required = true) File file){
        //调用FileService实现添加File
        fileService.add(file);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询File数据
     * @param id
     * @return
     */
    @ApiOperation(value = "File根据ID查询",notes = "根据ID查询File方法详情",tags = {"FileController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<File> findById(@PathVariable String id){
        //调用FileService实现根据主键查询File
        File file = fileService.findById(id);
        return new Result<File>(true,StatusCode.OK,"查询成功",file);
    }

    /***
     * 查询File全部数据
     * @return
     */
    @ApiOperation(value = "查询所有File",notes = "查询所File有方法详情",tags = {"FileController"})
    @GetMapping
    public Result<List<File>> findAll(){
        //调用FileService实现查询所有File
        List<File> list = fileService.findAll();
        return new Result<List<File>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
