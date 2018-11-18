package com.dulp.xyz.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_course_section")
public class CourseSection {
    @Id
    private Integer id;

    /**
     * 归属课程id
     */
    @Column(name = "course_id")
    private Integer courseId;

    /**
     * 父章节id，（只有2级）
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 章节名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 时长
     */
    private String time;

    /**
     * 未上架（0）、上架（1）
     */
    private Boolean onsale;

    @Column(name = "video_url")
    private String videoUrl;

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
     * 获取归属课程id
     *
     * @return course_id - 归属课程id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置归属课程id
     *
     * @param courseId 归属课程id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取父章节id，（只有2级）
     *
     * @return parent_id - 父章节id，（只有2级）
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父章节id，（只有2级）
     *
     * @param parentId 父章节id，（只有2级）
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取章节名称
     *
     * @return name - 章节名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置章节名称
     *
     * @param name 章节名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取时长
     *
     * @return time - 时长
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置时长
     *
     * @param time 时长
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取未上架（0）、上架（1）
     *
     * @return onsale - 未上架（0）、上架（1）
     */
    public Boolean getOnsale() {
        return onsale;
    }

    /**
     * 设置未上架（0）、上架（1）
     *
     * @param onsale 未上架（0）、上架（1）
     */
    public void setOnsale(Boolean onsale) {
        this.onsale = onsale;
    }

    /**
     * @return video_url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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