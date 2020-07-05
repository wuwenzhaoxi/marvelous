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
 * @Description:User构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "User",value = "User")
@Table(name="user")
public class User implements Serializable{

	@ApiModelProperty(value = "唯一uid",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//唯一uid

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "user_name")
	private String userName;//用户名

	@ApiModelProperty(value = "密码",required = false)
    @Column(name = "pass_word")
	private String passWord;//密码

	@ApiModelProperty(value = "性别(1:男2:女)",required = false)
    @Column(name = "gender")
	private Integer gender;//性别(1:男2:女)

	@ApiModelProperty(value = "个人头像",required = false)
    @Column(name = "avatar")
	private String avatar;//个人头像

	@ApiModelProperty(value = "邮箱",required = false)
    @Column(name = "email")
	private String email;//邮箱

	@ApiModelProperty(value = "出生年月日",required = false)
    @Column(name = "birthday")
	private Date birthday;//出生年月日

	@ApiModelProperty(value = "手机",required = false)
    @Column(name = "mobile")
	private String mobile;//手机

	@ApiModelProperty(value = "邮箱验证码",required = false)
    @Column(name = "valid_code")
	private String validCode;//邮箱验证码

	@ApiModelProperty(value = "自我简介最多150字",required = false)
    @Column(name = "summary")
	private String summary;//自我简介最多150字

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

	@ApiModelProperty(value = "昵称",required = false)
    @Column(name = "nick_name")
	private String nickName;//昵称

	@ApiModelProperty(value = "资料来源",required = false)
    @Column(name = "source")
	private String source;//资料来源

	@ApiModelProperty(value = "平台uuid",required = false)
    @Column(name = "uuid")
	private String uuid;//平台uuid

	@ApiModelProperty(value = "QQ号",required = false)
    @Column(name = "qq_number")
	private String qqNumber;//QQ号

	@ApiModelProperty(value = "微信号",required = false)
    @Column(name = "we_chat")
	private String weChat;//微信号

	@ApiModelProperty(value = "职业",required = false)
    @Column(name = "occupation")
	private String occupation;//职业

	@ApiModelProperty(value = "评论状态 1:正常 0:禁言",required = false)
    @Column(name = "comment_status")
	private String commentStatus;//评论状态 1:正常 0:禁言

	@ApiModelProperty(value = "ip来源",required = false)
    @Column(name = "ip_source")
	private String ipSource;//ip来源

	@ApiModelProperty(value = "浏览器",required = false)
    @Column(name = "browser")
	private String browser;//浏览器

	@ApiModelProperty(value = "操作系统",required = false)
    @Column(name = "os")
	private String os;//操作系统

	@ApiModelProperty(value = "是否开启邮件通知 1:开启 0:关闭",required = false)
    @Column(name = "start_email_notification")
	private String startEmailNotification;//是否开启邮件通知 1:开启 0:关闭

	@ApiModelProperty(value = "用户标签：0：普通用户，1：管理员，2：博主 等",required = false)
    @Column(name = "user_tag")
	private String userTag;//用户标签：0：普通用户，1：管理员，2：博主 等



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
	public String getPassWord() {
		return passWord;
	}

	//set方法
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	//get方法
	public Integer getGender() {
		return gender;
	}

	//set方法
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	//get方法
	public String getAvatar() {
		return avatar;
	}

	//set方法
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	public Date getBirthday() {
		return birthday;
	}

	//set方法
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	//get方法
	public String getMobile() {
		return mobile;
	}

	//set方法
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	//get方法
	public String getValidCode() {
		return validCode;
	}

	//set方法
	public void setValidCode(String validCode) {
		this.validCode = validCode;
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
	//get方法
	public String getNickName() {
		return nickName;
	}

	//set方法
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	//get方法
	public String getSource() {
		return source;
	}

	//set方法
	public void setSource(String source) {
		this.source = source;
	}
	//get方法
	public String getUuid() {
		return uuid;
	}

	//set方法
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	//get方法
	public String getQqNumber() {
		return qqNumber;
	}

	//set方法
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	//get方法
	public String getWeChat() {
		return weChat;
	}

	//set方法
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	//get方法
	public String getOccupation() {
		return occupation;
	}

	//set方法
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	//get方法
	public String getCommentStatus() {
		return commentStatus;
	}

	//set方法
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
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
	public String getBrowser() {
		return browser;
	}

	//set方法
	public void setBrowser(String browser) {
		this.browser = browser;
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
	public String getStartEmailNotification() {
		return startEmailNotification;
	}

	//set方法
	public void setStartEmailNotification(String startEmailNotification) {
		this.startEmailNotification = startEmailNotification;
	}
	//get方法
	public String getUserTag() {
		return userTag;
	}

	//set方法
	public void setUserTag(String userTag) {
		this.userTag = userTag;
	}


}
