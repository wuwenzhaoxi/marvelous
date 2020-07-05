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
 * @Description:SysDictData构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysDictData",value = "SysDictData")
@Table(name="sys_dict_data")
public class SysDictData implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//主键

	@ApiModelProperty(value = "自增键oid",required = false)
    @Column(name = "oid")
	private Integer oid;//自增键oid

	@ApiModelProperty(value = "字典类型UID",required = false)
    @Column(name = "dict_type_uid")
	private String dictTypeUid;//字典类型UID

	@ApiModelProperty(value = "字典标签",required = false)
    @Column(name = "dict_label")
	private String dictLabel;//字典标签

	@ApiModelProperty(value = "字典键值",required = false)
    @Column(name = "dict_value")
	private String dictValue;//字典键值

	@ApiModelProperty(value = "样式属性（其他样式扩展）",required = false)
    @Column(name = "css_class")
	private String cssClass;//样式属性（其他样式扩展）

	@ApiModelProperty(value = "表格回显样式",required = false)
    @Column(name = "list_class")
	private String listClass;//表格回显样式

	@ApiModelProperty(value = "是否默认（1是 0否）,默认为0",required = false)
    @Column(name = "is_default")
	private String isDefault;//是否默认（1是 0否）,默认为0

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
	public String getDictTypeUid() {
		return dictTypeUid;
	}

	//set方法
	public void setDictTypeUid(String dictTypeUid) {
		this.dictTypeUid = dictTypeUid;
	}
	//get方法
	public String getDictLabel() {
		return dictLabel;
	}

	//set方法
	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
	}
	//get方法
	public String getDictValue() {
		return dictValue;
	}

	//set方法
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	//get方法
	public String getCssClass() {
		return cssClass;
	}

	//set方法
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	//get方法
	public String getListClass() {
		return listClass;
	}

	//set方法
	public void setListClass(String listClass) {
		this.listClass = listClass;
	}
	//get方法
	public String getIsDefault() {
		return isDefault;
	}

	//set方法
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
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
