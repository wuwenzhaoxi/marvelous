package com.marvelous.file.controller;
import pojo.Picture;
import com.marvelous.admin.service.PictureService;
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
@Api(value = "PictureController")
@RestController
@RequestMapping("/picture")
@CrossOrigin
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /***
     * Picture分页条件搜索实现
     * @param picture
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Picture条件分页查询",notes = "分页条件查询Picture方法详情",tags = {"PictureController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Picture对象",value = "传入JSON数据",required = false) Picture picture, @PathVariable  int page, @PathVariable  int size){
        //调用PictureService实现分页条件查询Picture
        PageInfo<Picture> pageInfo = pictureService.findPage(picture, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Picture分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Picture分页查询",notes = "分页查询Picture方法详情",tags = {"PictureController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PictureService实现分页查询Picture
        PageInfo<Picture> pageInfo = pictureService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param picture
     * @return
     */
    @ApiOperation(value = "Picture条件查询",notes = "条件查询Picture方法详情",tags = {"PictureController"})
    @PostMapping(value = "/search" )
    public Result<List<Picture>> findList(@RequestBody(required = false) @ApiParam(name = "Picture对象",value = "传入JSON数据",required = false) Picture picture){
        //调用PictureService实现条件查询Picture
        List<Picture> list = pictureService.findList(picture);
        return new Result<List<Picture>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Picture根据ID删除",notes = "根据ID删除Picture方法详情",tags = {"PictureController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用PictureService实现根据主键删除
        pictureService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Picture数据
     * @param picture
     * @param id
     * @return
     */
    @ApiOperation(value = "Picture根据ID修改",notes = "根据ID修改Picture方法详情",tags = {"PictureController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Picture对象",value = "传入JSON数据",required = false) Picture picture,@PathVariable String id){
        //设置主键值
        picture.setUid(id);
        //调用PictureService实现修改Picture
        pictureService.update(picture);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Picture数据
     * @param picture
     * @return
     */
    @ApiOperation(value = "Picture添加",notes = "添加Picture方法详情",tags = {"PictureController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Picture对象",value = "传入JSON数据",required = true) Picture picture){
        //调用PictureService实现添加Picture
        pictureService.add(picture);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Picture数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Picture根据ID查询",notes = "根据ID查询Picture方法详情",tags = {"PictureController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Picture> findById(@PathVariable String id){
        //调用PictureService实现根据主键查询Picture
        Picture picture = pictureService.findById(id);
        return new Result<Picture>(true,StatusCode.OK,"查询成功",picture);
    }

    /***
     * 查询Picture全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Picture",notes = "查询所Picture有方法详情",tags = {"PictureController"})
    @GetMapping
    public Result<List<Picture>> findAll(){
        //调用PictureService实现查询所有Picture
        List<Picture> list = pictureService.findAll();
        return new Result<List<Picture>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
