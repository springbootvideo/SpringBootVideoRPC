package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.rammus.mapper.CourseManageMapper;
import com.rammus.model.Course;
import com.rammus.service.CourseManageService;
@Service
public class CourseManageServiceImpl implements CourseManageService{

	@Autowired
	CourseManageMapper courseMM;
	@Override
	@CacheEvict(value = "course")
	public List<Course> selectAll() {
		// TODO Auto-generated method stub
		return courseMM.selectAll();
	}
	@Override
	@CacheEvict(value = "course")
	public int getTotal() {
		// TODO Auto-generated method stub
		return courseMM.getTotal();
	}
	@Override
	@CacheEvict(value = "course")
	public void courseSave(Course course) {
		// TODO Auto-generated method stub
		courseMM.insert(course);
	}
	@Override
	@CacheEvict(value = "course")
	public Course selectById(Integer id) {
		// TODO Auto-generated method stub
		return courseMM.selectByPrimaryKey(id);
	}
	@Override
	@CacheEvict(value = "course")
	public void courseUpdate(Course course) {
		// TODO Auto-generated method stub
		courseMM.updateByPrimaryKey(course);
	}
	@Override
	@CacheEvict(value = "course")
	public void courseDelete(Integer id) {
		// TODO Auto-generated method stub
		courseMM.deleteByPrimaryKey(id);
	}

}
