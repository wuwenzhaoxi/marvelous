package com.marvelous.admin.service.impl;
import com.marvelous.admin.dao.SysDictTypeMapper;
import pojo.SysDictType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.marvelous.admin.service.SysDictTypeService;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:SysDictType业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;


    /**
     * SysDictType条件+分页查询
     * @param sysDictType 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysDictType> findPage(SysDictType sysDictType, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysDictType);
        //执行搜索
        return new PageInfo<SysDictType>(sysDictTypeMapper.selectByExample(example));
    }

    /**
     * SysDictType分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysDictType> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysDictType>(sysDictTypeMapper.selectAll());
    }

    /**
     * SysDictType条件查询
     * @param sysDictType
     * @return
     */
    @Override
    public List<SysDictType> findList(SysDictType sysDictType){
        //构建查询条件
        Example example = createExample(sysDictType);
        //根据构建的条件查询数据
        return sysDictTypeMapper.selectByExample(example);
    }


    /**
     * SysDictType构建查询对象
     * @param sysDictType
     * @return
     */
    public Example createExample(SysDictType sysDictType){
        Example example=new Example(SysDictType.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysDictType!=null){
            // 主键
            if(!StringUtils.isEmpty(sysDictType.getUid())){
                    criteria.andEqualTo("uid",sysDictType.getUid());
            }
            // 自增键oid
            if(!StringUtils.isEmpty(sysDictType.getOid())){
                    criteria.andEqualTo("oid",sysDictType.getOid());
            }
            // 字典名称
            if(!StringUtils.isEmpty(sysDictType.getDictName())){
                    criteria.andEqualTo("dictName",sysDictType.getDictName());
            }
            // 字典类型
            if(!StringUtils.isEmpty(sysDictType.getDictType())){
                    criteria.andEqualTo("dictType",sysDictType.getDictType());
            }
            // 创建人UID
            if(!StringUtils.isEmpty(sysDictType.getCreateByUid())){
                    criteria.andEqualTo("createByUid",sysDictType.getCreateByUid());
            }
            // 最后更新人UID
            if(!StringUtils.isEmpty(sysDictType.getUpdateByUid())){
                    criteria.andEqualTo("updateByUid",sysDictType.getUpdateByUid());
            }
            // 备注
            if(!StringUtils.isEmpty(sysDictType.getRemark())){
                    criteria.andEqualTo("remark",sysDictType.getRemark());
            }
            // 状态
            if(!StringUtils.isEmpty(sysDictType.getStatus())){
                    criteria.andEqualTo("status",sysDictType.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysDictType.getCreateTime())){
                    criteria.andEqualTo("createTime",sysDictType.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(sysDictType.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sysDictType.getUpdateTime());
            }
            // 是否发布(1:是，0:否)
            if(!StringUtils.isEmpty(sysDictType.getIsPublish())){
                    criteria.andEqualTo("isPublish",sysDictType.getIsPublish());
            }
            // 排序字段
            if(!StringUtils.isEmpty(sysDictType.getSort())){
                    criteria.andEqualTo("sort",sysDictType.getSort());
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
        sysDictTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysDictType
     * @param sysDictType
     */
    @Override
    public void update(SysDictType sysDictType){
        sysDictTypeMapper.updateByPrimaryKey(sysDictType);
    }

    /**
     * 增加SysDictType
     * @param sysDictType
     */
    @Override
    public void add(SysDictType sysDictType){
        sysDictTypeMapper.insert(sysDictType);
    }

    /**
     * 根据ID查询SysDictType
     * @param id
     * @return
     */
    @Override
    public SysDictType findById(String id){
        return  sysDictTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysDictType全部数据
     * @return
     */
    @Override
    public List<SysDictType> findAll() {
        return sysDictTypeMapper.selectAll();
    }
}
