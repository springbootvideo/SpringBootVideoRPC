package com.rammus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rammus.model.Video;

public interface ExVideoMapper {
	int deleteById(Integer videoId);

	int insert(Video record);

	int insertSelective(Video record);

	Video selectById(Integer videoId);

	int updateByIdSelective(Video record);

	int updateById(Video record);

	public List<Video> getAll();

	public List<Video> getListByPage(@Param("begin") int begin, @Param("size") int size);

	@Select("select count(*) from video")
	public int getTotal();

	List<Video> selectLike(@Param("speakerId") String speakerId, @Param("courseId") String courseId,
			@Param("subject") String subject, @Param("factor") String factor, @Param("page") int page,
			@Param("number") int number);

	int selectLikeCount(@Param("speakerId") String speakerId, @Param("courseId") String courseId,
			@Param("subject") String subject, @Param("factor") String factor);

}
