package com.marvelous.blog.service.impl;
import com.marvelous.blog.dao.BlogMapper;
import pojo.Blog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.marvelous.blog.service.BlogService;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:wuwenzhaoxi
 * @Description:Blog业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;


    /**
     * Blog条件+分页查询
     * @param blog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Blog> findPage(Blog blog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(blog);
        //执行搜索
        return new PageInfo<Blog>(blogMapper.selectByExample(example));
    }

    /**
     * Blog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Blog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Blog>(blogMapper.selectAll());
    }

    /**
     * Blog条件查询
     * @param blog
     * @return
     */
    @Override
    public List<Blog> findList(Blog blog){
        //构建查询条件
        Example example = createExample(blog);
        //根据构建的条件查询数据
        return blogMapper.selectByExample(example);
    }


    /**
     * Blog构建查询对象
     * @param blog
     * @return
     */
    public Example createExample(Blog blog){
        Example example=new Example(Blog.class);
        Example.Criteria criteria = example.createCriteria();
        if(blog!=null){
            // 唯一uid
            if(!StringUtils.isEmpty(blog.getUid())){
                    criteria.andEqualTo("uid",blog.getUid());
            }
            // 博客标题
            if(!StringUtils.isEmpty(blog.getTitle())){
                    criteria.andLike("title","%"+blog.getTitle()+"%");
            }
            // 博客简介
            if(!StringUtils.isEmpty(blog.getSummary())){
                    criteria.andEqualTo("summary",blog.getSummary());
            }
            // 博客内容
            if(!StringUtils.isEmpty(blog.getContent())){
                    criteria.andEqualTo("content",blog.getContent());
            }
            // 标签uid
            if(!StringUtils.isEmpty(blog.getTagUid())){
                    criteria.andEqualTo("tagUid",blog.getTagUid());
            }
            // 博客点击数
            if(!StringUtils.isEmpty(blog.getClickCount())){
                    criteria.andEqualTo("clickCount",blog.getClickCount());
            }
            // 博客收藏数
            if(!StringUtils.isEmpty(blog.getCollectCount())){
                    criteria.andEqualTo("collectCount",blog.getCollectCount());
            }
            // 标题图片uid
            if(!StringUtils.isEmpty(blog.getFileUid())){
                    criteria.andEqualTo("fileUid",blog.getFileUid());
            }
            // 状态
            if(!StringUtils.isEmpty(blog.getStatus())){
                    criteria.andEqualTo("status",blog.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(blog.getCreateTime())){
                    criteria.andEqualTo("createTime",blog.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(blog.getUpdateTime())){
                    criteria.andEqualTo("updateTime",blog.getUpdateTime());
            }
            // 管理员uid
            if(!StringUtils.isEmpty(blog.getAdminUid())){
                    criteria.andEqualTo("adminUid",blog.getAdminUid());
            }
            // 是否原创（0:不是 1：是）
            if(!StringUtils.isEmpty(blog.getIsOriginal())){
                    criteria.andEqualTo("isOriginal",blog.getIsOriginal());
            }
            // 作者
            if(!StringUtils.isEmpty(blog.getAuthor())){
                    criteria.andEqualTo("author",blog.getAuthor());
            }
            // 文章出处
            if(!StringUtils.isEmpty(blog.getArticlesPart())){
                    criteria.andEqualTo("articlesPart",blog.getArticlesPart());
            }
            // 博客分类UID
            if(!StringUtils.isEmpty(blog.getBlogSortUid())){
                    criteria.andEqualTo("blogSortUid",blog.getBlogSortUid());
            }
            // 推荐等级(0:正常)
            if(!StringUtils.isEmpty(blog.getLevel())){
                    criteria.andEqualTo("level",blog.getLevel());
            }
            // 是否发布：0：否，1：是
            if(!StringUtils.isEmpty(blog.getIsPublish())){
                    criteria.andEqualTo("isPublish",blog.getIsPublish());
            }
            // 排序字段
            if(!StringUtils.isEmpty(blog.getSort())){
                    criteria.andEqualTo("sort",blog.getSort());
            }
            // 是否开启评论(0:否 1:是)
            if(!StringUtils.isEmpty(blog.getStartComment())){
                    criteria.andEqualTo("startComment",blog.getStartComment());
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
        blogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Blog
     * @param blog
     */
    @Override
    public void update(Blog blog){
        blogMapper.updateByPrimaryKey(blog);
    }

    /**
     * 增加Blog
     * @param blog
     */
    @Override
    public void add(Blog blog){
        blogMapper.insert(blog);
    }

    /**
     * 根据ID查询Blog
     * @param id
     * @return
     */
    @Override
    public Blog findById(String id){
        return  blogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Blog全部数据
     * @return
     */
    @Override
    public List<Blog> findAll() {
        return blogMapper.selectAll();
    }
}
