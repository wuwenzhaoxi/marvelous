package com.marvelous.file.service.impl;
import com.marvelous.file.dao.ResourceSortMapper;
import pojo.ResourceSort;
import com.marvelous.file.service.ResourceSortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:ResourceSort业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ResourceSortServiceImpl implements ResourceSortService {

    @Autowired
    private ResourceSortMapper resourceSortMapper;


    /**
     * ResourceSort条件+分页查询
     * @param resourceSort 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ResourceSort> findPage(ResourceSort resourceSort, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(resourceSort);
        //执行搜索
        return new PageInfo<ResourceSort>(resourceSortMapper.selectByExample(example));
    }

    /**
     * ResourceSort分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ResourceSort> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ResourceSort>(resourceSortMapper.selectAll());
    }

    /**
     * ResourceSort条件查询
     * @param resourceSort
     * @return
     */
    @Override
    public List<ResourceSort> findList(ResourceSort resourceSort){
        //构建查询条件
        Example example = createExample(resourceSort);
        //根据构建的条件查询数据
        return resourceSortMapper.selectByExample(example);
    }


    /**
     * ResourceSort构建查询对象
     * @param resourceSort
     * @return
     */
    public Example createExample(ResourceSort resourceSort){
        Example example=new Example(ResourceSort.class);
        Example.Criteria criteria = example.createCriteria();
        if(resourceSort!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(resourceSort.getUid())){
                    criteria.andEqualTo("uid",resourceSort.getUid());
            }
            // 分类图片uid
            if(!StringUtils.isEmpty(resourceSort.getFileUid())){
                    criteria.andEqualTo("fileUid",resourceSort.getFileUid());
            }
            // 分类名
            if(!StringUtils.isEmpty(resourceSort.getSortName())){
                    criteria.andEqualTo("sortName",resourceSort.getSortName());
            }
            // 分类介绍
            if(!StringUtils.isEmpty(resourceSort.getContent())){
                    criteria.andEqualTo("content",resourceSort.getContent());
            }
            // 点击数
            if(!StringUtils.isEmpty(resourceSort.getClickCount())){
                    criteria.andEqualTo("clickCount",resourceSort.getClickCount());
            }
            // 状态
            if(!StringUtils.isEmpty(resourceSort.getStatus())){
                    criteria.andEqualTo("status",resourceSort.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(resourceSort.getCreateTime())){
                    criteria.andEqualTo("createTime",resourceSort.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(resourceSort.getUpdateTime())){
                    criteria.andEqualTo("updateTime",resourceSort.getUpdateTime());
            }
            // 父UID
            if(!StringUtils.isEmpty(resourceSort.getParentUid())){
                    criteria.andEqualTo("parentUid",resourceSort.getParentUid());
            }
            // 排序字段
            if(!StringUtils.isEmpty(resourceSort.getSort())){
                    criteria.andEqualTo("sort",resourceSort.getSort());
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
        resourceSortMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ResourceSort
     * @param resourceSort
     */
    @Override
    public void update(ResourceSort resourceSort){
        resourceSortMapper.updateByPrimaryKey(resourceSort);
    }

    /**
     * 增加ResourceSort
     * @param resourceSort
     */
    @Override
    public void add(ResourceSort resourceSort){
        resourceSortMapper.insert(resourceSort);
    }

    /**
     * 根据ID查询ResourceSort
     * @param id
     * @return
     */
    @Override
    public ResourceSort findById(String id){
        return  resourceSortMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ResourceSort全部数据
     * @return
     */
    @Override
    public List<ResourceSort> findAll() {
        return resourceSortMapper.selectAll();
    }
}
