package com.rammus.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.rammus.model.User;
import com.rammus.service.UserService;

/**
 * 用户个人中心 个人给管理
 * 
 * @author 陈凯
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 登录
	 * 
	 * @param reqUser
	 * @param req
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/login")
	public String login(User reqUser, HttpServletRequest req) throws UnsupportedEncodingException {

		User user = userService.selectByAccounts(reqUser.getAccounts());
		System.out.println("===============/login=============" + user.getNickname());
		if (user == null) {
			req.setAttribute("msg", "用户名错误");
		} else if (!(DigestUtils.md5DigestAsHex(reqUser.getPassword().getBytes()).equals(user.getPassword()))) {
			req.setAttribute("msg", "密码错误");
		} else {

			req.getSession().setAttribute("user", user);
			return "userCenter";
		}
		return "index";
	}

	@RequestMapping("/register")
	public String register(User user, Model model) {
		// 加密。然后保存
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}

	/**
	 * 主页跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {

		return "index";
	}

	/**
	 * 用户个人中心
	 */
	@RequestMapping("/userCenter")
	public String userCenter(HttpServletRequest req) {

		return "userCenter";
	}

	@RequestMapping("/userUpdate")
	public String userUpdate(HttpServletRequest req) {
		User sessionUser = (User) req.getSession().getAttribute("user");
		req.setAttribute("user", sessionUser);
		return "userUpdate";
	}

	@RequestMapping("/userAlter")
	public String userAlter(HttpServletRequest req, User user) {
		User sessionUser = (User) req.getSession().getAttribute("user");
		sessionUser.setNickname(user.getNickname());
		sessionUser.setSex(user.getSex());
		sessionUser.setBirthday(user.getBirthday());
		sessionUser.setAddress(user.getAddress());
		userService.update(sessionUser);
		return "redirect:userCenter";
	}

	@RequestMapping("/userUpdateImg")
	public String userUpdateImg(HttpServletRequest req) {

		return "userUpdateImg";
	}

	@RequestMapping("/userAlterImg")
	public String userAlterImg(MultipartFile imageFile, HttpServletRequest req) {
//		System.out.println(imageFile);
		System.out.println(imageFile.getContentType());
		if (imageFile.getContentType().equals("image/jpeg") || imageFile.getContentType().equals("image/png")) {
			System.out.println("格式符合");

			String imageName = System.currentTimeMillis() + imageFile.getOriginalFilename();
			String realPath = req.getSession().getServletContext().getRealPath("pictures/");
			String name = realPath + imageName;
			String imgUrl = "/SSM_Learn/pictures/" + imageName;
			User user = (User) req.getSession().getAttribute("user");
//		System.out.println(name);
//		System.out.println(imgUrl);
			user.setImgurl(imgUrl);
			userService.update(user);
			req.getSession().setAttribute("user", user);

			try {
				imageFile.transferTo(new File(name));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "redirect:userCenter.do";
		}
		req.setAttribute("msg", "头像格式不符");
		return "redirect:userCenter.do";

	}

	@RequestMapping("/userUpdatePassword")
	public String userUpdatePassword(HttpServletRequest req) {

		return "userUpdatePassword";
	}

	/**
	 * 
	 * @param originalPassword
	 * @param req
	 * @param resp
	 * 
	 *                         验证原密码是否正确
	 */
	@RequestMapping("/originalPasswordCheck.do")
	public void originalPasswordCheck(String originalPassword, HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");

		boolean isExist;
		if (!originalPassword.equals(user.getPassword())) {
			// 旧密码错误
			isExist = false;
		} else {
			isExist = true;
		}
		try {
			resp.getWriter().append("{\"isSuccess\":" + isExist + "}");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/rePasswordCheck.do")
	public void rePasswordCheck(String newPassword, String rePassword, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean isExist;
		if (rePassword.equals(newPassword)) {
			isExist = true;
		} else {
			isExist = false;
		}

		try {
			resp.getWriter().append("{\"isSuccess\":" + isExist + "}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param newPassword
	 * @param req
	 * @return 31)修改密码
	 */
	@RequestMapping("/passwordUpdate.do")
	public String passwordUpdate(String newPassword, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");

		user.setPassword(newPassword);
		userService.update(user);
		req.getSession().setAttribute("user", user);
		return "redirect:userCenter.do";

	}
}
