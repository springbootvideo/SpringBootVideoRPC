package com.rammus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rammus.mapper.ExVideoMapper;
import com.rammus.model.Video;
import com.rammus.service.VideoService;
/**
 * 
 * @author Eason
 *
 */

@Service
public class VideoServiceImpl implements VideoService {


	@Autowired
	ExVideoMapper ev;

	public List<Video> getAll() {

		return ev.getAll();
	}

	public List<Video> getListByPage(int page, int size) {

		return ev.getListByPage(size * (page - 1), size);
	}

	public int getTotal() {

		return ev.getTotal();
	}

	public void add(Video video) {
		ev.insert(video);

	}

	public Video selectById(int id) {

		return ev.selectById(id);
	}

	public Integer update(Video video) {

		return ev.updateById(video);
	}

	public void deleteById(int id) {

		ev.deleteById(id);
	}

	@Override
	public List<Video> selectLike(String speakerId, String courseId, String subject, String factor, int page,
			int number) {
		return ev.selectLike(speakerId,courseId,subject, factor, page, number);
	}

	@Override
	public int selectLikeCount(String speakerId, String courseId, String subject, String factor) {
		// TODO Auto-generated method stub
		return ev.selectLikeCount(speakerId, courseId, subject, factor);
	}
}
