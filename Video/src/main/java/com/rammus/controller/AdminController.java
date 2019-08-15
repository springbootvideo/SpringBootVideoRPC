package com.rammus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rammus.model.Admin;
import com.rammus.model.Speaker;
import com.rammus.service.AdminService;
import com.rammus.service.SpeakService;
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
	
	
	
	
	/**
	 *     管理员登录
	 * @param accounts
	 * @param password
	 * @param req
	 * @param session
	 * @return
	 */
	@RequestMapping("admin/login.do")
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
	@RequestMapping("admin/videoManage.do")
	public String videoMapper(Model model) {
		List<Speaker> list = speakService.getList(0);
		System.out.println(list);
		model.addAttribute("speakerList", list);
		return  "admin/videoManage";
	}
	
	
	
	
}
