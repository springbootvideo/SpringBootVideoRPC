package com.rammus.service;

import com.rammus.model.User;

/**
 * 
 * @author 陈凯
 *
 */
public interface UserService {
	/**
	 * 通过字段 accounts 查找
	 * 
	 * @param accounts
	 * @return
	 */
	public User selectByAccounts(String accounts);

	/**
	 * 更新用户
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * 增加用户
	 * 
	 * @param user
	 */
	public void insert(User user);
}
