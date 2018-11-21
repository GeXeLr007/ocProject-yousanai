package com.dulp.xyz.pojo.VO;

import com.dulp.xyz.pojo.UserCollections;
import lombok.Data;

@Data
public class UserCollectionsVO extends UserCollections {
    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程简介
     */
    private String courseBrief;

    /**
     * 课程图片地址
     */
    private String coursePicture;
}
