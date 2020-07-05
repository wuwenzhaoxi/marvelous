package com.marvelous.blog.service.impl;
import com.marvelous.blog.dao.BlogSortMapper;
import pojo.BlogSort;
import com.marvelous.blog.service.BlogSortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:BlogSort业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BlogSortServiceImpl implements BlogSortService {

    @Autowired
    private BlogSortMapper blogSortMapper;


    /**
     * BlogSort条件+分页查询
     * @param blogSort 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<BlogSort> findPage(BlogSort blogSort, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(blogSort);
        //执行搜索
        return new PageInfo<BlogSort>(blogSortMapper.selectByExample(example));
    }

    /**
     * BlogSort分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<BlogSort> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<BlogSort>(blogSortMapper.selectAll());
    }

    /**
     * BlogSort条件查询
     * @param blogSort
     * @return
     */
    @Override
    public List<BlogSort> findList(BlogSort blogSort){
        //构建查询条件
        Example example = createExample(blogSort);
        //根据构建的条件查询数据
        return blogSortMapper.selectByExample(example);
    }


    /**
     * BlogSort构建查询对象
     * @param blogSort
     * @return
     */
    public Example createExample(BlogSort blogSort){
        Example example=new Example(BlogSort.class);
        Example.Criteria criteria = example.createCriteria();
        if(blogSort!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(blogSort.getUid())){
                    criteria.andEqualTo("uid",blogSort.getUid());
            }
            // 分类内容
            if(!StringUtils.isEmpty(blogSort.getSortName())){
                    criteria.andEqualTo("sortName",blogSort.getSortName());
            }
            // 分类简介
            if(!StringUtils.isEmpty(blogSort.getContent())){
                    criteria.andEqualTo("content",blogSort.getContent());
            }
            // 创建时间
            if(!StringUtils.isEmpty(blogSort.getCreateTime())){
                    criteria.andEqualTo("createTime",blogSort.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(blogSort.getUpdateTime())){
                    criteria.andEqualTo("updateTime",blogSort.getUpdateTime());
            }
            // 状态
            if(!StringUtils.isEmpty(blogSort.getStatus())){
                    criteria.andEqualTo("status",blogSort.getStatus());
            }
            // 排序字段，越大越靠前
            if(!StringUtils.isEmpty(blogSort.getSort())){
                    criteria.andEqualTo("sort",blogSort.getSort());
            }
            // 点击数
            if(!StringUtils.isEmpty(blogSort.getClickCount())){
                    criteria.andEqualTo("clickCount",blogSort.getClickCount());
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
        blogSortMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改BlogSort
     * @param blogSort
     */
    @Override
    public void update(BlogSort blogSort){
        blogSortMapper.updateByPrimaryKey(blogSort);
    }

    /**
     * 增加BlogSort
     * @param blogSort
     */
    @Override
    public void add(BlogSort blogSort){
        blogSortMapper.insert(blogSort);
    }

    /**
     * 根据ID查询BlogSort
     * @param id
     * @return
     */
    @Override
    public BlogSort findById(String id){
        return  blogSortMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询BlogSort全部数据
     * @return
     */
    @Override
    public List<BlogSort> findAll() {
        return blogSortMapper.selectAll();
    }
}
