package com.rammus.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.rammus.model.Course;

public interface CourseManageService {

	List<Course> selectAll();
	//总数
	@Select("select count(*) from video")
	public int getTotal();
}
