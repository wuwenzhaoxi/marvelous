package pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
/****
 * @Author:wuwenzhaoxi
 * @Description:SystemConfig构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SystemConfig",value = "SystemConfig")
@Table(name="system_config")
public class SystemConfig implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "uid")
	private String uid;//主键

	@ApiModelProperty(value = "七牛云公钥",required = false)
    @Column(name = "qi_niu_access_key")
	private String qiNiuAccessKey;//七牛云公钥

	@ApiModelProperty(value = "七牛云私钥",required = false)
    @Column(name = "qi_niu_secret_key")
	private String qiNiuSecretKey;//七牛云私钥

	@ApiModelProperty(value = "邮箱账号",required = false)
    @Column(name = "email")
	private String email;//邮箱账号

	@ApiModelProperty(value = "邮箱发件人用户名",required = false)
    @Column(name = "email_user_name")
	private String emailUserName;//邮箱发件人用户名

	@ApiModelProperty(value = "邮箱密码",required = false)
    @Column(name = "email_password")
	private String emailPassword;//邮箱密码

	@ApiModelProperty(value = "SMTP地址",required = false)
    @Column(name = "smtp_address")
	private String smtpAddress;//SMTP地址

	@ApiModelProperty(value = "SMTP端口",required = false)
    @Column(name = "smtp_port")
	private String smtpPort;//SMTP端口

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private String status;//状态

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "七牛云上传空间",required = false)
    @Column(name = "qi_niu_bucket")
	private String qiNiuBucket;//七牛云上传空间

	@ApiModelProperty(value = "七牛云存储区域 华东（z0），华北(z1)，华南(z2)，北美(na0)，东南亚(as0)",required = false)
    @Column(name = "qi_niu_area")
	private String qiNiuArea;//七牛云存储区域 华东（z0），华北(z1)，华南(z2)，北美(na0)，东南亚(as0)

	@ApiModelProperty(value = "图片是否上传七牛云 (0:否， 1：是)",required = false)
    @Column(name = "upload_qi_niu")
	private String uploadQiNiu;//图片是否上传七牛云 (0:否， 1：是)

	@ApiModelProperty(value = "图片是否上传本地存储 (0:否， 1：是)",required = false)
    @Column(name = "upload_local")
	private String uploadLocal;//图片是否上传本地存储 (0:否， 1：是)

	@ApiModelProperty(value = "图片显示优先级（ 1 展示 七牛云,  0 本地）",required = false)
    @Column(name = "picture_priority")
	private String picturePriority;//图片显示优先级（ 1 展示 七牛云,  0 本地）

	@ApiModelProperty(value = "七牛云域名前缀：http://images.moguit.cn",required = false)
    @Column(name = "qi_niu_picture_base_url")
	private String qiNiuPictureBaseUrl;//七牛云域名前缀：http://images.moguit.cn

	@ApiModelProperty(value = "本地服务器域名前缀：http://localhost:8600",required = false)
    @Column(name = "local_picture_base_url")
	private String localPictureBaseUrl;//本地服务器域名前缀：http://localhost:8600

	@ApiModelProperty(value = "是否开启邮件通知(0:否， 1:是)",required = false)
    @Column(name = "start_email_notification")
	private String startEmailNotification;//是否开启邮件通知(0:否， 1:是)



	//get方法
	public String getUid() {
		return uid;
	}

	//set方法
	public void setUid(String uid) {
		this.uid = uid;
	}
	//get方法
	public String getQiNiuAccessKey() {
		return qiNiuAccessKey;
	}

	//set方法
	public void setQiNiuAccessKey(String qiNiuAccessKey) {
		this.qiNiuAccessKey = qiNiuAccessKey;
	}
	//get方法
	public String getQiNiuSecretKey() {
		return qiNiuSecretKey;
	}

	//set方法
	public void setQiNiuSecretKey(String qiNiuSecretKey) {
		this.qiNiuSecretKey = qiNiuSecretKey;
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
	public String getEmailUserName() {
		return emailUserName;
	}

	//set方法
	public void setEmailUserName(String emailUserName) {
		this.emailUserName = emailUserName;
	}
	//get方法
	public String getEmailPassword() {
		return emailPassword;
	}

	//set方法
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	//get方法
	public String getSmtpAddress() {
		return smtpAddress;
	}

	//set方法
	public void setSmtpAddress(String smtpAddress) {
		this.smtpAddress = smtpAddress;
	}
	//get方法
	public String getSmtpPort() {
		return smtpPort;
	}

	//set方法
	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
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
	public String getQiNiuBucket() {
		return qiNiuBucket;
	}

	//set方法
	public void setQiNiuBucket(String qiNiuBucket) {
		this.qiNiuBucket = qiNiuBucket;
	}
	//get方法
	public String getQiNiuArea() {
		return qiNiuArea;
	}

	//set方法
	public void setQiNiuArea(String qiNiuArea) {
		this.qiNiuArea = qiNiuArea;
	}
	//get方法
	public String getUploadQiNiu() {
		return uploadQiNiu;
	}

	//set方法
	public void setUploadQiNiu(String uploadQiNiu) {
		this.uploadQiNiu = uploadQiNiu;
	}
	//get方法
	public String getUploadLocal() {
		return uploadLocal;
	}

	//set方法
	public void setUploadLocal(String uploadLocal) {
		this.uploadLocal = uploadLocal;
	}
	//get方法
	public String getPicturePriority() {
		return picturePriority;
	}

	//set方法
	public void setPicturePriority(String picturePriority) {
		this.picturePriority = picturePriority;
	}
	//get方法
	public String getQiNiuPictureBaseUrl() {
		return qiNiuPictureBaseUrl;
	}

	//set方法
	public void setQiNiuPictureBaseUrl(String qiNiuPictureBaseUrl) {
		this.qiNiuPictureBaseUrl = qiNiuPictureBaseUrl;
	}
	//get方法
	public String getLocalPictureBaseUrl() {
		return localPictureBaseUrl;
	}

	//set方法
	public void setLocalPictureBaseUrl(String localPictureBaseUrl) {
		this.localPictureBaseUrl = localPictureBaseUrl;
	}
	//get方法
	public String getStartEmailNotification() {
		return startEmailNotification;
	}

	//set方法
	public void setStartEmailNotification(String startEmailNotification) {
		this.startEmailNotification = startEmailNotification;
	}


}
