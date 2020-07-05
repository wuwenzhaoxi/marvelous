package com.marvelous.blog.service;
import pojo.BlogSort;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:BlogSort业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BlogSortService {

    /***
     * BlogSort多条件分页查询
     * @param blogSort
     * @param page
     * @param size
     * @return
     */
    PageInfo<BlogSort> findPage(BlogSort blogSort, int page, int size);

    /***
     * BlogSort分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<BlogSort> findPage(int page, int size);

    /***
     * BlogSort多条件搜索方法
     * @param blogSort
     * @return
     */
    List<BlogSort> findList(BlogSort blogSort);

    /***
     * 删除BlogSort
     * @param id
     */
    void delete(String id);

    /***
     * 修改BlogSort数据
     * @param blogSort
     */
    void update(BlogSort blogSort);

    /***
     * 新增BlogSort
     * @param blogSort
     */
    void add(BlogSort blogSort);

    /**
     * 根据ID查询BlogSort
     * @param id
     * @return
     */
     BlogSort findById(String id);

    /***
     * 查询所有BlogSort
     * @return
     */
    List<BlogSort> findAll();
}
