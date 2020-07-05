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
 * @Description:PictureSort构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "PictureSort",value = "PictureSort")
@Table(name="picture_sort")
public class PictureSort implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "分类图片uid",required = false)
    @Column(name = "file_uid")
	private String fileUid;//分类图片uid

	@ApiModelProperty(value = "分类名",required = false)
    @Column(name = "name")
	private String name;//分类名

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "",required = false)
    @Column(name = "parent_uid")
	private String parentUid;//

	@ApiModelProperty(value = "排序字段，越大越靠前",required = false)
    @Column(name = "sort")
	private Integer sort;//排序字段，越大越靠前

	@ApiModelProperty(value = "是否显示，1：是，0，否",required = false)
    @Column(name = "is_show")
	private String isShow;//是否显示，1：是，0，否



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
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
	//get方法
	public String getIsShow() {
		return isShow;
	}

	//set方法
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}


}
