package com.marvelous.admin.service;
import com.github.pagehelper.PageInfo;
import pojo.SysDictData;

import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:SysDictData业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysDictDataService {

    /***
     * SysDictData多条件分页查询
     * @param sysDictData
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDictData> findPage(SysDictData sysDictData, int page, int size);

    /***
     * SysDictData分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDictData> findPage(int page, int size);

    /***
     * SysDictData多条件搜索方法
     * @param sysDictData
     * @return
     */
    List<SysDictData> findList(SysDictData sysDictData);

    /***
     * 删除SysDictData
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysDictData数据
     * @param sysDictData
     */
    void update(SysDictData sysDictData);

    /***
     * 新增SysDictData
     * @param sysDictData
     */
    void add(SysDictData sysDictData);

    /**
     * 根据ID查询SysDictData
     * @param id
     * @return
     */
     SysDictData findById(String id);

    /***
     * 查询所有SysDictData
     * @return
     */
    List<SysDictData> findAll();
}
