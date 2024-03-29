package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.rammus.mapper.VideoManageMapper;
import com.rammus.model.Video;
import com.rammus.model.VideoExample;
import com.rammus.service.VideoManageService;
import com.rammus.util.VideoResult;
@Service
public class VideoManageServiceImpl implements VideoManageService{

	@Autowired
	VideoManageMapper videoM;
	@Override
	@CacheEvict(value = "video")
	public List<Video> getListByPage() {
		// TODO Auto-generated method stub
		return videoM.getListByPage();
	}
	@Override
	@CacheEvict(value = "video")
	public int getTotal() {
		// TODO Auto-generated method stub
		return videoM.getTotal();
	}
	@Override
	@CacheEvict(value = "video")
	public VideoResult videoSave(Video video) {
		// TODO Auto-generated method stub
		
		videoM.insert(video);
		return VideoResult.ok();
	}
	@Override
	@CacheEvict(value = "video")
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return videoM.deleteByPrimaryKey(id);
	}
	@Override
	@CacheEvict(value = "video")
	public Video selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return videoM.selectByPrimaryKey(id);
	}
	@Override
	@CacheEvict(value = "video")
	public VideoResult videoUpdate(Video video) {
		// TODO Auto-generated method stub
		videoM.updateByPrimaryKey(video);
		return VideoResult.ok();
	}
	@Override
	@CacheEvict(value = "video")
	public List<Video> selectLike(String speakerId, String courseId, String subject, String factor) {
		// TODO Auto-generated method stub
		return videoM.selectLike(speakerId, courseId, subject, factor);
	}

}
