package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.SpeakerMapper;
import com.rammus.model.Speaker;
import com.rammus.model.SpeakerExample;
import com.rammus.model.SpeakerExample.Criteria;
import com.rammus.service.SpeakService;
import com.rammus.util.VideoResult;
@Service
public class SpeakServiceImpl implements SpeakService{

	@Autowired
	SpeakerMapper speakMapper;

	@Override
	public List<Speaker> selectAll() {
		// TODO Auto-generated method stub
		return speakMapper.selectAll();
	}
	

}
