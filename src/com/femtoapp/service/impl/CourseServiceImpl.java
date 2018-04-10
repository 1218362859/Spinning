package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.CourseMapper;
import com.femtoapp.pojo.Course;
import com.femtoapp.pojo.CourseCustom;
import com.femtoapp.pojo.CourseQueryVo;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;

	public Course findCourseByid(Integer id) throws Exception {
		Course course = courseMapper.findCourseByid(id);
		if(course==null) {
			
			throw new SpinningException("û���ҵ�");
		}
		return course;
	}

	public void insertCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		courseMapper.insertCourse(course);
	}

	 
	public List<CourseCustom> findCourseList(CourseQueryVo courseQueryVo) throws Exception {
		List<CourseCustom> courseList = courseMapper.findCourseList(courseQueryVo);
		if (courseList != null && courseList.size() > 0) {
			return courseList;
		} else {
			throw new SpinningException("����ʧ��");
		}
	}

	 
	public void updateCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		try {
		courseMapper.updateCourse(course);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("�޸Ŀγ�ʧ��");
	}
	}

	 
	public void deleteCourse(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
		courseMapper.deleteCourse(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("ɾ���γ�ʧ�ܣ��������Լ�� ");
	}
	}

	 
	public PageInfo<CourseCustom> queryByPage(CourseQueryVo courseQueryVo, Integer pageNo, Integer pageSize)
			throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<CourseCustom> list = courseMapper.findCourseList(courseQueryVo);
	    //��PageInfo�Խ�����а�װ
	    PageInfo<CourseCustom> page = new PageInfo<CourseCustom>(list);
	    //�y��PageInfo��������
	  
	    
	    
	    return page;
	}

	


}
