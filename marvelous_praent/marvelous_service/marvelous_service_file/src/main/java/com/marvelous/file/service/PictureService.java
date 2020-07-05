package com.marvelous.file.service;
import pojo.Picture;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Picture业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PictureService {

    /***
     * Picture多条件分页查询
     * @param picture
     * @param page
     * @param size
     * @return
     */
    PageInfo<Picture> findPage(Picture picture, int page, int size);

    /***
     * Picture分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Picture> findPage(int page, int size);

    /***
     * Picture多条件搜索方法
     * @param picture
     * @return
     */
    List<Picture> findList(Picture picture);

    /***
     * 删除Picture
     * @param id
     */
    void delete(String id);

    /***
     * 修改Picture数据
     * @param picture
     */
    void update(Picture picture);

    /***
     * 新增Picture
     * @param picture
     */
    void add(Picture picture);

    /**
     * 根据ID查询Picture
     * @param id
     * @return
     */
     Picture findById(String id);

    /***
     * 查询所有Picture
     * @return
     */
    List<Picture> findAll();
}
