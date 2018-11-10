package com.dulp.xyz.pojo.VO;

import com.dulp.xyz.pojo.UserCourseSection;
import lombok.Data;

@Data
public class UserCourseSectionVo extends UserCourseSection {
    /**
     * 课程名
     */
    private String courseName;

    /**
     * 章节名
     */
    private String sectionName;
}
