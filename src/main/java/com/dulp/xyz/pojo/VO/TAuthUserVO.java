package com.dulp.xyz.pojo.VO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@ApiModel(value="用户对象", description="这是用户对象")
public class TAuthUserVO {
    public TAuthUserVO (){
               super();
    }
    @ApiModelProperty(hidden=true)
    private String id;
     private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    /**
     * 登录用户名
     */
    @ApiModelProperty(value="用户名", name="realname", example="projectuser", required=true)
    private String realname;

    /**
     * 真实姓名
     */

    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码", name="password", example="123456", required=true)
    private String password;

    /**
     * 性别
     */
    @ApiModelProperty(hidden=true)
    private Boolean gender;

    /**
     * 头像
     */
    @ApiModelProperty(hidden=true)
    private String header;

    /**
     * 手机号码
     */
    @ApiModelProperty(hidden=true)
    private String mobile;

    /**
     * 状态：待审核（0），有效（1），无效（3）
     */
    @ApiModelProperty(hidden=true)
    private Boolean status;
    @ApiModelProperty(hidden=true)
    private Date birthday;

    /**
     * 学历：大专、本科、硕士、博士、博士后
     */
    @ApiModelProperty(hidden=true)
    private String education;

    /**
     * 大学编码
     */
    @ApiModelProperty(hidden=true)
    @Column(name = "college_code")
    private String collegeCode;

    /**
     * 大学名称
     */
    @ApiModelProperty(hidden=true)
    @Column(name = "college_name")
    private String collegeName;

    /**
     * 资格证书编号
     */
    @Column(name = "cert_no")
    private String certNo;

    /**
     * 头衔
     */
    private String title;

    /**
     * 签名
     */
    private String sign;

    /**
     * 微信公众号openid
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 微信号
     */
    @Column(name = "wechat_id")
    private String wechatId;

    /**
     * qq号
     */
    private String qq;

    /**
     * 最后一次登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 最后一次登录IP
     */
    private String ip;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在地区
     */
    private String district;

    /**
     * 权重
     */
    private Integer weight;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private String updateUser;

    private Boolean del;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取登录用户名
     *
     * @return realname - 登录用户名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置登录用户名
     *
     * @param realname 登录用户名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取真实姓名
     *
     * @return username - 真实姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置真实姓名
     *
     * @param username 真实姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取头像
     *
     * @return header - 头像
     */
    public String getHeader() {
        return header;
    }

    /**
     * 设置头像
     *
     * @param header 头像
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取状态：待审核（0），有效（1），无效（3）
     *
     * @return status - 状态：待审核（0），有效（1），无效（3）
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态：待审核（0），有效（1），无效（3）
     *
     * @param status 状态：待审核（0），有效（1），无效（3）
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取学历：大专、本科、硕士、博士、博士后
     *
     * @return education - 学历：大专、本科、硕士、博士、博士后
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历：大专、本科、硕士、博士、博士后
     *
     * @param education 学历：大专、本科、硕士、博士、博士后
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取大学编码
     *
     * @return college_code - 大学编码
     */
    public String getCollegeCode() {
        return collegeCode;
    }

    /**
     * 设置大学编码
     *
     * @param collegeCode 大学编码
     */
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    /**
     * 获取大学名称
     *
     * @return college_name - 大学名称
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置大学名称
     *
     * @param collegeName 大学名称
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * 获取资格证书编号
     *
     * @return cert_no - 资格证书编号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 设置资格证书编号
     *
     * @param certNo 资格证书编号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * 获取头衔
     *
     * @return title - 头衔
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置头衔
     *
     * @param title 头衔
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取签名
     *
     * @return sign - 签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置签名
     *
     * @param sign 签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取微信公众号openid
     *
     * @return open_id - 微信公众号openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信公众号openid
     *
     * @param openId 微信公众号openid
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取微信号
     *
     * @return wechat_id - 微信号
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * 设置微信号
     *
     * @param wechatId 微信号
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    /**
     * 获取qq号
     *
     * @return qq - qq号
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq号
     *
     * @param qq qq号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取最后一次登录时间
     *
     * @return login_time - 最后一次登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置最后一次登录时间
     *
     * @param loginTime 最后一次登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取最后一次登录IP
     *
     * @return ip - 最后一次登录IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置最后一次登录IP
     *
     * @param ip 最后一次登录IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取所在省份
     *
     * @return province - 所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省份
     *
     * @param province 所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所在地区
     *
     * @return district - 所在地区
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置所在地区
     *
     * @param district 所在地区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取权重
     *
     * @return weight - 权重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重
     *
     * @param weight 权重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return del
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * @param del
     */
    public void setDel(Boolean del) {
        this.del = del;
    }


    public TAuthUserVO(String id, String realname, String username, String password, Boolean gender, String header, String mobile, Boolean status, Date birthday, String education, String collegeCode, String collegeName, String certNo, String title, String sign, String openId, String wechatId, String qq, Date loginTime, String ip, String province, String city, String district, Integer weight, Date createTime, String createUser, Date updateTime, String updateUser, Boolean del) {
        this.id = id;
        this.realname = realname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.header = header;
        this.mobile = mobile;
        this.status = status;
        this.birthday = birthday;
        this.education = education;
        this.collegeCode = collegeCode;
        this.collegeName = collegeName;
        this.certNo = certNo;
        this.title = title;
        this.sign = sign;
        this.openId = openId;
        this.wechatId = wechatId;
        this.qq = qq;
        this.loginTime = loginTime;
        this.ip = ip;
        this.province = province;
        this.city = city;
        this.district = district;
        this.weight = weight;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.del = del;
    }
}