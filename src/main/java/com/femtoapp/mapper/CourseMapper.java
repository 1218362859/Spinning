package com.femtoapp.mapper;

import java.util.List;

import com.femtoapp.pojo.Course;
import com.femtoapp.pojo.CourseCustom;
import com.femtoapp.pojo.CourseQueryVo;
import com.femtoapp.pojo.User;
import com.femtoapp.pojo.UserCustom;
import com.femtoapp.pojo.UserQueryVo;


public interface CourseMapper {

	
	public Course findCourseByid(Integer   id) throws Exception;
	public void insertCourse(Course course) throws Exception;
	public List<CourseCustom> findCourseList(CourseQueryVo courseQueryVo) throws Exception;
	public void updateCourse(Course course) throws Exception;
	public void deleteCourse(Integer id)throws Exception;
	
}
