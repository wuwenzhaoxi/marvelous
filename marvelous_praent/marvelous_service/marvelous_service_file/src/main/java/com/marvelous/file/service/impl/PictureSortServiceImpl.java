package com.marvelous.file.service.impl;
import com.marvelous.file.dao.PictureSortMapper;
import pojo.PictureSort;
import com.marvelous.file.service.PictureSortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:PictureSort业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PictureSortServiceImpl implements PictureSortService {

    @Autowired
    private PictureSortMapper pictureSortMapper;


    /**
     * PictureSort条件+分页查询
     * @param pictureSort 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PictureSort> findPage(PictureSort pictureSort, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pictureSort);
        //执行搜索
        return new PageInfo<PictureSort>(pictureSortMapper.selectByExample(example));
    }

    /**
     * PictureSort分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PictureSort> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PictureSort>(pictureSortMapper.selectAll());
    }

    /**
     * PictureSort条件查询
     * @param pictureSort
     * @return
     */
    @Override
    public List<PictureSort> findList(PictureSort pictureSort){
        //构建查询条件
        Example example = createExample(pictureSort);
        //根据构建的条件查询数据
        return pictureSortMapper.selectByExample(example);
    }


    /**
     * PictureSort构建查询对象
     * @param pictureSort
     * @return
     */
    public Example createExample(PictureSort pictureSort){
        Example example=new Example(PictureSort.class);
        Example.Criteria criteria = example.createCriteria();
        if(pictureSort!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(pictureSort.getUid())){
                    criteria.andEqualTo("uid",pictureSort.getUid());
            }
            // 分类图片uid
            if(!StringUtils.isEmpty(pictureSort.getFileUid())){
                    criteria.andEqualTo("fileUid",pictureSort.getFileUid());
            }
            // 分类名
            if(!StringUtils.isEmpty(pictureSort.getName())){
                    criteria.andLike("name","%"+pictureSort.getName()+"%");
            }
            // 状态
            if(!StringUtils.isEmpty(pictureSort.getStatus())){
                    criteria.andEqualTo("status",pictureSort.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(pictureSort.getCreateTime())){
                    criteria.andEqualTo("createTime",pictureSort.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(pictureSort.getUpdateTime())){
                    criteria.andEqualTo("updateTime",pictureSort.getUpdateTime());
            }
            // 
            if(!StringUtils.isEmpty(pictureSort.getParentUid())){
                    criteria.andEqualTo("parentUid",pictureSort.getParentUid());
            }
            // 排序字段，越大越靠前
            if(!StringUtils.isEmpty(pictureSort.getSort())){
                    criteria.andEqualTo("sort",pictureSort.getSort());
            }
            // 是否显示，1：是，0，否
            if(!StringUtils.isEmpty(pictureSort.getIsShow())){
                    criteria.andEqualTo("isShow",pictureSort.getIsShow());
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
        pictureSortMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PictureSort
     * @param pictureSort
     */
    @Override
    public void update(PictureSort pictureSort){
        pictureSortMapper.updateByPrimaryKey(pictureSort);
    }

    /**
     * 增加PictureSort
     * @param pictureSort
     */
    @Override
    public void add(PictureSort pictureSort){
        pictureSortMapper.insert(pictureSort);
    }

    /**
     * 根据ID查询PictureSort
     * @param id
     * @return
     */
    @Override
    public PictureSort findById(String id){
        return  pictureSortMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PictureSort全部数据
     * @return
     */
    @Override
    public List<PictureSort> findAll() {
        return pictureSortMapper.selectAll();
    }
}
