package com.dulp.xyz.common.enums;

/**
 * 课程使用的枚举
 */
public enum CourseEnum {

    FREE(1), //免费
    FREE_NOT(0), //收费

    ONSALE(1), //上架
    ONSALE_NOT(0), //下架

    COLLECTION_YES(1),//课程已收藏
    COLLECTION_NO(0),//课程未收藏

    SECTION_ING(0),//课程已收藏
    SECTION_END(1);//课程未收藏

    private Integer value;

    CourseEnum(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
