package com.marvelous.log.service.impl;
import com.marvelous.log.dao.ExceptionLogMapper;
import com.marvelous.log.service.ExceptionLogService;
import pojo.ExceptionLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:ExceptionLog业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;


    /**
     * ExceptionLog条件+分页查询
     * @param exceptionLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ExceptionLog> findPage(ExceptionLog exceptionLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(exceptionLog);
        //执行搜索
        return new PageInfo<ExceptionLog>(exceptionLogMapper.selectByExample(example));
    }

    /**
     * ExceptionLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ExceptionLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ExceptionLog>(exceptionLogMapper.selectAll());
    }

    /**
     * ExceptionLog条件查询
     * @param exceptionLog
     * @return
     */
    @Override
    public List<ExceptionLog> findList(ExceptionLog exceptionLog){
        //构建查询条件
        Example example = createExample(exceptionLog);
        //根据构建的条件查询数据
        return exceptionLogMapper.selectByExample(example);
    }


    /**
     * ExceptionLog构建查询对象
     * @param exceptionLog
     * @return
     */
    public Example createExample(ExceptionLog exceptionLog){
        Example example=new Example(ExceptionLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(exceptionLog!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(exceptionLog.getUid())){
                    criteria.andEqualTo("uid",exceptionLog.getUid());
            }
            // 异常对象json格式
            if(!StringUtils.isEmpty(exceptionLog.getExceptionJson())){
                    criteria.andEqualTo("exceptionJson",exceptionLog.getExceptionJson());
            }
            // 异常信息
            if(!StringUtils.isEmpty(exceptionLog.getExceptionMessage())){
                    criteria.andEqualTo("exceptionMessage",exceptionLog.getExceptionMessage());
            }
            // 状态
            if(!StringUtils.isEmpty(exceptionLog.getStatus())){
                    criteria.andEqualTo("status",exceptionLog.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(exceptionLog.getCreateTime())){
                    criteria.andEqualTo("createTime",exceptionLog.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(exceptionLog.getUpdateTime())){
                    criteria.andEqualTo("updateTime",exceptionLog.getUpdateTime());
            }
            // ip地址
            if(!StringUtils.isEmpty(exceptionLog.getIp())){
                    criteria.andEqualTo("ip",exceptionLog.getIp());
            }
            // ip来源
            if(!StringUtils.isEmpty(exceptionLog.getIpSource())){
                    criteria.andEqualTo("ipSource",exceptionLog.getIpSource());
            }
            // 请求方法
            if(!StringUtils.isEmpty(exceptionLog.getMethod())){
                    criteria.andEqualTo("method",exceptionLog.getMethod());
            }
            // 方法描述
            if(!StringUtils.isEmpty(exceptionLog.getOperation())){
                    criteria.andEqualTo("operation",exceptionLog.getOperation());
            }
            // 请求参数
            if(!StringUtils.isEmpty(exceptionLog.getParams())){
                    criteria.andEqualTo("params",exceptionLog.getParams());
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
        exceptionLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ExceptionLog
     * @param exceptionLog
     */
    @Override
    public void update(ExceptionLog exceptionLog){
        exceptionLogMapper.updateByPrimaryKey(exceptionLog);
    }

    /**
     * 增加ExceptionLog
     * @param exceptionLog
     */
    @Override
    public void add(ExceptionLog exceptionLog){
        exceptionLogMapper.insert(exceptionLog);
    }

    /**
     * 根据ID查询ExceptionLog
     * @param id
     * @return
     */
    @Override
    public ExceptionLog findById(String id){
        return  exceptionLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ExceptionLog全部数据
     * @return
     */
    @Override
    public List<ExceptionLog> findAll() {
        return exceptionLogMapper.selectAll();
    }
}
