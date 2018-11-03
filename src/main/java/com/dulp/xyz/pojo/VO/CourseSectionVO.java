package com.dulp.xyz.pojo.VO;

import com.dulp.xyz.pojo.TCourseSection;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程章节
 */
public class CourseSectionVO extends TCourseSection {
	private static final long serialVersionUID = 180753077428934254L;

	//小节
	private List<TCourseSection> sections = new ArrayList<TCourseSection>();

	
	public List<TCourseSection> getSections() {
		return sections;
	}

	public void setSections(List<TCourseSection> sections) {
		this.sections = sections;
	}
	
}
