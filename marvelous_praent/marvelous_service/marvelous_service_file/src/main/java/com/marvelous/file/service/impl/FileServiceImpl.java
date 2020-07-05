package com.marvelous.file.service.impl;
import com.marvelous.file.dao.FileMapper;
import pojo.File;
import com.marvelous.file.service.FileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:File业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;


    /**
     * File条件+分页查询
     * @param file 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<File> findPage(File file, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(file);
        //执行搜索
        return new PageInfo<File>(fileMapper.selectByExample(example));
    }

    /**
     * File分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<File> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<File>(fileMapper.selectAll());
    }

    /**
     * File条件查询
     * @param file
     * @return
     */
    @Override
    public List<File> findList(File file){
        //构建查询条件
        Example example = createExample(file);
        //根据构建的条件查询数据
        return fileMapper.selectByExample(example);
    }


    /**
     * File构建查询对象
     * @param file
     * @return
     */
    public Example createExample(File file){
        Example example=new Example(File.class);
        Example.Criteria criteria = example.createCriteria();
        if(file!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(file.getUid())){
                    criteria.andEqualTo("uid",file.getUid());
            }
            // 旧文件名
            if(!StringUtils.isEmpty(file.getFileOldName())){
                    criteria.andEqualTo("fileOldName",file.getFileOldName());
            }
            // 文件名
            if(!StringUtils.isEmpty(file.getPicName())){
                    criteria.andEqualTo("picName",file.getPicName());
            }
            // 文件地址
            if(!StringUtils.isEmpty(file.getPicUrl())){
                    criteria.andEqualTo("picUrl",file.getPicUrl());
            }
            // 文件扩展名
            if(!StringUtils.isEmpty(file.getPicExpandedName())){
                    criteria.andEqualTo("picExpandedName",file.getPicExpandedName());
            }
            // 文件大小
            if(!StringUtils.isEmpty(file.getFileSize())){
                    criteria.andEqualTo("fileSize",file.getFileSize());
            }
            // 文件分类uid
            if(!StringUtils.isEmpty(file.getFileSortUid())){
                    criteria.andEqualTo("fileSortUid",file.getFileSortUid());
            }
            // 管理员uid
            if(!StringUtils.isEmpty(file.getAdminUid())){
                    criteria.andEqualTo("adminUid",file.getAdminUid());
            }
            // 用户uid
            if(!StringUtils.isEmpty(file.getUserUid())){
                    criteria.andEqualTo("userUid",file.getUserUid());
            }
            // 状态
            if(!StringUtils.isEmpty(file.getStatus())){
                    criteria.andEqualTo("status",file.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(file.getCreateTime())){
                    criteria.andEqualTo("createTime",file.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(file.getUpdateTime())){
                    criteria.andEqualTo("updateTime",file.getUpdateTime());
            }
            // 七牛云地址
            if(!StringUtils.isEmpty(file.getQiNiuUrl())){
                    criteria.andEqualTo("qiNiuUrl",file.getQiNiuUrl());
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
        fileMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改File
     * @param file
     */
    @Override
    public void update(File file){
        fileMapper.updateByPrimaryKey(file);
    }

    /**
     * 增加File
     * @param file
     */
    @Override
    public void add(File file){
        fileMapper.insert(file);
    }

    /**
     * 根据ID查询File
     * @param id
     * @return
     */
    @Override
    public File findById(String id){
        return  fileMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询File全部数据
     * @return
     */
    @Override
    public List<File> findAll() {
        return fileMapper.selectAll();
    }
}
