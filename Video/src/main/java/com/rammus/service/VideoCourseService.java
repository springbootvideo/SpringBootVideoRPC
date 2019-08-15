package com.rammus.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rammus.mapper.ExCourseMapper;
import com.rammus.model.Course;

public interface VideoCourseService {
	public Course selectById(Integer id);
	
}
