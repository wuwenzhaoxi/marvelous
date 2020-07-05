package com.marvelous.blog.service;
import pojo.Tag;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Tag业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TagService {

    /***
     * Tag多条件分页查询
     * @param tag
     * @param page
     * @param size
     * @return
     */
    PageInfo<Tag> findPage(Tag tag, int page, int size);

    /***
     * Tag分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Tag> findPage(int page, int size);

    /***
     * Tag多条件搜索方法
     * @param tag
     * @return
     */
    List<Tag> findList(Tag tag);

    /***
     * 删除Tag
     * @param id
     */
    void delete(String id);

    /***
     * 修改Tag数据
     * @param tag
     */
    void update(Tag tag);

    /***
     * 新增Tag
     * @param tag
     */
    void add(Tag tag);

    /**
     * 根据ID查询Tag
     * @param id
     * @return
     */
     Tag findById(String id);

    /***
     * 查询所有Tag
     * @return
     */
    List<Tag> findAll();
}
