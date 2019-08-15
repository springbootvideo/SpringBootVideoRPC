package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.ExCourseMapper;
import com.rammus.model.Course;
import com.rammus.service.VideoCourseService;




@Service
public class VideoCourseServiceImpl implements  VideoCourseService{
	@Autowired
	ExCourseMapper em;

	@Override
	public Course selectById(Integer id) {
		
		return em.selectById();
	}
	
	

	
}
