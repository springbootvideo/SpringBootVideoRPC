package com.rammus.controller;
/**
 * 网站前台
 * 登录注册视频
 * @author Eason
 *
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rammus.mapper.UserMapper;
import com.rammus.model.Course;
import com.rammus.model.ExCourse;
import com.rammus.model.ExVideo;
import com.rammus.model.Video;
import com.rammus.service.impl.VideoCourseServiceImpl;
import com.rammus.service.impl.VideoServiceImpl;
import com.rammus.util.VideoResult;

@Controller
public class VideoControler {
	
	@Autowired
	VideoCourseServiceImpl vs;
	@Autowired
	UserMapper userMapper;
	@Autowired
	VideoServiceImpl videoServiceImpl;
	
	
	/**
	 * 进入视频列表
	 * @param req
	 * @param subjectId
	 * @return
	 */
	@RequestMapping("user/courseList")
	public String index(HttpServletRequest req, String subjectId) {
		List<ExCourse> courseList = vs.selectIncludeVideoAndSubjectBySubjectId(Integer.valueOf(subjectId));
		VideoResult videoResult = new VideoResult();
		
		Map map =new HashMap<String, Object>();
		
		map.put("courseList", courseList);
		map.put("subjectId",subjectId);
		videoResult.setData(map);
		videoResult.setStatus(200);
		videoResult.setMsg("ok");
		req.setAttribute("videoResult",videoResult);
		return "courseList";
		}
	/**
	 * 视频展示
	 * @param req
	 * @param videoId
	 * @param courseId
	 * @return
	 */
	
	@RequestMapping("user/videoDetail")
	public String videoDetail(HttpServletRequest req,String videoId,String subjectId) {
		    ExVideo video = videoServiceImpl.selectById(Integer.valueOf(videoId));
			System.out.println(video);
			Integer playNum = video.getPlayNum()+1;
		    
			video.setPlayNum(playNum);
			videoServiceImpl.update(video);

			
			List<ExCourse> course = vs.selectIncludeVideoAndSubjectBySubjectId(Integer.valueOf(subjectId));
			System.out.println(course);
			
			Map map=new HashMap<String, Object>();
			
			map.put("video", video);
			map.put("course", course);
			
			VideoResult videoResult = new VideoResult();
			videoResult.setData(map);
			videoResult.setStatus(200);
			videoResult.setMsg("ok");
			req.setAttribute("videoResult", videoResult);
		    return "videoDetail";
		
	
	}
	
}
