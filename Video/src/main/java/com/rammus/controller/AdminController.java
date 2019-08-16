package com.rammus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.rammus.model.Admin;
import com.rammus.model.Course;
import com.rammus.model.Speaker;
import com.rammus.model.Subject;
import com.rammus.model.Video;
import com.rammus.service.AdminService;
import com.rammus.service.CourseManageService;
import com.rammus.service.SpeakService;
import com.rammus.service.SubjectManageService;
import com.rammus.service.VideoManageService;
import com.rammus.util.VideoResult;

/**
 * 后台写的
 * 增删改查
 * @author 吕怀浩
 *
 */
@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	SpeakService speakService;
	@Autowired
	VideoManageService videoMS;
	@Autowired
	CourseManageService CourseMS;
	@Autowired
	SubjectManageService subjectMS;
	/**
	 *     管理员登录
	 * @param accounts
	 * @param password
	 * @param req
	 * @param session
	 * @return
	 */
	@RequestMapping("admin/login")
	public String backPage(String accounts, String password,HttpServletRequest req,HttpSession session) {
		List<Admin> list = adminService.adminLogin(accounts, password);
		if(list!=null&&list.size()>0){
			Admin admin=list.get(0);
			if (password.equals(admin.getPassword())) {
				System.out.println(admin.getPassword()+"********");
				session.setAttribute("accounts", admin.getAccounts());
				return "admin/index";
			}else {
				return "index";
			}		  	
		}else {
			return "redirect:index.do";
		}
	}
	/**
	 * 管理员退出
	 */
	@RequestMapping("admin/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "index";
	}	
	/**
	 * video的CRUD
	 * @param model
	 * @param page
	 * @return
	    *   分页
	 */
	@RequestMapping("admin/videoManage.do")
	public String videoMapper(Model model,@RequestParam(required = false, defaultValue = "1") int page) {
		List<Speaker> list = speakService.selectAll();
		System.out.println(page);
		List<Course> selectAll = CourseMS.selectAll();
		int total = videoMS.getTotal();
		PageHelper.startPage(page , 5);
		List<Video> page2 = videoMS.getListByPage();
		model.addAttribute("selectCouunt", total);
		model.addAttribute("speakerList", list);
		model.addAttribute("courseList", selectAll);
		model.addAttribute("videoList", page2);
		model.addAttribute("page", page);
		return  "admin/videoManage";
	}
	//跳转到add页面
	@RequestMapping("admin/videoAdd.do")
	public String videoAdd(Model model) {
		List<Speaker> list = speakService.selectAll();
		List<Course> selectAll = CourseMS.selectAll();
		model.addAttribute("speakerList", list);
		model.addAttribute("courseList", selectAll);
		return "admin/videoAdd";
	}
	//添加video
	@RequestMapping("admin/videoSave.do")
	public String videoSave(Video video) {
		videoMS.videoSave(video);
		return "redirect:videoManage.do";
	}
	//跳转修改页面
	@RequestMapping("admin/videoUpdate.do")
	public String videoUpdate(Integer id,Model model) {
		
		Video video = videoMS.selectByPrimaryKey(id);
		List<Speaker> list = speakService.selectAll();
		List<Course> selectAll = CourseMS.selectAll();
		model.addAttribute("speakerList", list);
		model.addAttribute("courseList", selectAll);
		model.addAttribute("video", video);
		return "admin/videoUpdate";
	}
	//修改video
	@RequestMapping("admin/videoAlter.do")
	public String videoAlter(Video video) {
		videoMS.videoUpdate(video);
		return "redirect:videoManage.do";
	}
	//video单删
	@RequestMapping("admin/videoDelete.do")
	public void videoDelete(HttpServletRequest request, int id, HttpServletResponse resp) {
		System.out.println(id);
		videoMS.deleteById(id);
		try {
			resp.getWriter().write("success");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//多删
	@RequestMapping(value="admin/videoDeleteAll.do",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public void videoDeleteAll(HttpServletRequest request,@RequestParam("ids[]")Integer[] ids,HttpServletResponse resp) {
		System.out.println(ids);
		List<Integer> list = Arrays.asList(ids);
		for (Integer integer : list) {
			System.out.println(integer);
			videoMS.deleteById(integer);
		}
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//模糊查询
	@RequestMapping("admin/videoSelectLike.do")
	public String selectLike(HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int page, String speakerId, String courseId,
			String factor,Model model) {
		System.out.println(factor);
		PageHelper.startPage(page, 5);
		List<Video> selectLike = videoMS.selectLike(speakerId, courseId, "title", factor);
		model.addAttribute("videoList", selectLike);
		List<Speaker> list = speakService.selectAll();
		model.addAttribute("page", page);
		List<Course> selectAll = CourseMS.selectAll();
		System.out.println(selectLike);
		model.addAttribute("speakerList", list);
		model.addAttribute("courseList", selectAll);
		model.addAttribute("selectCouunt", selectLike.size());
		return "admin/videoManage";
	}
	/**
	 * Course的CRUD
	 * @param model
	 * @param page
	 * @return
	 *   
	 */
	@RequestMapping("admin/courseManage.do")
	public String courseManage(Model model,@RequestParam(required = false, defaultValue = "1") int page) {
		PageHelper.startPage(page , 5);
		List<Course> list = CourseMS.selectAll();
		int total = CourseMS.getTotal();
		model.addAttribute("courseList", list);
		model.addAttribute("selectCouunt", total);
		return "admin/courseManage";
	}
	//跳转Course
	@RequestMapping("admin/courseAdd.do")
	public String courseAdd(Model model) {
		List<Subject> list = subjectMS.selectAll();		
		model.addAttribute("subjectList", list);
		return "admin/courseAdd";
	}
	//增加Course
	@RequestMapping("admin/courseSave.do")
	public String courseSave(Course course) {
		System.out.println(course);
		CourseMS.courseSave(course);
		return "redirect:courseManage.do";
	}
	//修改跳转Course
	@RequestMapping("admin/courseUpdate.do")
	public String courseUpdate(Integer id,Model model) {
		List<Subject> list = subjectMS.selectAll();		
		model.addAttribute("subjectList", list);
		Course course = CourseMS.selectById(id);
		model.addAttribute("course", course);
		return "admin/courseUpdate";
	}
	//修改实现Course
	@RequestMapping("admin/courseAlter.do")
	public String courseAlter(Course course) {
		CourseMS.courseUpdate(course);
		System.out.println(course);
		return "redirect:courseManage.do";
	}
	//单删Course
	@RequestMapping("admin/courseDelete.do")
	public void courseDelete(HttpServletRequest request, int id, HttpServletResponse resp) {
		System.out.println(id);
		CourseMS.courseDelete(id);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//多删
	@RequestMapping(value="admin/courseDeleteAll.do",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public void courseDeleteAll(HttpServletRequest request,@RequestParam("ids[]")Integer[] ids,HttpServletResponse resp) {
		System.out.println(ids);
		List<Integer> list = Arrays.asList(ids);
		for (Integer integer : list) {
			System.out.println(integer);
			CourseMS.courseDelete(integer);
		}
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * keynote speaker的CRUD
	 * @param model
	 * @param page
	 * @return
	 *   
	 */
	@RequestMapping("admin/speakerManage.do")
	public String speakerManage(Model model,@RequestParam(required = false, defaultValue = "1") int page) {
		PageHelper.startPage(page, 5);
		List<Speaker> list = speakService.selectAll();
		int total = speakService.getTotal();
		model.addAttribute("speakerList", list);
		model.addAttribute("selectCouunt", total);
		model.addAttribute("page", page);
		return "admin/speakerManage";
	}
	//跳转增加页面speaker
	@RequestMapping("admin/speakerAdd.do")
	public String speakerAdd() {
		return "admin/speakerAdd";
	}
	//增加speaker
	@RequestMapping("admin/speakerSave.do")
	public String speakerSave(Speaker speaker) {
		speakService.speakerSave(speaker);
		return "redirect:speakerManage.do";
	}
	//跳转修改页面
	@RequestMapping("admin/speakerUpdate.do")
	public String speakerUpdate(Integer id,Model model) {
		Speaker speaker = speakService.selectById(id);
		model.addAttribute("speaker", speaker);
		return "admin/speakerUpdate";
	}
	//修改speaker
	@RequestMapping("admin/speakerAlter.do")
	public String speakerAlter(Speaker speaker) {
		speakService.speakerUpdate(speaker);
		return "redirect:speakerManage.do";
	}
	//单删speaker
	@RequestMapping("admin/speakerDelete.do")
	public void speakerDelete(HttpServletRequest request, int id, HttpServletResponse resp) {
		speakService.speakerDelete(id);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//多删
	@RequestMapping(value="admin/speakerDeleteAll.do",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public void speakerDeleteAll(HttpServletRequest request,@RequestParam("ids[]")Integer[] ids,HttpServletResponse resp) {
		System.out.println(ids);
		List<Integer> list = Arrays.asList(ids);
		for (Integer integer : list) {
			System.out.println(integer);
			speakService.speakerDelete(integer);
		}
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 
