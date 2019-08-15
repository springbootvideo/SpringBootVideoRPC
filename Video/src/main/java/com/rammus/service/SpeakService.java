package com.rammus.service;

import java.util.List;

import com.rammus.model.Speaker;
import com.rammus.util.VideoResult;

public interface SpeakService {

	List<Speaker> selectAll();
}
