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
 * @Description:File构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "File",value = "File")
@Table(name="file")
public class File implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "旧文件名",required = false)
    @Column(name = "file_old_name")
	private String fileOldName;//旧文件名

	@ApiModelProperty(value = "文件名",required = false)
    @Column(name = "pic_name")
	private String picName;//文件名

	@ApiModelProperty(value = "文件地址",required = false)
    @Column(name = "pic_url")
	private String picUrl;//文件地址

	@ApiModelProperty(value = "文件扩展名",required = false)
    @Column(name = "pic_expanded_name")
	private String picExpandedName;//文件扩展名

	@ApiModelProperty(value = "文件大小",required = false)
    @Column(name = "file_size")
	private Integer fileSize;//文件大小

	@ApiModelProperty(value = "文件分类uid",required = false)
    @Column(name = "file_sort_uid")
	private String fileSortUid;//文件分类uid

	@ApiModelProperty(value = "管理员uid",required = false)
    @Column(name = "admin_uid")
	private String adminUid;//管理员uid

	@ApiModelProperty(value = "用户uid",required = false)
    @Column(name = "user_uid")
	private String userUid;//用户uid

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "七牛云地址",required = false)
    @Column(name = "qi_niu_url")
	private String qiNiuUrl;//七牛云地址



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
	}
	//get方法
	public String getFileOldName() {
		return fileOldName;
	}

	//set方法
	public void setFileOldName(String fileOldName) {
		this.fileOldName = fileOldName;
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
	public String getPicUrl() {
		return picUrl;
	}

	//set方法
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	//get方法
	public String getPicExpandedName() {
		return picExpandedName;
	}

	//set方法
	public void setPicExpandedName(String picExpandedName) {
		this.picExpandedName = picExpandedName;
	}
	//get方法
	public Integer getFileSize() {
		return fileSize;
	}

	//set方法
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	//get方法
	public String getFileSortUid() {
		return fileSortUid;
	}

	//set方法
	public void setFileSortUid(String fileSortUid) {
		this.fileSortUid = fileSortUid;
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
	public String getUserUid() {
		return userUid;
	}

	//set方法
	public void setUserUid(String userUid) {
		this.userUid = userUid;
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
	public String getQiNiuUrl() {
		return qiNiuUrl;
	}

	//set方法
	public void setQiNiuUrl(String qiNiuUrl) {
		this.qiNiuUrl = qiNiuUrl;
	}


}
