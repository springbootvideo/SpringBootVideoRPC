package com.rammus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rammus.model.Course;
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

	List<Course> selectBySubjectId(Integer SubjectId);

	int updateByIdSelective(Course record);

	int updateById(Course record);

	public List<Course> getAll();

	public List<Course> getListByPage(@Param("begin") int begin, @Param("size") int size);

	@Select("select count(*) from course")
	public int getTotal();
}


