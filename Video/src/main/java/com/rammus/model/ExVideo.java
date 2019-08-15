package com.rammus.model;

public class ExVideo extends Video {
	  private Speaker speaker;
      private Course course;
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public ExVideo(Speaker speaker, Course course) {
		super();
		this.speaker = speaker;
		this.course = course;
	}
	public ExVideo() {
		super();
		// TODO Auto-generated constructor stub
	}
      
      
      
}
