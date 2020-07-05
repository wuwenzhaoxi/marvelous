package com.marvelous.file.service;
import pojo.ResourceSort;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:ResourceSort业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ResourceSortService {

    /***
     * ResourceSort多条件分页查询
     * @param resourceSort
     * @param page
     * @param size
     * @return
     */
    PageInfo<ResourceSort> findPage(ResourceSort resourceSort, int page, int size);

    /***
     * ResourceSort分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ResourceSort> findPage(int page, int size);

    /***
     * ResourceSort多条件搜索方法
     * @param resourceSort
     * @return
     */
    List<ResourceSort> findList(ResourceSort resourceSort);

    /***
     * 删除ResourceSort
     * @param id
     */
    void delete(String id);

    /***
     * 修改ResourceSort数据
     * @param resourceSort
     */
    void update(ResourceSort resourceSort);

    /***
     * 新增ResourceSort
     * @param resourceSort
     */
    void add(ResourceSort resourceSort);

    /**
     * 根据ID查询ResourceSort
     * @param id
     * @return
     */
     ResourceSort findById(String id);

    /***
     * 查询所有ResourceSort
     * @return
     */
    List<ResourceSort> findAll();
}
