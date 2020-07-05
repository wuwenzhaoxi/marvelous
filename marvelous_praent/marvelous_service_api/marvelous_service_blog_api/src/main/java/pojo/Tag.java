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
 * @Description:Tag构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Tag",value = "Tag")
@Table(name="tag")
public class Tag implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "标签内容",required = false)
    @Column(name = "content")
	private String content;//标签内容

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "标签简介",required = false)
    @Column(name = "click_count")
	private Integer clickCount;//标签简介

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "排序字段，越大越靠前",required = false)
    @Column(name = "sort")
	private Integer sort;//排序字段，越大越靠前



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
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
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
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
	public Integer getSort() {
		return sort;
	}

	//set方法
	public void setSort(Integer sort) {
		this.sort = sort;
	}


}
