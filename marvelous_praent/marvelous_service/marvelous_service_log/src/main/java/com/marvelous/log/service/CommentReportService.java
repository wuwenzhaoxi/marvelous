package com.marvelous.log.service;
import pojo.CommentReport;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:CommentReport业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CommentReportService {

    /***
     * CommentReport多条件分页查询
     * @param commentReport
     * @param page
     * @param size
     * @return
     */
    PageInfo<CommentReport> findPage(CommentReport commentReport, int page, int size);

    /***
     * CommentReport分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<CommentReport> findPage(int page, int size);

    /***
     * CommentReport多条件搜索方法
     * @param commentReport
     * @return
     */
    List<CommentReport> findList(CommentReport commentReport);

    /***
     * 删除CommentReport
     * @param id
     */
    void delete(String id);

    /***
     * 修改CommentReport数据
     * @param commentReport
     */
    void update(CommentReport commentReport);

    /***
     * 新增CommentReport
     * @param commentReport
     */
    void add(CommentReport commentReport);

    /**
     * 根据ID查询CommentReport
     * @param id
     * @return
     */
     CommentReport findById(String id);

    /***
     * 查询所有CommentReport
     * @return
     */
    List<CommentReport> findAll();
}
