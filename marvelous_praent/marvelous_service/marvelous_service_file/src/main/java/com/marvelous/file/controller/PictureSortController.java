package com.marvelous.file.controller;
import pojo.PictureSort;
import com.marvelous.admin.service.PictureSortService;
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
@Api(value = "PictureSortController")
@RestController
@RequestMapping("/pictureSort")
@CrossOrigin
public class PictureSortController {

    @Autowired
    private PictureSortService pictureSortService;

    /***
     * PictureSort分页条件搜索实现
     * @param pictureSort
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "PictureSort条件分页查询",notes = "分页条件查询PictureSort方法详情",tags = {"PictureSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "PictureSort对象",value = "传入JSON数据",required = false) PictureSort pictureSort, @PathVariable  int page, @PathVariable  int size){
        //调用PictureSortService实现分页条件查询PictureSort
        PageInfo<PictureSort> pageInfo = pictureSortService.findPage(pictureSort, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * PictureSort分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "PictureSort分页查询",notes = "分页查询PictureSort方法详情",tags = {"PictureSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PictureSortService实现分页查询PictureSort
        PageInfo<PictureSort> pageInfo = pictureSortService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pictureSort
     * @return
     */
    @ApiOperation(value = "PictureSort条件查询",notes = "条件查询PictureSort方法详情",tags = {"PictureSortController"})
    @PostMapping(value = "/search" )
    public Result<List<PictureSort>> findList(@RequestBody(required = false) @ApiParam(name = "PictureSort对象",value = "传入JSON数据",required = false) PictureSort pictureSort){
        //调用PictureSortService实现条件查询PictureSort
        List<PictureSort> list = pictureSortService.findList(pictureSort);
        return new Result<List<PictureSort>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "PictureSort根据ID删除",notes = "根据ID删除PictureSort方法详情",tags = {"PictureSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用PictureSortService实现根据主键删除
        pictureSortService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改PictureSort数据
     * @param pictureSort
     * @param id
     * @return
     */
    @ApiOperation(value = "PictureSort根据ID修改",notes = "根据ID修改PictureSort方法详情",tags = {"PictureSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "PictureSort对象",value = "传入JSON数据",required = false) PictureSort pictureSort,@PathVariable String id){
        //设置主键值
        pictureSort.setUid(id);
        //调用PictureSortService实现修改PictureSort
        pictureSortService.update(pictureSort);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增PictureSort数据
     * @param pictureSort
     * @return
     */
    @ApiOperation(value = "PictureSort添加",notes = "添加PictureSort方法详情",tags = {"PictureSortController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "PictureSort对象",value = "传入JSON数据",required = true) PictureSort pictureSort){
        //调用PictureSortService实现添加PictureSort
        pictureSortService.add(pictureSort);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询PictureSort数据
     * @param id
     * @return
     */
    @ApiOperation(value = "PictureSort根据ID查询",notes = "根据ID查询PictureSort方法详情",tags = {"PictureSortController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<PictureSort> findById(@PathVariable String id){
        //调用PictureSortService实现根据主键查询PictureSort
        PictureSort pictureSort = pictureSortService.findById(id);
        return new Result<PictureSort>(true,StatusCode.OK,"查询成功",pictureSort);
    }

    /***
     * 查询PictureSort全部数据
     * @return
     */
    @ApiOperation(value = "查询所有PictureSort",notes = "查询所PictureSort有方法详情",tags = {"PictureSortController"})
    @GetMapping
    public Result<List<PictureSort>> findAll(){
        //调用PictureSortService实现查询所有PictureSort
        List<PictureSort> list = pictureSortService.findAll();
        return new Result<List<PictureSort>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
