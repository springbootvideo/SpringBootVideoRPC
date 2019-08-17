package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.AdminMapper;
import com.rammus.model.Admin;
import com.rammus.model.AdminExample;
import com.rammus.model.AdminExample.Criteria;
import com.rammus.service.AdminService;

/**
 * 
 * @author 吕怀浩
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;

	@Override
	public List<Admin> adminLogin(String accounts, String password) {
		// TODO Auto-generated method stub\
	//	System.out.println("进入" + password);
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(accounts);
		List<Admin> list = adminMapper.selectByExample(example);
//		System.out.println(list + "*&*&*&");
		return list;

	}

	@Override
	public List<Admin> selectById() {
		// TODO Auto-generated method stub
		Integer id=4;
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminIdGreaterThanOrEqualTo(id);
		List<Admin> list = adminMapper.selectByExample(example);
		return list;
	}

	@Override
	public void adminSave(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.insert(admin);
	}

	@Override
	public Admin selectByIdd(Integer id) {
		// TODO Auto-generated method stub
		Admin list = adminMapper.selectByPrimaryKey(id);
		return list;
	}

	@Override
	public void adminUpdate(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.updateByPrimaryKey(admin);
	}

	@Override
	public void adminDelete(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.deleteByPrimaryKey(id);
	}

}
