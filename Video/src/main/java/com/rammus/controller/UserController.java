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

	/**
	 * 注册
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/register")
	public String register(User user, Model model) {
		// 加密。然后保存
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.insert(user);
		return "redirect:index";
	}

	/**
	 * 验证用户是否存在
	 */

	/**
	 * 登出
	 * 
	 * @param session
	 * @return
	 */
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

	/**
	 * 更新 回显
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/userUpdate")
	public String userUpdate(HttpServletRequest req) {
		User sessionUser = (User) req.getSession().getAttribute("user");
		req.setAttribute("user", sessionUser);
		return "userUpdate";
	}

	/**
	 * 修改
	 * 
	 * @param req
	 * @param user
	 * @return
	 */
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

	/**
	 * 更新图片 跳转
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/userUpdateImg")
	public String userUpdateImg(HttpServletRequest req) {

		return "userUpdateImg";
	}

	/**
	 * 更新
	 * 
	 * @param imageFile
	 * @param req
	 * @return
	 */
	@RequestMapping("/userAlterImg")
	public String userAlterImg(MultipartFile imageFile, HttpServletRequest req) {
//		System.out.println(imageFile);
		System.out.println(imageFile.getContentType());
		if (imageFile.getContentType().equals("image/jpeg") || imageFile.getContentType().equals("image/png")) {
			System.out.println("格式符合");
			// 图片名：时间+源文件名
			String imageName = System.currentTimeMillis() + imageFile.getOriginalFilename();
			// 获取服务器的图片存放路径
			String realPath = req.getSession().getServletContext().getRealPath("pictures/");
			String name = realPath + imageName;
			String imgUrl = "/video/pictures/" + imageName;
			// 更新session的图片url，和数据库的
			User user = (User) req.getSession().getAttribute("user");
			user.setImgurl(imgUrl);
			userService.update(user);
			req.getSession().setAttribute("user", user);
			try {
				// 拷贝到服务器
				imageFile.transferTo(new File(name));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "redirect:userCenter";
		}
		req.setAttribute("msg", "头像格式不符");
		return "redirect:userCenter";

	}

	/**
	 * 更改密码 跳转
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/userUpdatePassword")
	public String userUpdatePassword(HttpServletRequest req) {

		return "userUpdatePassword";
	}

	/**
	 * 验证原密码是否正确
	 * 
	 * @param originalPassword
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/originalPasswordCheck")
	public void originalPasswordCheck(String originalPassword, HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");

		boolean isExist;
		if (!DigestUtils.md5DigestAsHex(originalPassword.getBytes()).equals(user.getPassword())) {
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

	/**
	 * 两次输入新密码 验证
	 * 
	 * @param newPassword
	 * @param rePassword
	 * @param req
	 * @param resp
	 */

	@RequestMapping("/rePasswordCheck")
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
	@RequestMapping("/passwordUpdate")
	public String passwordUpdate(String newPassword, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");

		user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		userService.update(user);
		req.getSession().setAttribute("user", user);
		return "redirect:userCenter";

	}

	/**
	 * 发送邮箱
	 */
}
