package com.marvelous.blog.service.impl;
import com.marvelous.blog.dao.CommentMapper;
import pojo.Comment;
import com.marvelous.blog.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Comment业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    /**
     * Comment条件+分页查询
     * @param comment 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Comment> findPage(Comment comment, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(comment);
        //执行搜索
        return new PageInfo<Comment>(commentMapper.selectByExample(example));
    }

    /**
     * Comment分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Comment> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Comment>(commentMapper.selectAll());
    }

    /**
     * Comment条件查询
     * @param comment
     * @return
     */
    @Override
    public List<Comment> findList(Comment comment){
        //构建查询条件
        Example example = createExample(comment);
        //根据构建的条件查询数据
        return commentMapper.selectByExample(example);
    }


    /**
     * Comment构建查询对象
     * @param comment
     * @return
     */
    public Example createExample(Comment comment){
        Example example=new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        if(comment!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(comment.getUid())){
                    criteria.andEqualTo("uid",comment.getUid());
            }
            // 用户uid
            if(!StringUtils.isEmpty(comment.getUserUid())){
                    criteria.andEqualTo("userUid",comment.getUserUid());
            }
            // 回复某条评论的uid
            if(!StringUtils.isEmpty(comment.getToUid())){
                    criteria.andEqualTo("toUid",comment.getToUid());
            }
            // 回复某个人的uid
            if(!StringUtils.isEmpty(comment.getToUserUid())){
                    criteria.andEqualTo("toUserUid",comment.getToUserUid());
            }
            // 评论内容
            if(!StringUtils.isEmpty(comment.getContent())){
                    criteria.andEqualTo("content",comment.getContent());
            }
            // 博客uid
            if(!StringUtils.isEmpty(comment.getBlogUid())){
                    criteria.andEqualTo("blogUid",comment.getBlogUid());
            }
            // 状态
            if(!StringUtils.isEmpty(comment.getStatus())){
                    criteria.andEqualTo("status",comment.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(comment.getCreateTime())){
                    criteria.andEqualTo("createTime",comment.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(comment.getUpdateTime())){
                    criteria.andEqualTo("updateTime",comment.getUpdateTime());
            }
            // 评论来源： MESSAGE_BOARD，ABOUT，BLOG_INFO 等
            if(!StringUtils.isEmpty(comment.getSource())){
                    criteria.andEqualTo("source",comment.getSource());
            }
            // 评论类型 1:点赞 0:评论
            if(!StringUtils.isEmpty(comment.getTYPE())){
                    criteria.andEqualTo("TYPE",comment.getTYPE());
            }
            // 一级评论UID
            if(!StringUtils.isEmpty(comment.getFirstCommentUid())){
                    criteria.andEqualTo("firstCommentUid",comment.getFirstCommentUid());
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
        commentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Comment
     * @param comment
     */
    @Override
    public void update(Comment comment){
        commentMapper.updateByPrimaryKey(comment);
    }

    /**
     * 增加Comment
     * @param comment
     */
    @Override
    public void add(Comment comment){
        commentMapper.insert(comment);
    }

    /**
     * 根据ID查询Comment
     * @param id
     * @return
     */
    @Override
    public Comment findById(String id){
        return  commentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Comment全部数据
     * @return
     */
    @Override
    public List<Comment> findAll() {
        return commentMapper.selectAll();
    }
}
