package com.dulp.xyz.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_course_comment")
public class TCourseComment {
    @Id
    private Integer id;

    /**
     * 用户username
     */
    private String username;

    /**
     * 评论对象username
     */
    @Column(name = "to_username")
    private String toUsername;

    /**
     * 课程id
     */
    @Column(name = "course_id")
    private Integer courseId;

    /**
     * 章节id
     */
    @Column(name = "section_id")
    private Integer sectionId;

    /**
     * 章节标题
     */
    @Column(name = "section_title")
    private String sectionTitle;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 引用id
     */
    @Column(name = "ref_id")
    private Integer refId;

    /**
     * 引用内容
     */
    @Column(name = "ref_content")
    private String refContent;

    /**
     * 类型：0-评论；1-答疑QA
     */
    private Byte type;

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
     * 获取用户username
     *
     * @return username - 用户username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户username
     *
     * @param username 用户username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取评论对象username
     *
     * @return to_username - 评论对象username
     */
    public String getToUsername() {
        return toUsername;
    }

    /**
     * 设置评论对象username
     *
     * @param toUsername 评论对象username
     */
    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    /**
     * 获取课程id
     *
     * @return course_id - 课程id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置课程id
     *
     * @param courseId 课程id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    /**
     * 用户头像
     */
    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 获取章节id
     *
     * @return section_id - 章节id
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 设置章节id
     *
     * @param sectionId 章节id
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * 获取章节标题
     *
     * @return section_title - 章节标题
     */
    public String getSectionTitle() {
        return sectionTitle;
    }

    /**
     * 设置章节标题
     *
     * @param sectionTitle 章节标题
     */
    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取引用id
     *
     * @return ref_id - 引用id
     */
    public Integer getRefId() {
        return refId;
    }

    /**
     * 设置引用id
     *
     * @param refId 引用id
     */
    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    /**
     * 获取引用内容
     *
     * @return ref_content - 引用内容
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
     * 获取类型：0-评论；1-答疑QA
     *
     * @return type - 类型：0-评论；1-答疑QA
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置类型：0-评论；1-答疑QA
     *
     * @param type 类型：0-评论；1-答疑QA
     */
    public void setType(Byte type) {
        this.type = type;
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