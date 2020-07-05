package com.marvelous.log.service.impl;
import com.marvelous.log.dao.CommentReportMapper;
import com.marvelous.log.service.CommentReportService;
import pojo.CommentReport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:CommentReport业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CommentReportServiceImpl implements CommentReportService {

    @Autowired
    private CommentReportMapper commentReportMapper;


    /**
     * CommentReport条件+分页查询
     * @param commentReport 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<CommentReport> findPage(CommentReport commentReport, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(commentReport);
        //执行搜索
        return new PageInfo<CommentReport>(commentReportMapper.selectByExample(example));
    }

    /**
     * CommentReport分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<CommentReport> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<CommentReport>(commentReportMapper.selectAll());
    }

    /**
     * CommentReport条件查询
     * @param commentReport
     * @return
     */
    @Override
    public List<CommentReport> findList(CommentReport commentReport){
        //构建查询条件
        Example example = createExample(commentReport);
        //根据构建的条件查询数据
        return commentReportMapper.selectByExample(example);
    }


    /**
     * CommentReport构建查询对象
     * @param commentReport
     * @return
     */
    public Example createExample(CommentReport commentReport){
        Example example=new Example(CommentReport.class);
        Example.Criteria criteria = example.createCriteria();
        if(commentReport!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(commentReport.getUid())){
                    criteria.andEqualTo("uid",commentReport.getUid());
            }
            // 举报人uid
            if(!StringUtils.isEmpty(commentReport.getUserUid())){
                    criteria.andEqualTo("userUid",commentReport.getUserUid());
            }
            // 被举报的评论Uid
            if(!StringUtils.isEmpty(commentReport.getReportCommentUid())){
                    criteria.andEqualTo("reportCommentUid",commentReport.getReportCommentUid());
            }
            // 被举报的用户uid
            if(!StringUtils.isEmpty(commentReport.getReportUserUid())){
                    criteria.andEqualTo("reportUserUid",commentReport.getReportUserUid());
            }
            // 举报的原因
            if(!StringUtils.isEmpty(commentReport.getContent())){
                    criteria.andEqualTo("content",commentReport.getContent());
            }
            // 进展状态: 0 未查看   1: 已查看  2：已处理
            if(!StringUtils.isEmpty(commentReport.getProgress())){
                    criteria.andEqualTo("progress",commentReport.getProgress());
            }
            // 状态
            if(!StringUtils.isEmpty(commentReport.getStatus())){
                    criteria.andEqualTo("status",commentReport.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(commentReport.getCreateTime())){
                    criteria.andEqualTo("createTime",commentReport.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(commentReport.getUpdateTime())){
                    criteria.andEqualTo("updateTime",commentReport.getUpdateTime());
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
        commentReportMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改CommentReport
     * @param commentReport
     */
    @Override
    public void update(CommentReport commentReport){
        commentReportMapper.updateByPrimaryKey(commentReport);
    }

    /**
     * 增加CommentReport
     * @param commentReport
     */
    @Override
    public void add(CommentReport commentReport){
        commentReportMapper.insert(commentReport);
    }

    /**
     * 根据ID查询CommentReport
     * @param id
     * @return
     */
    @Override
    public CommentReport findById(String id){
        return  commentReportMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询CommentReport全部数据
     * @return
     */
    @Override
    public List<CommentReport> findAll() {
        return commentReportMapper.selectAll();
    }
}
