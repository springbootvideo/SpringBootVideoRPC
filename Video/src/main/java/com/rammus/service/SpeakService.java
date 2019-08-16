package com.rammus.service;

import java.util.List;

import com.rammus.model.Speaker;
import com.rammus.util.VideoResult;

public interface SpeakService {

	List<Speaker> selectAll();
	//总数
	int getTotal();
	//保存
	void speakerSave(Speaker speaker);
	//id查
	Speaker selectById(Integer id);
	//修改
	void speakerUpdate(Speaker speaker);
	//单删
	void speakerDelete(Integer id);
}
