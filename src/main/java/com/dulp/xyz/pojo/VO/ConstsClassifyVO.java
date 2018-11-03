package com.dulp.xyz.pojo.VO;

import com.dulp.xyz.pojo.TConstsClassify;
import com.dulp.xyz.pojo.TCourse;

import java.util.ArrayList;
import java.util.List;

public class ConstsClassifyVO extends TConstsClassify {

    private static final long serialVersionUID = -6898939223836635781L;

    //子分类列表
    private List<TConstsClassify> subClassifyList = new ArrayList<TConstsClassify>();

    //课程推荐列表
    private List<TCourse> recomdCourseList ;

    public List<TConstsClassify> getSubClassifyList() {
        return subClassifyList;
    }

    public void setSubClassifyList(List<TConstsClassify> subClassifyList) {
        this.subClassifyList = subClassifyList;
    }

    public List<TCourse> getRecomdCourseList() {
        return recomdCourseList;
    }

    public void setRecomdCourseList(List<TCourse> recomdCourseList) {
        this.recomdCourseList = recomdCourseList;
    }

}
