package com.rammus.service;

import java.util.List;

import com.rammus.model.Video;

/**
 * 
 * @author Eason
 *
 */

public interface VideoService {
	public List<Video> getAll();

	public List<Video> getListByPage(int page, int size);

	public int getTotal();

	public void add(Video video);

	public Video selectById(int id);

	public Integer update(Video video);

	public void deleteById(int id);

	List<Video> selectLike(String speakerId, String courseId, String subject, String factor, int page, int number);

	int selectLikeCount(String speakerId, String courseId, String subject, String factor);
}
