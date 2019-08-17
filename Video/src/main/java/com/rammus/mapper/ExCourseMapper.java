package com.rammus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rammus.model.Course;
import com.rammus.model.ExCourse;
/**
 * 
 * @author Eason
 *
 */
public interface ExCourseMapper {
	int deleteById(Integer id);

	int insert(Course record);

	int insertSelective(Course record);

	Course selectById(Integer id);
	
	Course selectByIdContainVideoList(Integer id);

	List<ExCourse> selectBySubjectId(Integer SubjectId);

	int updateByIdSelective(Course record);

	int updateById(Course record);

	public List<Course> getAll();

	public List<Course> getListByPage(@Param("begin") int begin, @Param("size") int size);

	@Select("select count(*) from course")
	public int getTotal();
	
	 List<ExCourse> selectIncludeVideoAndSubjectBySubjectId(int subjectId);
}


