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
 * @Description:ResourceSort构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "ResourceSort",value = "ResourceSort")
@Table(name="resource_sort")
public class ResourceSort implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "分类图片uid",required = false)
    @Column(name = "file_uid")
	private String fileUid;//分类图片uid

	@ApiModelProperty(value = "分类名",required = false)
    @Column(name = "sort_name")
	private String sortName;//分类名

	@ApiModelProperty(value = "分类介绍",required = false)
    @Column(name = "content")
	private String content;//分类介绍

	@ApiModelProperty(value = "点击数",required = false)
    @Column(name = "click_count")
	private String clickCount;//点击数

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "父UID",required = false)
    @Column(name = "parent_uid")
	private String parentUid;//父UID

	@ApiModelProperty(value = "排序字段",required = false)
    @Column(name = "sort")
	private Integer sort;//排序字段



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getSortName() {
		return sortName;
	}

	//set方法
	public void setSortName(String sortName) {
		this.sortName = sortName;
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
	public String getClickCount() {
		return clickCount;
	}

	//set方法
	public void setClickCount(String clickCount) {
		this.clickCount = clickCount;
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
	public String getParentUid() {
		return parentUid;
	}

	//set方法
	public void setParentUid(String parentUid) {
		this.parentUid = parentUid;
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
