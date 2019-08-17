package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.rammus.mapper.SubjectManageMapper;
import com.rammus.model.Subject;
import com.rammus.service.SubjectManageService;
@Service
public class SubjectManageServiceImpl implements SubjectManageService{

	@Autowired
	SubjectManageMapper SubjectMM;
	@Override
	@CacheEvict(value = "subject")
	public List<Subject> selectAll() {
		// TODO Auto-generated method stub
		return SubjectMM.selectAll();
	}

}
