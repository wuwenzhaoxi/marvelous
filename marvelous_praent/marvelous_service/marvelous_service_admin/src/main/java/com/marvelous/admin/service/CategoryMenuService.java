package com.marvelous.admin.service;
import com.github.pagehelper.PageInfo;
import pojo.CategoryMenu;

import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:CategoryMenu业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CategoryMenuService {

    /***
     * CategoryMenu多条件分页查询
     * @param categoryMenu
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryMenu> findPage(CategoryMenu categoryMenu, int page, int size);

    /***
     * CategoryMenu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryMenu> findPage(int page, int size);

    /***
     * CategoryMenu多条件搜索方法
     * @param categoryMenu
     * @return
     */
    List<CategoryMenu> findList(CategoryMenu categoryMenu);

    /***
     * 删除CategoryMenu
     * @param id
     */
    void delete(String id);

    /***
     * 修改CategoryMenu数据
     * @param categoryMenu
     */
    void update(CategoryMenu categoryMenu);

    /***
     * 新增CategoryMenu
     * @param categoryMenu
     */
    void add(CategoryMenu categoryMenu);

    /**
     * 根据ID查询CategoryMenu
     * @param id
     * @return
     */
     CategoryMenu findById(String id);

    /***
     * 查询所有CategoryMenu
     * @return
     */
    List<CategoryMenu> findAll();
}
