package com.femtoapp.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.Course;
import com.femtoapp.pojo.CourseCustom;
import com.femtoapp.pojo.CourseQueryVo;
import com.femtoapp.service.CourseService;


public class CourseTest {
	@Test
	public void findcourseById() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CourseService service = ac.getBean(CourseService.class);
		Course course = service.findCourseByid(1);
		System.out.println(course);
	}
	
	

	@Test
	public void insertcourse() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CourseService service = ac.getBean(CourseService.class);
		Course course = new Course();
		course.setUser_id("1");
		service.insertCourse(course);
	}

	@Test
	public void updatecourse() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CourseService service = ac.getBean(CourseService.class);
		Course course = new Course();
		course.setId(1);
		course.setUser_id("1");
		service.updateCourse(course);
	}

	@Test
	public void findcourselist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CourseService service = ac.getBean(CourseService.class);
		CourseQueryVo uqv=new CourseQueryVo();
		CourseCustom uc=new CourseCustom();
		uqv.setCourseCustom(uc);
		List<CourseCustom> findcourseList = service.findCourseList(null);
		System.out.println(findcourseList);

	}
}
