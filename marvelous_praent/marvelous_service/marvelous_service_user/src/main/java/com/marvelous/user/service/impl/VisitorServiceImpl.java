package com.marvelous.user.service.impl;
import com.marvelous.user.dao.VisitorMapper;
import com.marvelous.user.service.VisitorService;
import pojo.Visitor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Visitor业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;


    /**
     * Visitor条件+分页查询
     * @param visitor 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Visitor> findPage(Visitor visitor, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(visitor);
        //执行搜索
        return new PageInfo<Visitor>(visitorMapper.selectByExample(example));
    }

    /**
     * Visitor分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Visitor> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Visitor>(visitorMapper.selectAll());
    }

    /**
     * Visitor条件查询
     * @param visitor
     * @return
     */
    @Override
    public List<Visitor> findList(Visitor visitor){
        //构建查询条件
        Example example = createExample(visitor);
        //根据构建的条件查询数据
        return visitorMapper.selectByExample(example);
    }


    /**
     * Visitor构建查询对象
     * @param visitor
     * @return
     */
    public Example createExample(Visitor visitor){
        Example example=new Example(Visitor.class);
        Example.Criteria criteria = example.createCriteria();
        if(visitor!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(visitor.getUid())){
                    criteria.andEqualTo("uid",visitor.getUid());
            }
            // 用户名
            if(!StringUtils.isEmpty(visitor.getUserName())){
                    criteria.andEqualTo("userName",visitor.getUserName());
            }
            // 邮箱
            if(!StringUtils.isEmpty(visitor.getEmail())){
                    criteria.andEqualTo("email",visitor.getEmail());
            }
            // 登录次数
            if(!StringUtils.isEmpty(visitor.getLoginCount())){
                    criteria.andEqualTo("loginCount",visitor.getLoginCount());
            }
            // 最后登录时间
            if(!StringUtils.isEmpty(visitor.getLastLoginTime())){
                    criteria.andEqualTo("lastLoginTime",visitor.getLastLoginTime());
            }
            // 最后登录IP
            if(!StringUtils.isEmpty(visitor.getLastLoginIp())){
                    criteria.andEqualTo("lastLoginIp",visitor.getLastLoginIp());
            }
            // 状态
            if(!StringUtils.isEmpty(visitor.getStatus())){
                    criteria.andEqualTo("status",visitor.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(visitor.getCreateTime())){
                    criteria.andEqualTo("createTime",visitor.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(visitor.getUpdateTime())){
                    criteria.andEqualTo("updateTime",visitor.getUpdateTime());
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
        visitorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Visitor
     * @param visitor
     */
    @Override
    public void update(Visitor visitor){
        visitorMapper.updateByPrimaryKey(visitor);
    }

    /**
     * 增加Visitor
     * @param visitor
     */
    @Override
    public void add(Visitor visitor){
        visitorMapper.insert(visitor);
    }

    /**
     * 根据ID查询Visitor
     * @param id
     * @return
     */
    @Override
    public Visitor findById(String id){
        return  visitorMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Visitor全部数据
     * @return
     */
    @Override
    public List<Visitor> findAll() {
        return visitorMapper.selectAll();
    }
}
