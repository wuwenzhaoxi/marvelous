package com.marvelous.user.service.impl;
import com.marvelous.user.dao.AdminMapper;
import com.marvelous.user.service.AdminService;
import pojo.Admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Admin业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * Admin条件+分页查询
     * @param admin 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Admin> findPage(Admin admin, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(admin);
        //执行搜索
        return new PageInfo<Admin>(adminMapper.selectByExample(example));
    }

    /**
     * Admin分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Admin> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Admin>(adminMapper.selectAll());
    }

    /**
     * Admin条件查询
     * @param admin
     * @return
     */
    @Override
    public List<Admin> findList(Admin admin){
        //构建查询条件
        Example example = createExample(admin);
        //根据构建的条件查询数据
        return adminMapper.selectByExample(example);
    }


    /**
     * Admin构建查询对象
     * @param admin
     * @return
     */
    public Example createExample(Admin admin){
        Example example=new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        if(admin!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(admin.getUid())){
                    criteria.andEqualTo("uid",admin.getUid());
            }
            // 用户名
            if(!StringUtils.isEmpty(admin.getUserName())){
                    criteria.andEqualTo("userName",admin.getUserName());
            }
            // 密码
            if(!StringUtils.isEmpty(admin.getPassWord())){
                    criteria.andEqualTo("passWord",admin.getPassWord());
            }
            // 性别(1:男2:女)
            if(!StringUtils.isEmpty(admin.getGender())){
                    criteria.andEqualTo("gender",admin.getGender());
            }
            // 个人头像
            if(!StringUtils.isEmpty(admin.getAvatar())){
                    criteria.andEqualTo("avatar",admin.getAvatar());
            }
            // 邮箱
            if(!StringUtils.isEmpty(admin.getEmail())){
                    criteria.andEqualTo("email",admin.getEmail());
            }
            // 出生年月日
            if(!StringUtils.isEmpty(admin.getBirthday())){
                    criteria.andEqualTo("birthday",admin.getBirthday());
            }
            // 手机
            if(!StringUtils.isEmpty(admin.getMobile())){
                    criteria.andEqualTo("mobile",admin.getMobile());
            }
            // 邮箱验证码
            if(!StringUtils.isEmpty(admin.getValidCode())){
                    criteria.andEqualTo("validCode",admin.getValidCode());
            }
            // 自我简介最多150字
            if(!StringUtils.isEmpty(admin.getSummary())){
                    criteria.andEqualTo("summary",admin.getSummary());
            }
            // 登录次数
            if(!StringUtils.isEmpty(admin.getLoginCount())){
                    criteria.andEqualTo("loginCount",admin.getLoginCount());
            }
            // 最后登录时间
            if(!StringUtils.isEmpty(admin.getLastLoginTime())){
                    criteria.andEqualTo("lastLoginTime",admin.getLastLoginTime());
            }
            // 最后登录IP
            if(!StringUtils.isEmpty(admin.getLastLoginIp())){
                    criteria.andEqualTo("lastLoginIp",admin.getLastLoginIp());
            }
            // 状态
            if(!StringUtils.isEmpty(admin.getStatus())){
                    criteria.andEqualTo("status",admin.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(admin.getCreateTime())){
                    criteria.andEqualTo("createTime",admin.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(admin.getUpdateTime())){
                    criteria.andEqualTo("updateTime",admin.getUpdateTime());
            }
            // 昵称
            if(!StringUtils.isEmpty(admin.getNickName())){
                    criteria.andEqualTo("nickName",admin.getNickName());
            }
            // QQ号
            if(!StringUtils.isEmpty(admin.getQqNumber())){
                    criteria.andEqualTo("qqNumber",admin.getQqNumber());
            }
            // 微信号
            if(!StringUtils.isEmpty(admin.getWeChat())){
                    criteria.andEqualTo("weChat",admin.getWeChat());
            }
            // 职业
            if(!StringUtils.isEmpty(admin.getOccupation())){
                    criteria.andEqualTo("occupation",admin.getOccupation());
            }
            // github地址
            if(!StringUtils.isEmpty(admin.getGithub())){
                    criteria.andEqualTo("github",admin.getGithub());
            }
            // gitee地址
            if(!StringUtils.isEmpty(admin.getGitee())){
                    criteria.andEqualTo("gitee",admin.getGitee());
            }
            // 拥有的角色uid
            if(!StringUtils.isEmpty(admin.getRoleUid())){
                    criteria.andEqualTo("roleUid",admin.getRoleUid());
            }
            // 履历
            if(!StringUtils.isEmpty(admin.getPersonResume())){
                    criteria.andEqualTo("personResume",admin.getPersonResume());
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
        adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Admin
     * @param admin
     */
    @Override
    public void update(Admin admin){
        adminMapper.updateByPrimaryKey(admin);
    }

    /**
     * 增加Admin
     * @param admin
     */
    @Override
    public void add(Admin admin){
        adminMapper.insert(admin);
    }

    /**
     * 根据ID查询Admin
     * @param id
     * @return
     */
    @Override
    public Admin findById(String id){
        return  adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Admin全部数据
     * @return
     */
    @Override
    public List<Admin> findAll() {
        return adminMapper.selectAll();
    }
}
