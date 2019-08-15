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

}
