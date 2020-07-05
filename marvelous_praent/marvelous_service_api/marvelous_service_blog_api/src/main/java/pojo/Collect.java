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
 * @Description:Collect构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Collect",value = "Collect")
@Table(name="collect")
public class Collect implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "用户的uid",required = false)
    @Column(name = "user_uid")
	private String userUid;//用户的uid

	@ApiModelProperty(value = "博客的uid",required = false)
    @Column(name = "blog_uid")
	private String blogUid;//博客的uid

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


}
