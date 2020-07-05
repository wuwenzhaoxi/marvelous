package com.marvelous.blog.service.impl;
import com.marvelous.blog.dao.TagMapper;
import pojo.Tag;
import com.marvelous.blog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Tag业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;


    /**
     * Tag条件+分页查询
     * @param tag 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Tag> findPage(Tag tag, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(tag);
        //执行搜索
        return new PageInfo<Tag>(tagMapper.selectByExample(example));
    }

    /**
     * Tag分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Tag> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Tag>(tagMapper.selectAll());
    }

    /**
     * Tag条件查询
     * @param tag
     * @return
     */
    @Override
    public List<Tag> findList(Tag tag){
        //构建查询条件
        Example example = createExample(tag);
        //根据构建的条件查询数据
        return tagMapper.selectByExample(example);
    }


    /**
     * Tag构建查询对象
     * @param tag
     * @return
     */
    public Example createExample(Tag tag){
        Example example=new Example(Tag.class);
        Example.Criteria criteria = example.createCriteria();
        if(tag!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(tag.getUid())){
                    criteria.andEqualTo("uid",tag.getUid());
            }
            // 标签内容
            if(!StringUtils.isEmpty(tag.getContent())){
                    criteria.andEqualTo("content",tag.getContent());
            }
            // 状态
            if(!StringUtils.isEmpty(tag.getStatus())){
                    criteria.andEqualTo("status",tag.getStatus());
            }
            // 标签简介
            if(!StringUtils.isEmpty(tag.getClickCount())){
                    criteria.andEqualTo("clickCount",tag.getClickCount());
            }
            // 创建时间
            if(!StringUtils.isEmpty(tag.getCreateTime())){
                    criteria.andEqualTo("createTime",tag.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(tag.getUpdateTime())){
                    criteria.andEqualTo("updateTime",tag.getUpdateTime());
            }
            // 排序字段，越大越靠前
            if(!StringUtils.isEmpty(tag.getSort())){
                    criteria.andEqualTo("sort",tag.getSort());
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
        tagMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Tag
     * @param tag
     */
    @Override
    public void update(Tag tag){
        tagMapper.updateByPrimaryKey(tag);
    }

    /**
     * 增加Tag
     * @param tag
     */
    @Override
    public void add(Tag tag){
        tagMapper.insert(tag);
    }

    /**
     * 根据ID查询Tag
     * @param id
     * @return
     */
    @Override
    public Tag findById(String id){
        return  tagMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Tag全部数据
     * @return
     */
    @Override
    public List<Tag> findAll() {
        return tagMapper.selectAll();
    }
}
