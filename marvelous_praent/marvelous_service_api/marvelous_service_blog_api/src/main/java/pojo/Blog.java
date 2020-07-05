package pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:wuwenzhaoxi
 * @Description:Blog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Blog",value = "Blog")
@Table(name="blog")
public class Blog implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "博客标题",required = false)
    @Column(name = "title")
	private String title;//博客标题

	@ApiModelProperty(value = "博客简介",required = false)
    @Column(name = "summary")
	private String summary;//博客简介

	@ApiModelProperty(value = "博客内容",required = false)
    @Column(name = "content")
	private String content;//博客内容

	@ApiModelProperty(value = "标签uid",required = false)
    @Column(name = "tag_uid")
	private String tagUid;//标签uid

	@ApiModelProperty(value = "博客点击数",required = false)
    @Column(name = "click_count")
	private Integer clickCount;//博客点击数

	@ApiModelProperty(value = "博客收藏数",required = false)
    @Column(name = "collect_count")
	private Integer collectCount;//博客收藏数

	@ApiModelProperty(value = "标题图片uid",required = false)
    @Column(name = "file_uid")
	private String fileUid;//标题图片uid

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "管理员uid",required = false)
    @Column(name = "admin_uid")
	private String adminUid;//管理员uid

	@ApiModelProperty(value = "是否原创（0:不是 1：是）",required = false)
    @Column(name = "is_original")
	private String isOriginal;//是否原创（0:不是 1：是）

	@ApiModelProperty(value = "作者",required = false)
    @Column(name = "author")
	private String author;//作者

	@ApiModelProperty(value = "文章出处",required = false)
    @Column(name = "articles_part")
	private String articlesPart;//文章出处

	@ApiModelProperty(value = "博客分类UID",required = false)
    @Column(name = "blog_sort_uid")
	private String blogSortUid;//博客分类UID

	@ApiModelProperty(value = "推荐等级(0:正常)",required = false)
    @Column(name = "level")
	private String level;//推荐等级(0:正常)

	@ApiModelProperty(value = "是否发布：0：否，1：是",required = false)
    @Column(name = "is_publish")
	private String isPublish;//是否发布：0：否，1：是

	@ApiModelProperty(value = "排序字段",required = false)
    @Column(name = "sort")
	private Integer sort;//排序字段

	@ApiModelProperty(value = "是否开启评论(0:否 1:是)",required = false)
    @Column(name = "start_comment")
	private String startComment;//是否开启评论(0:否 1:是)



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
	}
	//get方法
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}
	//get方法
	public String getSummary() {
		return summary;
	}

	//set方法
	public void setSummary(String summary) {
		this.summary = summary;
	}
	//get方法
	public String getContent() {
		return content;
	}

	//set方法
	public void setContent(String content) {
		this.content = content;
	}
	//get方法
	public String getTagUid() {
		return tagUid;
	}

	//set方法
	public void setTagUid(String tagUid) {
		this.tagUid = tagUid;
	}
	//get方法
	public Integer getClickCount() {
		return clickCount;
	}

	//set方法
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}
	//get方法
	public Integer getCollectCount() {
		return collectCount;
	}

	//set方法
	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}
	//get方法
	public String getFileUid() {
		return fileUid;
	}

	//set方法
	public void setFileUid(String fileUid) {
		this.fileUid = fileUid;
	}
	//get方法
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public String getAdminUid() {
		return adminUid;
	}

	//set方法
	public void setAdminUid(String adminUid) {
		this.adminUid = adminUid;
	}
	//get方法
	public String getIsOriginal() {
		return isOriginal;
	}

	//set方法
	public void setIsOriginal(String isOriginal) {
		this.isOriginal = isOriginal;
	}
	//get方法
	public String getAuthor() {
		return author;
	}

	//set方法
	public void setAuthor(String author) {
		this.author = author;
	}
	//get方法
	public String getArticlesPart() {
		return articlesPart;
	}

	//set方法
	public void setArticlesPart(String articlesPart) {
		this.articlesPart = articlesPart;
	}
	//get方法
	public String getBlogSortUid() {
		return blogSortUid;
	}

	//set方法
	public void setBlogSortUid(String blogSortUid) {
		this.blogSortUid = blogSortUid;
	}
	//get方法
	public String getLevel() {
		return level;
	}

	//set方法
	public void setLevel(String level) {
		this.level = level;
	}
	//get方法
	public String getIsPublish() {
		return isPublish;
	}

	//set方法
	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}
	//get方法
	public Integer getSort() {
		return sort;
	}

	//set方法
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	//get方法
	public String getStartComment() {
		return startComment;
	}

	//set方法
	public void setStartComment(String startComment) {
		this.startComment = startComment;
	}


}
