package com.marvelous.blog.service;
import pojo.Comment;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Comment业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CommentService {

    /***
     * Comment多条件分页查询
     * @param comment
     * @param page
     * @param size
     * @return
     */
    PageInfo<Comment> findPage(Comment comment, int page, int size);

    /***
     * Comment分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Comment> findPage(int page, int size);

    /***
     * Comment多条件搜索方法
     * @param comment
     * @return
     */
    List<Comment> findList(Comment comment);

    /***
     * 删除Comment
     * @param id
     */
    void delete(String id);

    /***
     * 修改Comment数据
     * @param comment
     */
    void update(Comment comment);

    /***
     * 新增Comment
     * @param comment
     */
    void add(Comment comment);

    /**
     * 根据ID查询Comment
     * @param id
     * @return
     */
     Comment findById(String id);

    /***
     * 查询所有Comment
     * @return
     */
    List<Comment> findAll();
}
