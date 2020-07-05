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
 * @Description:CommentReport构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "CommentReport",value = "CommentReport")
@Table(name="comment_report")
public class CommentReport implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "举报人uid",required = false)
    @Column(name = "user_uid")
	private String userUid;//举报人uid

	@ApiModelProperty(value = "被举报的评论Uid",required = false)
    @Column(name = "report_comment_uid")
	private String reportCommentUid;//被举报的评论Uid

	@ApiModelProperty(value = "被举报的用户uid",required = false)
    @Column(name = "report_user_uid")
	private String reportUserUid;//被举报的用户uid

	@ApiModelProperty(value = "举报的原因",required = false)
    @Column(name = "content")
	private String content;//举报的原因

	@ApiModelProperty(value = "进展状态: 0 未查看   1: 已查看  2：已处理",required = false)
    @Column(name = "progress")
	private Integer progress;//进展状态: 0 未查看   1: 已查看  2：已处理

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间



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
	public String getReportCommentUid() {
		return reportCommentUid;
	}

	//set方法
	public void setReportCommentUid(String reportCommentUid) {
		this.reportCommentUid = reportCommentUid;
	}
	//get方法
	public String getReportUserUid() {
		return reportUserUid;
	}

	//set方法
	public void setReportUserUid(String reportUserUid) {
		this.reportUserUid = reportUserUid;
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
	public Integer getProgress() {
		return progress;
	}

	//set方法
	public void setProgress(Integer progress) {
		this.progress = progress;
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


}
