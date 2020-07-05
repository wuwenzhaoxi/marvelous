package com.marvelous.log.service;
import pojo.WebVisit;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:WebVisit业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WebVisitService {

    /***
     * WebVisit多条件分页查询
     * @param webVisit
     * @param page
     * @param size
     * @return
     */
    PageInfo<WebVisit> findPage(WebVisit webVisit, int page, int size);

    /***
     * WebVisit分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WebVisit> findPage(int page, int size);

    /***
     * WebVisit多条件搜索方法
     * @param webVisit
     * @return
     */
    List<WebVisit> findList(WebVisit webVisit);

    /***
     * 删除WebVisit
     * @param id
     */
    void delete(String id);

    /***
     * 修改WebVisit数据
     * @param webVisit
     */
    void update(WebVisit webVisit);

    /***
     * 新增WebVisit
     * @param webVisit
     */
    void add(WebVisit webVisit);

    /**
     * 根据ID查询WebVisit
     * @param id
     * @return
     */
     WebVisit findById(String id);

    /***
     * 查询所有WebVisit
     * @return
     */
    List<WebVisit> findAll();
}
