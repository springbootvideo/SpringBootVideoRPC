package com.rammus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rammus.model.Video;
import com.rammus.model.VideoExample;

public interface VideoManageMapper {

	public List<Video> getListByPage();

	//总数
	@Select("select count(*) from video")
	public int getTotal();
	//模糊查询
	List<Video> selectLike(String speakerId, String courseId,@Param("subject") String subject,@Param("factor") String factor);
	
	long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer videoId); 
    
    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}
