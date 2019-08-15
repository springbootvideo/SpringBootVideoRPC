package com.rammus.controller;
/**
 * 网站前台
 * 登录注册视频
 * @author Eason
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rammus.mapper.UserMapper;
import com.rammus.model.Course;
import com.rammus.service.impl.VideoCourseServiceImpl;

@Controller
public class VideoControler {
	
	@Autowired
	VideoCourseServiceImpl vs;
	@Autowired
	UserMapper userMapper;
	@RequestMapping("select")
	@ResponseBody
	public Course select(Integer id) {
		System.out.println(vs.selectById(id));
		return vs.selectById(id);
		
	}
	@RequestMapping("user/courseList.do")
	public String index() {
		//req.setAttribute("courseList", courseService.selectBySubjectId(subjectId));
			return "courseList";
		}
	
	
	
}
