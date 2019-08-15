package com.rammus.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.UserMapper;
import com.rammus.model.User;
import com.rammus.model.UserExample;
import com.rammus.model.UserExample.Criteria;
import com.rammus.service.UserService;

/**
 * 
 * @author 陈凯
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 通过字段 accounts 查找
	 */
	@Override
	public User selectByAccounts(String accounts) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(accounts);
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			User user = list.get(0);
			return user;
		}
		return null;
	}

	/**
	 * 更新用户
	 */

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);

	}

	/**
	 * 增加用户
	 */
	@Override
	public void insert(User user) {
		user.setCreatetime(new Date());
		userMapper.insert(user);

	}

}
