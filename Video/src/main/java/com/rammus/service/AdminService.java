package com.rammus.service;

import java.util.List;



import com.rammus.model.Admin;


public interface AdminService {

	List<Admin> adminLogin(String username, String password);
	
	List<Admin> selectById();
	
	//save
	void adminSave(Admin admin);
	//按id搜
	Admin selectByIdd(Integer id);
	//update
	void adminUpdate(Admin admin);
	//Delete
	void adminDelete(Integer id);
}
