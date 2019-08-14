package com.rammus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rammus.model.Admin;
import com.rammus.service.AdminService;

/**
 * 后台写的
 * 增删改查
 * @author 吕怀浩
 *
 */
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	@RequestMapping("admin/login.do")
	public String backPage(Admin admin, HttpServletRequest request, HttpSession session) {
		
		return "index";
	}
}
