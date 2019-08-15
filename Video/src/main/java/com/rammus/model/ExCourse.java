package com.rammus.model;

import java.util.List;

public class ExCourse extends Course{
	private Subject subject;
	private List<Video> videoList;
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public List<Video> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}
	public ExCourse(Subject subject, List<Video> videoList) {
		super();
		this.subject = subject;
		this.videoList = videoList;
	}
	public ExCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
