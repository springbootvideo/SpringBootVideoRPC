package com.rammus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rammus.mapper.ExCourseMapper;
import com.rammus.model.Course;
import com.rammus.model.ExCourse;
/**
 * 
 * @author Eason
 *
 */
public interface VideoCourseService {
	public List<Course> getAll();

	public List<Course> getListByPage(int page, int size);

	

	public int getTotal();

	public void add(Course course);

	public Course selectById(int id);

	public List<ExCourse> selectBySubjectId(int subjectId);
	
	public Course selectByIdContainVideoList(int id);

	public Integer update(Course course);

	public void deleteById(int id);
	List<ExCourse> selectIncludeVideoAndSubjectBySubjectId(int subjectId);
}

