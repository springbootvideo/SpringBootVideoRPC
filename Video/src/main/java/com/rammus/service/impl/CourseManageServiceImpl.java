package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.CourseManageMapper;
import com.rammus.model.Course;
import com.rammus.service.CourseManageService;
@Service
public class CourseManageServiceImpl implements CourseManageService{

	@Autowired
	CourseManageMapper courseMM;
	@Override
	public List<Course> selectAll() {
		// TODO Auto-generated method stub
		return courseMM.selectAll();
	}
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return courseMM.getTotal();
	}
	@Override
	public void courseSave(Course course) {
		// TODO Auto-generated method stub
		courseMM.insert(course);
	}
	@Override
	public Course selectById(Integer id) {
		// TODO Auto-generated method stub
		return courseMM.selectByPrimaryKey(id);
	}
	@Override
	public void courseUpdate(Course course) {
		// TODO Auto-generated method stub
		courseMM.updateByPrimaryKey(course);
	}
	@Override
	public void courseDelete(Integer id) {
		// TODO Auto-generated method stub
		courseMM.deleteByPrimaryKey(id);
	}

}
