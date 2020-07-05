package com.marvelous.log.service;
import pojo.ExceptionLog;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:ExceptionLog业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ExceptionLogService {

    /***
     * ExceptionLog多条件分页查询
     * @param exceptionLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<ExceptionLog> findPage(ExceptionLog exceptionLog, int page, int size);

    /***
     * ExceptionLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ExceptionLog> findPage(int page, int size);

    /***
     * ExceptionLog多条件搜索方法
     * @param exceptionLog
     * @return
     */
    List<ExceptionLog> findList(ExceptionLog exceptionLog);

    /***
     * 删除ExceptionLog
     * @param id
     */
    void delete(String id);

    /***
     * 修改ExceptionLog数据
     * @param exceptionLog
     */
    void update(ExceptionLog exceptionLog);

    /***
     * 新增ExceptionLog
     * @param exceptionLog
     */
    void add(ExceptionLog exceptionLog);

    /**
     * 根据ID查询ExceptionLog
     * @param id
     * @return
     */
     ExceptionLog findById(String id);

    /***
     * 查询所有ExceptionLog
     * @return
     */
    List<ExceptionLog> findAll();
}
