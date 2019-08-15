package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.ExCourseMapper;
import com.rammus.model.Course;
import com.rammus.service.VideoCourseService;



/**
 * 
 * @author Eason
 *
 */
@Service
public class VideoCourseServiceImpl implements  VideoCourseService{
	@Autowired
	ExCourseMapper em;

	public List<Course> getAll() {

		return em.getAll();
	}

	public List<Course> getListByPage(int page, int size) {

		return em.getListByPage(size * (page - 1), size);
	}

	public int getTotal() {

		return em.getTotal();
	}

	public void add(Course course) {
		em.insert(course);

	}

	public Course selectById(int id) {

		return em.selectById(id);
	}

	public Integer update(Course course) {

		return em.updateById(course);
	}

	public void deleteById(int id) {
		em.deleteById(id);

	}

	public List<Course> selectBySubjectId(int subjectId) {

		return em.selectBySubjectId(subjectId);
	}

	public Course selectByIdContainVideoList(int id) {
		
		return em.selectByIdContainVideoList(id);
	}
	
	

	
}
