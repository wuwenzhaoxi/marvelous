package com.marvelous.user.service.impl;
import com.marvelous.user.dao.UserMapper;
import pojo.User;
import com.marvelous.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:User业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * User条件+分页查询
     * @param user 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<User> findPage(User user, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(user);
        //执行搜索
        return new PageInfo<User>(userMapper.selectByExample(example));
    }

    /**
     * User分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<User> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<User>(userMapper.selectAll());
    }

    /**
     * User条件查询
     * @param user
     * @return
     */
    @Override
    public List<User> findList(User user){
        //构建查询条件
        Example example = createExample(user);
        //根据构建的条件查询数据
        return userMapper.selectByExample(example);
    }


    /**
     * User构建查询对象
     * @param user
     * @return
     */
    public Example createExample(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(user.getUid())){
                    criteria.andEqualTo("uid",user.getUid());
            }
            // 用户名
            if(!StringUtils.isEmpty(user.getUserName())){
                    criteria.andEqualTo("userName",user.getUserName());
            }
            // 密码
            if(!StringUtils.isEmpty(user.getPassWord())){
                    criteria.andEqualTo("passWord",user.getPassWord());
            }
            // 性别(1:男2:女)
            if(!StringUtils.isEmpty(user.getGender())){
                    criteria.andEqualTo("gender",user.getGender());
            }
            // 个人头像
            if(!StringUtils.isEmpty(user.getAvatar())){
                    criteria.andEqualTo("avatar",user.getAvatar());
            }
            // 邮箱
            if(!StringUtils.isEmpty(user.getEmail())){
                    criteria.andEqualTo("email",user.getEmail());
            }
            // 出生年月日
            if(!StringUtils.isEmpty(user.getBirthday())){
                    criteria.andEqualTo("birthday",user.getBirthday());
            }
            // 手机
            if(!StringUtils.isEmpty(user.getMobile())){
                    criteria.andEqualTo("mobile",user.getMobile());
            }
            // 邮箱验证码
            if(!StringUtils.isEmpty(user.getValidCode())){
                    criteria.andEqualTo("validCode",user.getValidCode());
            }
            // 自我简介最多150字
            if(!StringUtils.isEmpty(user.getSummary())){
                    criteria.andEqualTo("summary",user.getSummary());
            }
            // 登录次数
            if(!StringUtils.isEmpty(user.getLoginCount())){
                    criteria.andEqualTo("loginCount",user.getLoginCount());
            }
            // 最后登录时间
            if(!StringUtils.isEmpty(user.getLastLoginTime())){
                    criteria.andEqualTo("lastLoginTime",user.getLastLoginTime());
            }
            // 最后登录IP
            if(!StringUtils.isEmpty(user.getLastLoginIp())){
                    criteria.andEqualTo("lastLoginIp",user.getLastLoginIp());
            }
            // 状态
            if(!StringUtils.isEmpty(user.getStatus())){
                    criteria.andEqualTo("status",user.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(user.getCreateTime())){
                    criteria.andEqualTo("createTime",user.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(user.getUpdateTime())){
                    criteria.andEqualTo("updateTime",user.getUpdateTime());
            }
            // 昵称
            if(!StringUtils.isEmpty(user.getNickName())){
                    criteria.andEqualTo("nickName",user.getNickName());
            }
            // 资料来源
            if(!StringUtils.isEmpty(user.getSource())){
                    criteria.andEqualTo("source",user.getSource());
            }
            // 平台uuid
            if(!StringUtils.isEmpty(user.getUuid())){
                    criteria.andEqualTo("uuid",user.getUuid());
            }
            // QQ号
            if(!StringUtils.isEmpty(user.getQqNumber())){
                    criteria.andEqualTo("qqNumber",user.getQqNumber());
            }
            // 微信号
            if(!StringUtils.isEmpty(user.getWeChat())){
                    criteria.andEqualTo("weChat",user.getWeChat());
            }
            // 职业
            if(!StringUtils.isEmpty(user.getOccupation())){
                    criteria.andEqualTo("occupation",user.getOccupation());
            }
            // 评论状态 1:正常 0:禁言
            if(!StringUtils.isEmpty(user.getCommentStatus())){
                    criteria.andEqualTo("commentStatus",user.getCommentStatus());
            }
            // ip来源
            if(!StringUtils.isEmpty(user.getIpSource())){
                    criteria.andEqualTo("ipSource",user.getIpSource());
            }
            // 浏览器
            if(!StringUtils.isEmpty(user.getBrowser())){
                    criteria.andEqualTo("browser",user.getBrowser());
            }
            // 操作系统
            if(!StringUtils.isEmpty(user.getOs())){
                    criteria.andEqualTo("os",user.getOs());
            }
            // 是否开启邮件通知 1:开启 0:关闭
            if(!StringUtils.isEmpty(user.getStartEmailNotification())){
                    criteria.andEqualTo("startEmailNotification",user.getStartEmailNotification());
            }
            // 用户标签：0：普通用户，1：管理员，2：博主 等
            if(!StringUtils.isEmpty(user.getUserTag())){
                    criteria.andEqualTo("userTag",user.getUserTag());
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
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改User
     * @param user
     */
    @Override
    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 增加User
     * @param user
     */
    @Override
    public void add(User user){
        userMapper.insert(user);
    }

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
    @Override
    public User findById(String id){
        return  userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询User全部数据
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
