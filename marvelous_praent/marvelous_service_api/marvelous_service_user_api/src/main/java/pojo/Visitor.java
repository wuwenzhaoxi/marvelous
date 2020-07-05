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
 * @Description:Visitor构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Visitor",value = "Visitor")
@Table(name="visitor")
public class Visitor implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "user_name")
	private String userName;//用户名

	@ApiModelProperty(value = "邮箱",required = false)
    @Column(name = "email")
	private String email;//邮箱

	@ApiModelProperty(value = "登录次数",required = false)
    @Column(name = "login_count")
	private Integer loginCount;//登录次数

	@ApiModelProperty(value = "最后登录时间",required = false)
    @Column(name = "last_login_time")
	private Date lastLoginTime;//最后登录时间

	@ApiModelProperty(value = "最后登录IP",required = false)
    @Column(name = "last_login_ip")
	private String lastLoginIp;//最后登录IP

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
	public String getUserName() {
		return userName;
	}

	//set方法
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//get方法
	public String getEmail() {
		return email;
	}

	//set方法
	public void setEmail(String email) {
		this.email = email;
	}
	//get方法
	public Integer getLoginCount() {
		return loginCount;
	}

	//set方法
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	//get方法
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	//set方法
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	//get方法
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	//set方法
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
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
