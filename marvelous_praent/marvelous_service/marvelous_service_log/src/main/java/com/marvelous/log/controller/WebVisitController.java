package com.marvelous.log.controller;
import com.marvelous.log.service.WebVisitService;
import pojo.WebVisit;
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
@Api(value = "WebVisitController")
@RestController
@RequestMapping("/webVisit")
@CrossOrigin
public class WebVisitController {

    @Autowired
    private WebVisitService webVisitService;

    /***
     * WebVisit分页条件搜索实现
     * @param webVisit
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WebVisit条件分页查询",notes = "分页条件查询WebVisit方法详情",tags = {"WebVisitController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WebVisit对象",value = "传入JSON数据",required = false) WebVisit webVisit, @PathVariable  int page, @PathVariable  int size){
        //调用WebVisitService实现分页条件查询WebVisit
        PageInfo<WebVisit> pageInfo = webVisitService.findPage(webVisit, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WebVisit分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WebVisit分页查询",notes = "分页查询WebVisit方法详情",tags = {"WebVisitController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WebVisitService实现分页查询WebVisit
        PageInfo<WebVisit> pageInfo = webVisitService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param webVisit
     * @return
     */
    @ApiOperation(value = "WebVisit条件查询",notes = "条件查询WebVisit方法详情",tags = {"WebVisitController"})
    @PostMapping(value = "/search" )
    public Result<List<WebVisit>> findList(@RequestBody(required = false) @ApiParam(name = "WebVisit对象",value = "传入JSON数据",required = false) WebVisit webVisit){
        //调用WebVisitService实现条件查询WebVisit
        List<WebVisit> list = webVisitService.findList(webVisit);
        return new Result<List<WebVisit>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WebVisit根据ID删除",notes = "根据ID删除WebVisit方法详情",tags = {"WebVisitController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用WebVisitService实现根据主键删除
        webVisitService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WebVisit数据
     * @param webVisit
     * @param id
     * @return
     */
    @ApiOperation(value = "WebVisit根据ID修改",notes = "根据ID修改WebVisit方法详情",tags = {"WebVisitController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WebVisit对象",value = "传入JSON数据",required = false) WebVisit webVisit,@PathVariable String id){
        //设置主键值
        webVisit.setUid(id);
        //调用WebVisitService实现修改WebVisit
        webVisitService.update(webVisit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WebVisit数据
     * @param webVisit
     * @return
     */
    @ApiOperation(value = "WebVisit添加",notes = "添加WebVisit方法详情",tags = {"WebVisitController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WebVisit对象",value = "传入JSON数据",required = true) WebVisit webVisit){
        //调用WebVisitService实现添加WebVisit
        webVisitService.add(webVisit);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WebVisit数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WebVisit根据ID查询",notes = "根据ID查询WebVisit方法详情",tags = {"WebVisitController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<WebVisit> findById(@PathVariable String id){
        //调用WebVisitService实现根据主键查询WebVisit
        WebVisit webVisit = webVisitService.findById(id);
        return new Result<WebVisit>(true,StatusCode.OK,"查询成功",webVisit);
    }

    /***
     * 查询WebVisit全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WebVisit",notes = "查询所WebVisit有方法详情",tags = {"WebVisitController"})
    @GetMapping
    public Result<List<WebVisit>> findAll(){
        //调用WebVisitService实现查询所有WebVisit
        List<WebVisit> list = webVisitService.findAll();
        return new Result<List<WebVisit>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
