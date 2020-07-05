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
 * @Description:Picture构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Picture",value = "Picture")
@Table(name="picture")
public class Picture implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "图片uid",required = false)
    @Column(name = "file_uid")
	private String fileUid;//图片uid

	@ApiModelProperty(value = "图片名",required = false)
    @Column(name = "pic_name")
	private String picName;//图片名

	@ApiModelProperty(value = "分类uid",required = false)
    @Column(name = "picture_sort_uid")
	private String pictureSortUid;//分类uid

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
	public String getFileUid() {
		return fileUid;
	}

	//set方法
	public void setFileUid(String fileUid) {
		this.fileUid = fileUid;
	}
	//get方法
	public String getPicName() {
		return picName;
	}

	//set方法
	public void setPicName(String picName) {
		this.picName = picName;
	}
	//get方法
	public String getPictureSortUid() {
		return pictureSortUid;
	}

	//set方法
	public void setPictureSortUid(String pictureSortUid) {
		this.pictureSortUid = pictureSortUid;
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
