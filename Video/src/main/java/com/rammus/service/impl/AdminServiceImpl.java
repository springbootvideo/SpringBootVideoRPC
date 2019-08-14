package com.rammus.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.AdminMapper;
import com.rammus.model.Admin;
import com.rammus.model.AdminExample;
import com.rammus.model.AdminExample.Criteria;
import com.rammus.service.AdminService;
import com.rammus.util.VideoResult;
/**
 * 
 * @author 吕怀浩
 *
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	@Override
	public List<Admin> adminLogin(String accounts, String password) {
		// TODO Auto-generated method stub\
		System.out.println("进入"+password);
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(accounts);
		List<Admin> list = adminMapper.selectByExample(example);
		System.out.println(list+"*&*&*&");
		return list;
		
	}

	

}
