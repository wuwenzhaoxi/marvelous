package com.marvelous.blog.service;
import pojo.Collect;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Collect业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CollectService {

    /***
     * Collect多条件分页查询
     * @param collect
     * @param page
     * @param size
     * @return
     */
    PageInfo<Collect> findPage(Collect collect, int page, int size);

    /***
     * Collect分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Collect> findPage(int page, int size);

    /***
     * Collect多条件搜索方法
     * @param collect
     * @return
     */
    List<Collect> findList(Collect collect);

    /***
     * 删除Collect
     * @param id
     */
    void delete(String id);

    /***
     * 修改Collect数据
     * @param collect
     */
    void update(Collect collect);

    /***
     * 新增Collect
     * @param collect
     */
    void add(Collect collect);

    /**
     * 根据ID查询Collect
     * @param id
     * @return
     */
     Collect findById(String id);

    /***
     * 查询所有Collect
     * @return
     */
    List<Collect> findAll();
}
