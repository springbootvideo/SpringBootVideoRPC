package com.rammus.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rammus.model.Video;
import com.rammus.model.VideoExample;
import com.rammus.util.VideoResult;

public interface VideoManageService {

	public List<Video> getListByPage();
	//总数
	@Select("select count(*) from video")
	public int getTotal();
	//保存
	VideoResult videoSave(Video video);
	//查询按id
	Video selectByPrimaryKey(Integer id);
	//修改
	VideoResult videoUpdate(Video video);
	//删除
	int deleteById(int id);
	
}
