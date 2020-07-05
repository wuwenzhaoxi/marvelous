package com.marvelous.user.service;
import pojo.Visitor;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Visitor业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface VisitorService {

    /***
     * Visitor多条件分页查询
     * @param visitor
     * @param page
     * @param size
     * @return
     */
    PageInfo<Visitor> findPage(Visitor visitor, int page, int size);

    /***
     * Visitor分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Visitor> findPage(int page, int size);

    /***
     * Visitor多条件搜索方法
     * @param visitor
     * @return
     */
    List<Visitor> findList(Visitor visitor);

    /***
     * 删除Visitor
     * @param id
     */
    void delete(String id);

    /***
     * 修改Visitor数据
     * @param visitor
     */
    void update(Visitor visitor);

    /***
     * 新增Visitor
     * @param visitor
     */
    void add(Visitor visitor);

    /**
     * 根据ID查询Visitor
     * @param id
     * @return
     */
     Visitor findById(String id);

    /***
     * 查询所有Visitor
     * @return
     */
    List<Visitor> findAll();
}
