package com.rammus.service;

import java.util.List;



import com.rammus.model.Admin;


public interface AdminService {

	List<Admin> adminLogin(String username, String password);
}
