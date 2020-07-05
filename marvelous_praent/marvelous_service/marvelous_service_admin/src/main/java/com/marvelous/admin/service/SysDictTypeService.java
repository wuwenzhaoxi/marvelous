package com.marvelous.admin.service;
import com.github.pagehelper.PageInfo;
import pojo.SysDictType;

import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:SysDictType业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysDictTypeService {

    /***
     * SysDictType多条件分页查询
     * @param sysDictType
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDictType> findPage(SysDictType sysDictType, int page, int size);

    /***
     * SysDictType分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDictType> findPage(int page, int size);

    /***
     * SysDictType多条件搜索方法
     * @param sysDictType
     * @return
     */
    List<SysDictType> findList(SysDictType sysDictType);

    /***
     * 删除SysDictType
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysDictType数据
     * @param sysDictType
     */
    void update(SysDictType sysDictType);

    /***
     * 新增SysDictType
     * @param sysDictType
     */
    void add(SysDictType sysDictType);

    /**
     * 根据ID查询SysDictType
     * @param id
     * @return
     */
     SysDictType findById(String id);

    /***
     * 查询所有SysDictType
     * @return
     */
    List<SysDictType> findAll();
}
