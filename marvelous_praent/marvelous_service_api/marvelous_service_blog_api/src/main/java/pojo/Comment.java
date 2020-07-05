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
 * @Description:Comment构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Comment",value = "Comment")
@Table(name="comment")
public class Comment implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "用户uid",required = false)
    @Column(name = "user_uid")
	private String userUid;//用户uid

	@ApiModelProperty(value = "回复某条评论的uid",required = false)
    @Column(name = "to_uid")
	private String toUid;//回复某条评论的uid

	@ApiModelProperty(value = "回复某个人的uid",required = false)
    @Column(name = "to_user_uid")
	private String toUserUid;//回复某个人的uid

	@ApiModelProperty(value = "评论内容",required = false)
    @Column(name = "content")
	private String content;//评论内容

	@ApiModelProperty(value = "博客uid",required = false)
    @Column(name = "blog_uid")
	private String blogUid;//博客uid

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "评论来源： MESSAGE_BOARD，ABOUT，BLOG_INFO 等",required = false)
    @Column(name = "source")
	private String source;//评论来源： MESSAGE_BOARD，ABOUT，BLOG_INFO 等

	@ApiModelProperty(value = "评论类型 1:点赞 0:评论",required = false)
    @Column(name = "TYPE")
	private String TYPE;//评论类型 1:点赞 0:评论

	@ApiModelProperty(value = "一级评论UID",required = false)
    @Column(name = "first_comment_uid")
	private String firstCommentUid;//一级评论UID



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
	}
	//get方法
	public String getUserUid() {
		return userUid;
	}

	//set方法
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	//get方法
	public String getToUid() {
		return toUid;
	}

	//set方法
	public void setToUid(String toUid) {
		this.toUid = toUid;
	}
	//get方法
	public String getToUserUid() {
		return toUserUid;
	}

	//set方法
	public void setToUserUid(String toUserUid) {
		this.toUserUid = toUserUid;
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
	public String getBlogUid() {
		return blogUid;
	}

	//set方法
	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
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
	public String getSource() {
		return source;
	}

	//set方法
	public void setSource(String source) {
		this.source = source;
	}
	//get方法
	public String getTYPE() {
		return TYPE;
	}

	//set方法
	public void setTYPE(String TYPE) {
		this.TYPE = TYPE;
	}
	//get方法
	public String getFirstCommentUid() {
		return firstCommentUid;
	}

	//set方法
	public void setFirstCommentUid(String firstCommentUid) {
		this.firstCommentUid = firstCommentUid;
	}


}
