package com.rammus.mapper;

import com.rammus.model.Speaker;
import com.rammus.model.SpeakerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SpeakerMapper {
    long countByExample(SpeakerExample example);

    int deleteByExample(SpeakerExample example);

    //搜全
    List<Speaker> selectAll();
	//总数
	@Select("select count(*) from speaker")
	public int getTotal();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Speaker record);

    int insertSelective(Speaker record);

    List<Speaker> selectByExample(SpeakerExample example);

    Speaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByExample(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByPrimaryKeySelective(Speaker record);

    int updateByPrimaryKey(Speaker record);
}