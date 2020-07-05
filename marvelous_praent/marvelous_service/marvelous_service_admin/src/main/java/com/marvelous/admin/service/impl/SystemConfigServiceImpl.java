package com.marvelous.admin.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.marvelous.admin.dao.SystemConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.SystemConfig;
import com.marvelous.admin.service.SystemConfigService;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:SystemConfig业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    private SystemConfigMapper systemConfigMapper;


    /**
     * SystemConfig条件+分页查询
     * @param systemConfig 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SystemConfig> findPage(SystemConfig systemConfig, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(systemConfig);
        //执行搜索
        return new PageInfo<SystemConfig>(systemConfigMapper.selectByExample(example));
    }

    /**
     * SystemConfig分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SystemConfig> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SystemConfig>(systemConfigMapper.selectAll());
    }

    /**
     * SystemConfig条件查询
     * @param systemConfig
     * @return
     */
    @Override
    public List<SystemConfig> findList(SystemConfig systemConfig){
        //构建查询条件
        Example example = createExample(systemConfig);
        //根据构建的条件查询数据
        return systemConfigMapper.selectByExample(example);
    }


    /**
     * SystemConfig构建查询对象
     * @param systemConfig
     * @return
     */
    public Example createExample(SystemConfig systemConfig){
        Example example=new Example(SystemConfig.class);
        Example.Criteria criteria = example.createCriteria();
        if(systemConfig!=null){
            // 主键
            if(!StringUtils.isEmpty(systemConfig.getUid())){
                    criteria.andEqualTo("uid",systemConfig.getUid());
            }
            // 七牛云公钥
            if(!StringUtils.isEmpty(systemConfig.getQiNiuAccessKey())){
                    criteria.andEqualTo("qiNiuAccessKey",systemConfig.getQiNiuAccessKey());
            }
            // 七牛云私钥
            if(!StringUtils.isEmpty(systemConfig.getQiNiuSecretKey())){
                    criteria.andEqualTo("qiNiuSecretKey",systemConfig.getQiNiuSecretKey());
            }
            // 邮箱账号
            if(!StringUtils.isEmpty(systemConfig.getEmail())){
                    criteria.andEqualTo("email",systemConfig.getEmail());
            }
            // 邮箱发件人用户名
            if(!StringUtils.isEmpty(systemConfig.getEmailUserName())){
                    criteria.andEqualTo("emailUserName",systemConfig.getEmailUserName());
            }
            // 邮箱密码
            if(!StringUtils.isEmpty(systemConfig.getEmailPassword())){
                    criteria.andEqualTo("emailPassword",systemConfig.getEmailPassword());
            }
            // SMTP地址
            if(!StringUtils.isEmpty(systemConfig.getSmtpAddress())){
                    criteria.andEqualTo("smtpAddress",systemConfig.getSmtpAddress());
            }
            // SMTP端口
            if(!StringUtils.isEmpty(systemConfig.getSmtpPort())){
                    criteria.andEqualTo("smtpPort",systemConfig.getSmtpPort());
            }
            // 状态
            if(!StringUtils.isEmpty(systemConfig.getStatus())){
                    criteria.andEqualTo("status",systemConfig.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(systemConfig.getCreateTime())){
                    criteria.andEqualTo("createTime",systemConfig.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(systemConfig.getUpdateTime())){
                    criteria.andEqualTo("updateTime",systemConfig.getUpdateTime());
            }
            // 七牛云上传空间
            if(!StringUtils.isEmpty(systemConfig.getQiNiuBucket())){
                    criteria.andEqualTo("qiNiuBucket",systemConfig.getQiNiuBucket());
            }
            // 七牛云存储区域 华东（z0），华北(z1)，华南(z2)，北美(na0)，东南亚(as0)
            if(!StringUtils.isEmpty(systemConfig.getQiNiuArea())){
                    criteria.andEqualTo("qiNiuArea",systemConfig.getQiNiuArea());
            }
            // 图片是否上传七牛云 (0:否， 1：是)
            if(!StringUtils.isEmpty(systemConfig.getUploadQiNiu())){
                    criteria.andEqualTo("uploadQiNiu",systemConfig.getUploadQiNiu());
            }
            // 图片是否上传本地存储 (0:否， 1：是)
            if(!StringUtils.isEmpty(systemConfig.getUploadLocal())){
                    criteria.andEqualTo("uploadLocal",systemConfig.getUploadLocal());
            }
            // 图片显示优先级（ 1 展示 七牛云,  0 本地）
            if(!StringUtils.isEmpty(systemConfig.getPicturePriority())){
                    criteria.andEqualTo("picturePriority",systemConfig.getPicturePriority());
            }
            // 七牛云域名前缀：http://images.moguit.cn
            if(!StringUtils.isEmpty(systemConfig.getQiNiuPictureBaseUrl())){
                    criteria.andEqualTo("qiNiuPictureBaseUrl",systemConfig.getQiNiuPictureBaseUrl());
            }
            // 本地服务器域名前缀：http://localhost:8600
            if(!StringUtils.isEmpty(systemConfig.getLocalPictureBaseUrl())){
                    criteria.andEqualTo("localPictureBaseUrl",systemConfig.getLocalPictureBaseUrl());
            }
            // 是否开启邮件通知(0:否， 1:是)
            if(!StringUtils.isEmpty(systemConfig.getStartEmailNotification())){
                    criteria.andEqualTo("startEmailNotification",systemConfig.getStartEmailNotification());
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
        systemConfigMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SystemConfig
     * @param systemConfig
     */
    @Override
    public void update(SystemConfig systemConfig){
        systemConfigMapper.updateByPrimaryKey(systemConfig);
    }

    /**
     * 增加SystemConfig
     * @param systemConfig
     */
    @Override
    public void add(SystemConfig systemConfig){
        systemConfigMapper.insert(systemConfig);
    }

    /**
     * 根据ID查询SystemConfig
     * @param id
     * @return
     */
    @Override
    public SystemConfig findById(String id){
        return  systemConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SystemConfig全部数据
     * @return
     */
    @Override
    public List<SystemConfig> findAll() {
        return systemConfigMapper.selectAll();
    }
}
