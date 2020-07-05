package com.marvelous.blog.service.impl;
import com.marvelous.blog.dao.CollectMapper;
import pojo.Collect;
import com.marvelous.blog.service.CollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Collect业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;


    /**
     * Collect条件+分页查询
     * @param collect 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Collect> findPage(Collect collect, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(collect);
        //执行搜索
        return new PageInfo<Collect>(collectMapper.selectByExample(example));
    }

    /**
     * Collect分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Collect> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Collect>(collectMapper.selectAll());
    }

    /**
     * Collect条件查询
     * @param collect
     * @return
     */
    @Override
    public List<Collect> findList(Collect collect){
        //构建查询条件
        Example example = createExample(collect);
        //根据构建的条件查询数据
        return collectMapper.selectByExample(example);
    }


    /**
     * Collect构建查询对象
     * @param collect
     * @return
     */
    public Example createExample(Collect collect){
        Example example=new Example(Collect.class);
        Example.Criteria criteria = example.createCriteria();
        if(collect!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(collect.getUid())){
                    criteria.andEqualTo("uid",collect.getUid());
            }
            // 用户的uid
            if(!StringUtils.isEmpty(collect.getUserUid())){
                    criteria.andEqualTo("userUid",collect.getUserUid());
            }
            // 博客的uid
            if(!StringUtils.isEmpty(collect.getBlogUid())){
                    criteria.andEqualTo("blogUid",collect.getBlogUid());
            }
            // 状态
            if(!StringUtils.isEmpty(collect.getStatus())){
                    criteria.andEqualTo("status",collect.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(collect.getCreateTime())){
                    criteria.andEqualTo("createTime",collect.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(collect.getUpdateTime())){
                    criteria.andEqualTo("updateTime",collect.getUpdateTime());
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
        collectMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Collect
     * @param collect
     */
    @Override
    public void update(Collect collect){
        collectMapper.updateByPrimaryKey(collect);
    }

    /**
     * 增加Collect
     * @param collect
     */
    @Override
    public void add(Collect collect){
        collectMapper.insert(collect);
    }

    /**
     * 根据ID查询Collect
     * @param id
     * @return
     */
    @Override
    public Collect findById(String id){
        return  collectMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Collect全部数据
     * @return
     */
    @Override
    public List<Collect> findAll() {
        return collectMapper.selectAll();
    }
}
