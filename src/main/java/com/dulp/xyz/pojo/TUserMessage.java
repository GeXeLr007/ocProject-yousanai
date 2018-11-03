package com.dulp.xyz.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_user_message")
public class TUserMessage {
    @Id
    private Integer id;

    /**
     * 消息接收用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 消息发起用户id
     */
    @Column(name = "send_user_id")
    private Integer sendUserId;

    /**
     * 消息发起用户名称
     */
    @Column(name = "send_user_name")
    private String sendUserName;

    /**
     * 引用id
     */
    @Column(name = "ref_id")
    private String refId;

    /**
     * 引用内容
     */
    @Column(name = "ref_Content")
    private String refContent;

    /**
     * 通知的类型，1-评论，2-关注，3-答疑
     */
    private Boolean type;

    /**
     * 未读（0）、已读（1）
     */
    private Boolean status;

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
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取消息接收用户id
     *
     * @return user_id - 消息接收用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置消息接收用户id
     *
     * @param userId 消息接收用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取消息发起用户id
     *
     * @return send_user_id - 消息发起用户id
     */
    public Integer getSendUserId() {
        return sendUserId;
    }

    /**
     * 设置消息发起用户id
     *
     * @param sendUserId 消息发起用户id
     */
    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    /**
     * 获取消息发起用户名称
     *
     * @return send_user_name - 消息发起用户名称
     */
    public String getSendUserName() {
        return sendUserName;
    }

    /**
     * 设置消息发起用户名称
     *
     * @param sendUserName 消息发起用户名称
     */
    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    /**
     * 获取引用id
     *
     * @return ref_id - 引用id
     */
    public String getRefId() {
        return refId;
    }

    /**
     * 设置引用id
     *
     * @param refId 引用id
     */
    public void setRefId(String refId) {
        this.refId = refId;
    }

    /**
     * 获取引用内容
     *
     * @return ref_Content - 引用内容
     */
    public String getRefContent() {
        return refContent;
    }

    /**
     * 设置引用内容
     *
     * @param refContent 引用内容
     */
    public void setRefContent(String refContent) {
        this.refContent = refContent;
    }

    /**
     * 获取通知的类型，1-评论，2-关注，3-答疑
     *
     * @return type - 通知的类型，1-评论，2-关注，3-答疑
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置通知的类型，1-评论，2-关注，3-答疑
     *
     * @param type 通知的类型，1-评论，2-关注，3-答疑
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取未读（0）、已读（1）
     *
     * @return status - 未读（0）、已读（1）
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置未读（0）、已读（1）
     *
     * @param status 未读（0）、已读（1）
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
}