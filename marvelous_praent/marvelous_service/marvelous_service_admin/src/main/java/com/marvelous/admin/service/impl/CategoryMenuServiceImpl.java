package com.marvelous.admin.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.marvelous.admin.service.CategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.CategoryMenu;
import tk.mybatis.mapper.entity.Example;
import com.marvelous.admin.dao.CategoryMenuMapper;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:CategoryMenu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CategoryMenuServiceImpl implements CategoryMenuService {

    @Autowired
    private CategoryMenuMapper categoryMenuMapper;


    /**
     * CategoryMenu条件+分页查询
     * @param categoryMenu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<CategoryMenu> findPage(CategoryMenu categoryMenu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(categoryMenu);
        //执行搜索
        return new PageInfo<CategoryMenu>(categoryMenuMapper.selectByExample(example));
    }

    /**
     * CategoryMenu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<CategoryMenu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<CategoryMenu>(categoryMenuMapper.selectAll());
    }

    /**
     * CategoryMenu条件查询
     * @param categoryMenu
     * @return
     */
    @Override
    public List<CategoryMenu> findList(CategoryMenu categoryMenu){
        //构建查询条件
        Example example = createExample(categoryMenu);
        //根据构建的条件查询数据
        return categoryMenuMapper.selectByExample(example);
    }


    /**
     * CategoryMenu构建查询对象
     * @param categoryMenu
     * @return
     */
    public Example createExample(CategoryMenu categoryMenu){
        Example example=new Example(CategoryMenu.class);
        Example.Criteria criteria = example.createCriteria();
        if(categoryMenu!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(categoryMenu.getUid())){
                    criteria.andEqualTo("uid",categoryMenu.getUid());
            }
            // 菜单名称
            if(!StringUtils.isEmpty(categoryMenu.getName())){
                    criteria.andLike("name","%"+categoryMenu.getName()+"%");
            }
            // 菜单级别
            if(!StringUtils.isEmpty(categoryMenu.getMenuLevel())){
                    criteria.andEqualTo("menuLevel",categoryMenu.getMenuLevel());
            }
            // 简介
            if(!StringUtils.isEmpty(categoryMenu.getSummary())){
                    criteria.andEqualTo("summary",categoryMenu.getSummary());
            }
            // 父uid
            if(!StringUtils.isEmpty(categoryMenu.getParentUid())){
                    criteria.andEqualTo("parentUid",categoryMenu.getParentUid());
            }
            // url地址
            if(!StringUtils.isEmpty(categoryMenu.getUrl())){
                    criteria.andEqualTo("url",categoryMenu.getUrl());
            }
            // 图标
            if(!StringUtils.isEmpty(categoryMenu.getIcon())){
                    criteria.andEqualTo("icon",categoryMenu.getIcon());
            }
            // 排序字段，越大越靠前
            if(!StringUtils.isEmpty(categoryMenu.getSort())){
                    criteria.andEqualTo("sort",categoryMenu.getSort());
            }
            // 状态
            if(!StringUtils.isEmpty(categoryMenu.getStatus())){
                    criteria.andEqualTo("status",categoryMenu.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(categoryMenu.getCreateTime())){
                    criteria.andEqualTo("createTime",categoryMenu.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(categoryMenu.getUpdateTime())){
                    criteria.andEqualTo("updateTime",categoryMenu.getUpdateTime());
            }
            // 是否显示 1:是 0:否
            if(!StringUtils.isEmpty(categoryMenu.getIsShow())){
                    criteria.andEqualTo("isShow",categoryMenu.getIsShow());
            }
            // 菜单类型 0: 菜单   1: 按钮
            if(!StringUtils.isEmpty(categoryMenu.getMenuType())){
                    criteria.andEqualTo("menuType",categoryMenu.getMenuType());
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
        categoryMenuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改CategoryMenu
     * @param categoryMenu
     */
    @Override
    public void update(CategoryMenu categoryMenu){
        categoryMenuMapper.updateByPrimaryKey(categoryMenu);
    }

    /**
     * 增加CategoryMenu
     * @param categoryMenu
     */
    @Override
    public void add(CategoryMenu categoryMenu){
        categoryMenuMapper.insert(categoryMenu);
    }

    /**
     * 根据ID查询CategoryMenu
     * @param id
     * @return
     */
    @Override
    public CategoryMenu findById(String id){
        return  categoryMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询CategoryMenu全部数据
     * @return
     */
    @Override
    public List<CategoryMenu> findAll() {
        return categoryMenuMapper.selectAll();
    }
}
