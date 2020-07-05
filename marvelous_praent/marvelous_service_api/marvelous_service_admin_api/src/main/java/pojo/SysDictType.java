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
 * @Description:SysDictType构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysDictType",value = "SysDictType")
@Table(name="sys_dict_type")
public class SysDictType implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//主键

	@ApiModelProperty(value = "自增键oid",required = false)
    @Column(name = "oid")
	private Integer oid;//自增键oid

	@ApiModelProperty(value = "字典名称",required = false)
    @Column(name = "dict_name")
	private String dictName;//字典名称

	@ApiModelProperty(value = "字典类型",required = false)
    @Column(name = "dict_type")
	private String dictType;//字典类型

	@ApiModelProperty(value = "创建人UID",required = false)
    @Column(name = "create_by_uid")
	private String createByUid;//创建人UID

	@ApiModelProperty(value = "最后更新人UID",required = false)
    @Column(name = "update_by_uid")
	private String updateByUid;//最后更新人UID

	@ApiModelProperty(value = "备注",required = false)
    @Column(name = "remark")
	private String remark;//备注

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private String status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "是否发布(1:是，0:否)",required = false)
    @Column(name = "is_publish")
	private String isPublish;//是否发布(1:是，0:否)

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
	public Integer getOid() {
		return oid;
	}

	//set方法
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	//get方法
	public String getDictName() {
		return dictName;
	}

	//set方法
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	//get方法
	public String getDictType() {
		return dictType;
	}

	//set方法
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	//get方法
	public String getCreateByUid() {
		return createByUid;
	}

	//set方法
	public void setCreateByUid(String createByUid) {
		this.createByUid = createByUid;
	}
	//get方法
	public String getUpdateByUid() {
		return updateByUid;
	}

	//set方法
	public void setUpdateByUid(String updateByUid) {
		this.updateByUid = updateByUid;
	}
	//get方法
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
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


}
