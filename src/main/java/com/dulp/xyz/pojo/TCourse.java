package com.dulp.xyz.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_course")
public class TCourse {
    @Id
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程类型
     */
    private String type;

    /**
     * 课程分类
     */
    private String classify;

    @Column(name = "classify_name")
    private String classifyName;

    /**
     * 课程二级分类
     */
    @Column(name = "sub_classify")
    private String subClassify;

    @Column(name = "sub_classify_name")
    private String subClassifyName;

    /**
     * 课程方向
     */
    private String direction;

    /**
     * 归属人
     */
    private String username;

    /**
     * 课程级别：1-初级，2-中级，3-高级
     */
    private Boolean level;

    /**
     * 是否免费：0-否，1-是
     */
    private Boolean free;

    /**
     * 课程价格
     */
    private BigDecimal price;

    /**
     * 时长
     */
    private String time;

    /**
     * 未上架（0）、上架（1）
     */
    private Boolean onsale;

    private String picture;

    /**
     * 未推荐（0）、推荐（1）
     */
    private Boolean recommend;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 学习人数
     */
    @Column(name = "study_count")
    private Integer studyCount;

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
     * 课程描述
     */
    private String brief;

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
     * 获取课程名称
     *
     * @return name - 课程名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名称
     *
     * @param name 课程名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取课程类型
     *
     * @return type - 课程类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置课程类型
     *
     * @param type 课程类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取课程分类
     *
     * @return classify - 课程分类
     */
    public String getClassify() {
        return classify;
    }

    /**
     * 设置课程分类
     *
     * @param classify 课程分类
     */
    public void setClassify(String classify) {
        this.classify = classify;
    }

    /**
     * @return classify_name
     */
    public String getClassifyName() {
        return classifyName;
    }

    /**
     * @param classifyName
     */
    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    /**
     * 获取课程二级分类
     *
     * @return sub_classify - 课程二级分类
     */
    public String getSubClassify() {
        return subClassify;
    }

    /**
     * 设置课程二级分类
     *
     * @param subClassify 课程二级分类
     */
    public void setSubClassify(String subClassify) {
        this.subClassify = subClassify;
    }

    /**
     * @return sub_classify_name
     */
    public String getSubClassifyName() {
        return subClassifyName;
    }

    /**
     * @param subClassifyName
     */
    public void setSubClassifyName(String subClassifyName) {
        this.subClassifyName = subClassifyName;
    }

    /**
     * 获取课程方向
     *
     * @return direction - 课程方向
     */
    public String getDirection() {
        return direction;
    }

    /**
     * 设置课程方向
     *
     * @param direction 课程方向
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * 获取归属人
     *
     * @return username - 归属人
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置归属人
     *
     * @param username 归属人
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取课程级别：1-初级，2-中级，3-高级
     *
     * @return level - 课程级别：1-初级，2-中级，3-高级
     */
    public Boolean getLevel() {
        return level;
    }

    /**
     * 设置课程级别：1-初级，2-中级，3-高级
     *
     * @param level 课程级别：1-初级，2-中级，3-高级
     */
    public void setLevel(Boolean level) {
        this.level = level;
    }

    /**
     * 获取是否免费：0-否，1-是
     *
     * @return free - 是否免费：0-否，1-是
     */
    public Boolean getFree() {
        return free;
    }

    /**
     * 设置是否免费：0-否，1-是
     *
     * @param free 是否免费：0-否，1-是
     */
    public void setFree(Boolean free) {
        this.free = free;
    }

    /**
     * 获取课程价格
     *
     * @return price - 课程价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置课程价格
     *
     * @param price 课程价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取未推荐（0）、推荐（1）
     *
     * @return recommend - 未推荐（0）、推荐（1）
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * 设置未推荐（0）、推荐（1）
     *
     * @param recommend 未推荐（0）、推荐（1）
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
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
     * 获取学习人数
     *
     * @return study_count - 学习人数
     */
    public Integer getStudyCount() {
        return studyCount;
    }

    /**
     * 设置学习人数
     *
     * @param studyCount 学习人数
     */
    public void setStudyCount(Integer studyCount) {
        this.studyCount = studyCount;
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

    /**
     * 获取课程描述
     *
     * @return brief - 课程描述
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置课程描述
     *
     * @param brief 课程描述
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }
}