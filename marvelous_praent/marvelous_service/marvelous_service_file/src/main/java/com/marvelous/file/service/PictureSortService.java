package com.marvelous.file.service;
import pojo.PictureSort;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:PictureSort业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PictureSortService {

    /***
     * PictureSort多条件分页查询
     * @param pictureSort
     * @param page
     * @param size
     * @return
     */
    PageInfo<PictureSort> findPage(PictureSort pictureSort, int page, int size);

    /***
     * PictureSort分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PictureSort> findPage(int page, int size);

    /***
     * PictureSort多条件搜索方法
     * @param pictureSort
     * @return
     */
    List<PictureSort> findList(PictureSort pictureSort);

    /***
     * 删除PictureSort
     * @param id
     */
    void delete(String id);

    /***
     * 修改PictureSort数据
     * @param pictureSort
     */
    void update(PictureSort pictureSort);

    /***
     * 新增PictureSort
     * @param pictureSort
     */
    void add(PictureSort pictureSort);

    /**
     * 根据ID查询PictureSort
     * @param id
     * @return
     */
     PictureSort findById(String id);

    /***
     * 查询所有PictureSort
     * @return
     */
    List<PictureSort> findAll();
}
