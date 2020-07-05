package pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
/****
 * @Author:wuwenzhaoxi
 * @Description:ExceptionLog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "ExceptionLog",value = "ExceptionLog")
@Table(name="exception_log")
public class ExceptionLog implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "异常对象json格式",required = false)
    @Column(name = "exception_json")
	private String exceptionJson;//异常对象json格式

	@ApiModelProperty(value = "异常信息",required = false)
    @Column(name = "exception_message")
	private String exceptionMessage;//异常信息

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private String status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "ip地址",required = false)
    @Column(name = "ip")
	private String ip;//ip地址

	@ApiModelProperty(value = "ip来源",required = false)
    @Column(name = "ip_source")
	private String ipSource;//ip来源

	@ApiModelProperty(value = "请求方法",required = false)
    @Column(name = "method")
	private String method;//请求方法

	@ApiModelProperty(value = "方法描述",required = false)
    @Column(name = "operation")
	private String operation;//方法描述

	@ApiModelProperty(value = "请求参数",required = false)
    @Column(name = "params")
	private String params;//请求参数



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
	}
	//get方法
	public String getExceptionJson() {
		return exceptionJson;
	}

	//set方法
	public void setExceptionJson(String exceptionJson) {
		this.exceptionJson = exceptionJson;
	}
	//get方法
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	//set方法
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
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
	public String getIp() {
		return ip;
	}

	//set方法
	public void setIp(String ip) {
		this.ip = ip;
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
	public String getMethod() {
		return method;
	}

	//set方法
	public void setMethod(String method) {
		this.method = method;
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
	public String getParams() {
		return params;
	}

	//set方法
	public void setParams(String params) {
		this.params = params;
	}


}
