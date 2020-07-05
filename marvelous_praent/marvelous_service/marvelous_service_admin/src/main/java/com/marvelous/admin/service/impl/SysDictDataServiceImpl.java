package com.marvelous.admin.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.marvelous.admin.dao.SysDictDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.SysDictData;
import com.marvelous.admin.service.SysDictDataService;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:SysDictData业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysDictDataServiceImpl implements SysDictDataService {

    @Autowired
    private SysDictDataMapper sysDictDataMapper;


    /**
     * SysDictData条件+分页查询
     * @param sysDictData 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysDictData> findPage(SysDictData sysDictData, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysDictData);
        //执行搜索
        return new PageInfo<SysDictData>(sysDictDataMapper.selectByExample(example));
    }

    /**
     * SysDictData分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysDictData> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysDictData>(sysDictDataMapper.selectAll());
    }

    /**
     * SysDictData条件查询
     * @param sysDictData
     * @return
     */
    @Override
    public List<SysDictData> findList(SysDictData sysDictData){
        //构建查询条件
        Example example = createExample(sysDictData);
        //根据构建的条件查询数据
        return sysDictDataMapper.selectByExample(example);
    }


    /**
     * SysDictData构建查询对象
     * @param sysDictData
     * @return
     */
    public Example createExample(SysDictData sysDictData){
        Example example=new Example(SysDictData.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysDictData!=null){
            // 主键
            if(!StringUtils.isEmpty(sysDictData.getUid())){
                    criteria.andEqualTo("uid",sysDictData.getUid());
            }
            // 自增键oid
            if(!StringUtils.isEmpty(sysDictData.getOid())){
                    criteria.andEqualTo("oid",sysDictData.getOid());
            }
            // 字典类型UID
            if(!StringUtils.isEmpty(sysDictData.getDictTypeUid())){
                    criteria.andEqualTo("dictTypeUid",sysDictData.getDictTypeUid());
            }
            // 字典标签
            if(!StringUtils.isEmpty(sysDictData.getDictLabel())){
                    criteria.andEqualTo("dictLabel",sysDictData.getDictLabel());
            }
            // 字典键值
            if(!StringUtils.isEmpty(sysDictData.getDictValue())){
                    criteria.andEqualTo("dictValue",sysDictData.getDictValue());
            }
            // 样式属性（其他样式扩展）
            if(!StringUtils.isEmpty(sysDictData.getCssClass())){
                    criteria.andEqualTo("cssClass",sysDictData.getCssClass());
            }
            // 表格回显样式
            if(!StringUtils.isEmpty(sysDictData.getListClass())){
                    criteria.andEqualTo("listClass",sysDictData.getListClass());
            }
            // 是否默认（1是 0否）,默认为0
            if(!StringUtils.isEmpty(sysDictData.getIsDefault())){
                    criteria.andEqualTo("isDefault",sysDictData.getIsDefault());
            }
            // 创建人UID
            if(!StringUtils.isEmpty(sysDictData.getCreateByUid())){
                    criteria.andEqualTo("createByUid",sysDictData.getCreateByUid());
            }
            // 最后更新人UID
            if(!StringUtils.isEmpty(sysDictData.getUpdateByUid())){
                    criteria.andEqualTo("updateByUid",sysDictData.getUpdateByUid());
            }
            // 备注
            if(!StringUtils.isEmpty(sysDictData.getRemark())){
                    criteria.andEqualTo("remark",sysDictData.getRemark());
            }
            // 状态
            if(!StringUtils.isEmpty(sysDictData.getStatus())){
                    criteria.andEqualTo("status",sysDictData.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysDictData.getCreateTime())){
                    criteria.andEqualTo("createTime",sysDictData.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(sysDictData.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sysDictData.getUpdateTime());
            }
            // 是否发布(1:是，0:否)
            if(!StringUtils.isEmpty(sysDictData.getIsPublish())){
                    criteria.andEqualTo("isPublish",sysDictData.getIsPublish());
            }
            // 排序字段
            if(!StringUtils.isEmpty(sysDictData.getSort())){
                    criteria.andEqualTo("sort",sysDictData.getSort());
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
        sysDictDataMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysDictData
     * @param sysDictData
     */
    @Override
    public void update(SysDictData sysDictData){
        sysDictDataMapper.updateByPrimaryKey(sysDictData);
    }

    /**
     * 增加SysDictData
     * @param sysDictData
     */
    @Override
    public void add(SysDictData sysDictData){
        sysDictDataMapper.insert(sysDictData);
    }

    /**
     * 根据ID查询SysDictData
     * @param id
     * @return
     */
    @Override
    public SysDictData findById(String id){
        return  sysDictDataMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysDictData全部数据
     * @return
     */
    @Override
    public List<SysDictData> findAll() {
        return sysDictDataMapper.selectAll();
    }
}
