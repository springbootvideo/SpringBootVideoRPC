package com.rammus.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.rammus.mapper.AdminMapper;
import com.rammus.model.Admin;
import com.rammus.model.AdminExample;
import com.rammus.model.AdminExample.Criteria;
import com.rammus.service.AdminService;
import com.rammus.util.VideoResult;

public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	@Override
	public VideoResult adminLogin(String accounts, String password, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub\
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(accounts);
		List<Admin> list = adminMapper.selectByExample(example);
		
		return null;
	}

	

}
