package com.dulp.xyz.pojo.VO;

import com.dulp.xyz.pojo.CourseComment;
import lombok.Data;

@Data
public class CourseCommentVO extends CourseComment {

    /**
     * 用户头像
     */
    private String header;

    /**
     * 课程名称
     */
    private String courseName;
}
