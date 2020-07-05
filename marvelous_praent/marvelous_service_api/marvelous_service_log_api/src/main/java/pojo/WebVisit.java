package pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
/****
 * @Author:wuwenzhaoxi
 * @Description:WebVisit构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WebVisit",value = "WebVisit")
@Table(name="web_visit")
public class WebVisit implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//主键

	@ApiModelProperty(value = "用户uid",required = false)
    @Column(name = "user_uid")
	private String userUid;//用户uid

	@ApiModelProperty(value = "访问ip地址",required = false)
    @Column(name = "ip")
	private String ip;//访问ip地址

	@ApiModelProperty(value = "用户行为",required = false)
    @Column(name = "behavior")
	private String behavior;//用户行为

	@ApiModelProperty(value = "模块uid（文章uid，标签uid，分类uid）",required = false)
    @Column(name = "module_uid")
	private String moduleUid;//模块uid（文章uid，标签uid，分类uid）

	@ApiModelProperty(value = "附加数据(比如搜索内容)",required = false)
    @Column(name = "other_data")
	private String otherData;//附加数据(比如搜索内容)

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private String status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "操作系统",required = false)
    @Column(name = "os")
	private String os;//操作系统

	@ApiModelProperty(value = "浏览器",required = false)
    @Column(name = "browser")
	private String browser;//浏览器

	@ApiModelProperty(value = "ip来源",required = false)
    @Column(name = "ip_source")
	private String ipSource;//ip来源



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getIp() {
		return ip;
	}

	//set方法
	public void setIp(String ip) {
		this.ip = ip;
	}
	//get方法
	public String getBehavior() {
		return behavior;
	}

	//set方法
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	//get方法
	public String getModuleUid() {
		return moduleUid;
	}

	//set方法
	public void setModuleUid(String moduleUid) {
		this.moduleUid = moduleUid;
	}
	//get方法
	public String getOtherData() {
		return otherData;
	}

	//set方法
	public void setOtherData(String otherData) {
		this.otherData = otherData;
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
	public String getOs() {
		return os;
	}

	//set方法
	public void setOs(String os) {
		this.os = os;
	}
	//get方法
	public String getBrowser() {
		return browser;
	}

	//set方法
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	//get方法
	public String getIpSource() {
		return ipSource;
	}

	//set方法
	public void setIpSource(String ipSource) {
		this.ipSource = ipSource;
	}


}
