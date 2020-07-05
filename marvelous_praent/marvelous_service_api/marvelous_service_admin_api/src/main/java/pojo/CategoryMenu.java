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
 * @Description:CategoryMenu构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "CategoryMenu",value = "CategoryMenu")
@Table(name="category_menu")
public class CategoryMenu implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "菜单名称",required = false)
    @Column(name = "name")
	private String name;//菜单名称

	@ApiModelProperty(value = "菜单级别",required = false)
    @Column(name = "menu_level")
	private String menuLevel;//菜单级别

	@ApiModelProperty(value = "简介",required = false)
    @Column(name = "summary")
	private String summary;//简介

	@ApiModelProperty(value = "父uid",required = false)
    @Column(name = "parent_uid")
	private String parentUid;//父uid

	@ApiModelProperty(value = "url地址",required = false)
    @Column(name = "url")
	private String url;//url地址

	@ApiModelProperty(value = "图标",required = false)
    @Column(name = "icon")
	private String icon;//图标

	@ApiModelProperty(value = "排序字段，越大越靠前",required = false)
    @Column(name = "sort")
	private Integer sort;//排序字段，越大越靠前

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private Integer status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "是否显示 1:是 0:否",required = false)
    @Column(name = "is_show")
	private String isShow;//是否显示 1:是 0:否

	@ApiModelProperty(value = "菜单类型 0: 菜单   1: 按钮",required = false)
    @Column(name = "menu_type")
	private String menuType;//菜单类型 0: 菜单   1: 按钮



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getMenuLevel() {
		return menuLevel;
	}

	//set方法
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	//get方法
	public String getSummary() {
		return summary;
	}

	//set方法
	public void setSummary(String summary) {
		this.summary = summary;
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
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
	}
	//get方法
	public String getIcon() {
		return icon;
	}

	//set方法
	public void setIcon(String icon) {
		this.icon = icon;
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
	public String getIsShow() {
		return isShow;
	}

	//set方法
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	//get方法
	public String getMenuType() {
		return menuType;
	}

	//set方法
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}


}
