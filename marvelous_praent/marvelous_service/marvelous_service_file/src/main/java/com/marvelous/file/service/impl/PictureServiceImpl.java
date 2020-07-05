package com.marvelous.file.service.impl;
import com.marvelous.file.dao.PictureMapper;
import pojo.Picture;
import com.marvelous.file.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Picture业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;


    /**
     * Picture条件+分页查询
     * @param picture 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Picture> findPage(Picture picture, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(picture);
        //执行搜索
        return new PageInfo<Picture>(pictureMapper.selectByExample(example));
    }

    /**
     * Picture分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Picture> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Picture>(pictureMapper.selectAll());
    }

    /**
     * Picture条件查询
     * @param picture
     * @return
     */
    @Override
    public List<Picture> findList(Picture picture){
        //构建查询条件
        Example example = createExample(picture);
        //根据构建的条件查询数据
        return pictureMapper.selectByExample(example);
    }


    /**
     * Picture构建查询对象
     * @param picture
     * @return
     */
    public Example createExample(Picture picture){
        Example example=new Example(Picture.class);
        Example.Criteria criteria = example.createCriteria();
        if(picture!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(picture.getUid())){
                    criteria.andEqualTo("uid",picture.getUid());
            }
            // 图片uid
            if(!StringUtils.isEmpty(picture.getFileUid())){
                    criteria.andEqualTo("fileUid",picture.getFileUid());
            }
            // 图片名
            if(!StringUtils.isEmpty(picture.getPicName())){
                    criteria.andEqualTo("picName",picture.getPicName());
            }
            // 分类uid
            if(!StringUtils.isEmpty(picture.getPictureSortUid())){
                    criteria.andEqualTo("pictureSortUid",picture.getPictureSortUid());
            }
            // 状态
            if(!StringUtils.isEmpty(picture.getStatus())){
                    criteria.andEqualTo("status",picture.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(picture.getCreateTime())){
                    criteria.andEqualTo("createTime",picture.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(picture.getUpdateTime())){
                    criteria.andEqualTo("updateTime",picture.getUpdateTime());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        pictureMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Picture
     * @param picture
     */
    @Override
    public void update(Picture picture){
        pictureMapper.updateByPrimaryKey(picture);
    }

    /**
     * 增加Picture
     * @param picture
     */
    @Override
    public void add(Picture picture){
        pictureMapper.insert(picture);
    }

    /**
     * 根据ID查询Picture
     * @param id
     * @return
     */
    @Override
    public Picture findById(String id){
        return  pictureMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Picture全部数据
     * @return
     */
    @Override
    public List<Picture> findAll() {
        return pictureMapper.selectAll();
    }
}
