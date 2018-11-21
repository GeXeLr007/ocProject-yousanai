package com.dulp.xyz.pojo.VO;

import com.dulp.xyz.pojo.UserCourseSection;
import lombok.Data;

@Data
public class UserCourseSectionVO extends UserCourseSection {
    /**
     * 课程名
     */
    private String courseName;

    /**
     * 章节名
     */
    private String sectionName;

    /**
     * 课程图片地址
     */
    private String coursePicture;

    /**
     * 已学习百分比
     */
    private Integer studyPercent;
}
