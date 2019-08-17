package com.rammus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class ExCourse extends Course implements Serializable{
	private Subject subject;
	private List<Video> videoList =new ArrayList<Video>();

	
}
