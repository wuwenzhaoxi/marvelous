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
 * @Description:SysLog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysLog",value = "SysLog")
@Table(name="sys_log")
public class SysLog implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "user_name")
	private String userName;//用户名

	@ApiModelProperty(value = "管理员uid",required = false)
    @Column(name = "admin_uid")
	private String adminUid;//管理员uid

	@ApiModelProperty(value = "请求ip地址",required = false)
    @Column(name = "ip")
	private String ip;//请求ip地址

	@ApiModelProperty(value = "请求url",required = false)
    @Column(name = "url")
	private String url;//请求url

	@ApiModelProperty(value = "请求方式",required = false)
    @Column(name = "type")
	private String type;//请求方式

	@ApiModelProperty(value = "请求类路径",required = false)
    @Column(name = "class_path")
	private String classPath;//请求类路径

	@ApiModelProperty(value = "请求方法名",required = false)
    @Column(name = "method")
	private String method;//请求方法名

	@ApiModelProperty(value = "请求参数",required = false)
    @Column(name = "params")
	private String params;//请求参数

	@ApiModelProperty(value = "描述",required = false)
    @Column(name = "operation")
	private String operation;//描述

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private String status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "ip来源",required = false)
    @Column(name = "ip_source")
	private String ipSource;//ip来源

	@ApiModelProperty(value = "方法请求花费的时间",required = false)
    @Column(name = "spend_time")
	private Integer spendTime;//方法请求花费的时间



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
	}
	//get方法
	public String getUserName() {
		return userName;
	}

	//set方法
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getIp() {
		return ip;
	}

	//set方法
	public void setIp(String ip) {
		this.ip = ip;
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
	public String getType() {
		return type;
	}

	//set方法
	public void setType(String type) {
		this.type = type;
	}
	//get方法
	public String getClassPath() {
		return classPath;
	}

	//set方法
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
	//get方法
	public String getMethod() {
		return method;
	}

	//set方法
	public void setMethod(String method) {
		this.method = method;
	}
	//get方法
	public String getParams() {
		return params;
	}

	//set方法
	public void setParams(String params) {
		this.params = params;
	}
	//get方法
	public String getOperation() {
		return operation;
	}

	//set方法
	public void setOperation(String operation) {
		this.operation = operation;
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
	public String getIpSource() {
		return ipSource;
	}

	//set方法
	public void setIpSource(String ipSource) {
		this.ipSource = ipSource;
	}
	//get方法
	public Integer getSpendTime() {
		return spendTime;
	}

	//set方法
	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}


}
