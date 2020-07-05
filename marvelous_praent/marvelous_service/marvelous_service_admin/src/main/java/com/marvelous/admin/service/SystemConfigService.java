package com.marvelous.admin.service;
import com.github.pagehelper.PageInfo;
import pojo.SystemConfig;

import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:SystemConfig业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SystemConfigService {

    /***
     * SystemConfig多条件分页查询
     * @param systemConfig
     * @param page
     * @param size
     * @return
     */
    PageInfo<SystemConfig> findPage(SystemConfig systemConfig, int page, int size);

    /***
     * SystemConfig分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SystemConfig> findPage(int page, int size);

    /***
     * SystemConfig多条件搜索方法
     * @param systemConfig
     * @return
     */
    List<SystemConfig> findList(SystemConfig systemConfig);

    /***
     * 删除SystemConfig
     * @param id
     */
    void delete(String id);

    /***
     * 修改SystemConfig数据
     * @param systemConfig
     */
    void update(SystemConfig systemConfig);

    /***
     * 新增SystemConfig
     * @param systemConfig
     */
    void add(SystemConfig systemConfig);

    /**
     * 根据ID查询SystemConfig
     * @param id
     * @return
     */
     SystemConfig findById(String id);

    /***
     * 查询所有SystemConfig
     * @return
     */
    List<SystemConfig> findAll();
}
