package com.rammus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户个人中心
 * 个人给管理
 * @author 陈凯
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/index")
	public String index() {

		return "index";
	}
}
