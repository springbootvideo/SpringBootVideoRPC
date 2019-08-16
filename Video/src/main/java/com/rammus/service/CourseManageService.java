package com.rammus.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.rammus.model.Course;
import com.rammus.util.VideoResult;

public interface CourseManageService {

	List<Course> selectAll();
	//总数
	public int getTotal();
	//保存save
	void courseSave(Course course);
	//按id查询
	Course selectById(Integer id);
	//修改update
	void courseUpdate(Course course);
	//单删
	void courseDelete(Integer id);
}
