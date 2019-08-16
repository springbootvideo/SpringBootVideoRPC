package com.rammus.mapper;

import com.rammus.model.Subject;
import com.rammus.model.SubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectManageMapper {
	
	
	//查全部
	List<Subject> selectAll();
	
	
	
	
	
	
    long countByExample(SubjectExample example);

    int deleteByExample(SubjectExample example);

    int deleteByPrimaryKey(Integer subjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(SubjectExample example);

    Subject selectByPrimaryKey(Integer subjectId);

    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}