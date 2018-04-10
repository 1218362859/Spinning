package com.femtoapp.service;

import java.util.List;

import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;
import com.femtoapp.pojo.Course;
import com.femtoapp.pojo.CourseCustom;
import com.femtoapp.pojo.CourseQueryVo;
import com.github.pagehelper.PageInfo;

public interface CourseService {

	public Course findCourseByid(Integer   id) throws Exception;
	public void insertCourse(Course course) throws Exception;
	public List<CourseCustom> findCourseList(CourseQueryVo courseQueryVo) throws Exception;
	public void updateCourse(Course course) throws Exception;
	public void deleteCourse(Integer id)throws Exception;
	public PageInfo<CourseCustom> queryByPage(CourseQueryVo courseQueryVo, Integer pageNo, Integer pageSize)throws Exception;
}
