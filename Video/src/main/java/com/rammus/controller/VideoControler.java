package com.rammus.controller;
/**
 * 网站前台
 * 登录注册视频
 * @author Eason
 *
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rammus.mapper.UserMapper;
import com.rammus.model.Course;
import com.rammus.service.impl.VideoCourseServiceImpl;
import com.rammus.service.impl.VideoServiceImpl;

@Controller
public class VideoControler {
	
	@Autowired
	VideoCourseServiceImpl vs;
	@Autowired
	UserMapper userMapper;
	@Autowired
	VideoServiceImpl videoServiceImpl;
	
	
	
	@RequestMapping("user/courseList")
	public String index(HttpServletRequest req, int subjectId) {
		System.out.println("0000000000000000000000000");
		req.setAttribute("courseList", vs.selectBySubjectId(subjectId));
			return "courseList";
		}
	@RequestMapping("user/videoDetail")
	public String videoDetail(HttpServletRequest req,int videoId,int courseId) {
		req.setAttribute("video", videoServiceImpl.selectById(videoId));
		req.setAttribute("course", vs.selectByIdContainVideoList(courseId));
		return "videoDetail";
		
	
	}
	
}
