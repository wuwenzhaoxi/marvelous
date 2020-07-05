package com.marvelous.log.service.impl;
import com.marvelous.log.dao.WebVisitMapper;
import com.marvelous.log.service.WebVisitService;
import pojo.WebVisit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:WebVisit业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WebVisitServiceImpl implements WebVisitService {

    @Autowired
    private WebVisitMapper webVisitMapper;


    /**
     * WebVisit条件+分页查询
     * @param webVisit 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WebVisit> findPage(WebVisit webVisit, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(webVisit);
        //执行搜索
        return new PageInfo<WebVisit>(webVisitMapper.selectByExample(example));
    }

    /**
     * WebVisit分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WebVisit> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WebVisit>(webVisitMapper.selectAll());
    }

    /**
     * WebVisit条件查询
     * @param webVisit
     * @return
     */
    @Override
    public List<WebVisit> findList(WebVisit webVisit){
        //构建查询条件
        Example example = createExample(webVisit);
        //根据构建的条件查询数据
        return webVisitMapper.selectByExample(example);
    }


    /**
     * WebVisit构建查询对象
     * @param webVisit
     * @return
     */
    public Example createExample(WebVisit webVisit){
        Example example=new Example(WebVisit.class);
        Example.Criteria criteria = example.createCriteria();
        if(webVisit!=null){
            // 主键
            if(!StringUtils.isEmpty(webVisit.getUid())){
                    criteria.andEqualTo("uid",webVisit.getUid());
            }
            // 用户uid
            if(!StringUtils.isEmpty(webVisit.getUserUid())){
                    criteria.andEqualTo("userUid",webVisit.getUserUid());
            }
            // 访问ip地址
            if(!StringUtils.isEmpty(webVisit.getIp())){
                    criteria.andEqualTo("ip",webVisit.getIp());
            }
            // 用户行为
            if(!StringUtils.isEmpty(webVisit.getBehavior())){
                    criteria.andEqualTo("behavior",webVisit.getBehavior());
            }
            // 模块uid（文章uid，标签uid，分类uid）
            if(!StringUtils.isEmpty(webVisit.getModuleUid())){
                    criteria.andEqualTo("moduleUid",webVisit.getModuleUid());
            }
            // 附加数据(比如搜索内容)
            if(!StringUtils.isEmpty(webVisit.getOtherData())){
                    criteria.andEqualTo("otherData",webVisit.getOtherData());
            }
            // 状态
            if(!StringUtils.isEmpty(webVisit.getStatus())){
                    criteria.andEqualTo("status",webVisit.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(webVisit.getCreateTime())){
                    criteria.andEqualTo("createTime",webVisit.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(webVisit.getUpdateTime())){
                    criteria.andEqualTo("updateTime",webVisit.getUpdateTime());
            }
            // 操作系统
            if(!StringUtils.isEmpty(webVisit.getOs())){
                    criteria.andEqualTo("os",webVisit.getOs());
            }
            // 浏览器
            if(!StringUtils.isEmpty(webVisit.getBrowser())){
                    criteria.andEqualTo("browser",webVisit.getBrowser());
            }
            // ip来源
            if(!StringUtils.isEmpty(webVisit.getIpSource())){
                    criteria.andEqualTo("ipSource",webVisit.getIpSource());
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
        webVisitMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WebVisit
     * @param webVisit
     */
    @Override
    public void update(WebVisit webVisit){
        webVisitMapper.updateByPrimaryKey(webVisit);
    }

    /**
     * 增加WebVisit
     * @param webVisit
     */
    @Override
    public void add(WebVisit webVisit){
        webVisitMapper.insert(webVisit);
    }

    /**
     * 根据ID查询WebVisit
     * @param id
     * @return
     */
    @Override
    public WebVisit findById(String id){
        return  webVisitMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WebVisit全部数据
     * @return
     */
    @Override
    public List<WebVisit> findAll() {
        return webVisitMapper.selectAll();
    }
}
