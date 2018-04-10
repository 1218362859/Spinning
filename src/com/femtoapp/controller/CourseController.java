package com.femtoapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.femtoapp.pojo.Course;
import com.femtoapp.pojo.CourseCustom;
import com.femtoapp.pojo.CourseQueryVo;
import com.femtoapp.service.CourseService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	//查找课程列表
	@RequestMapping("/findCourselist")
	public ModelAndView findCourselist(CourseCustom courseCustom, Integer pageNo, Integer pageSize) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		CourseQueryVo courseQueryVo = new CourseQueryVo();
		courseQueryVo.setCourseCustom(courseCustom);
		PageInfo<CourseCustom> queryByPage = courseService.queryByPage(courseQueryVo, pageNo, pageSize);

		modelAndView.addObject("queryByPage", queryByPage);
		modelAndView.addObject("c", courseCustom);
		modelAndView.setViewName("/WEB-INF/admin/courselist.jsp");
		return modelAndView;
	}
//用户id查找用户添加的课程列表
	@RequestMapping("/findCourselistclient")
	public @ResponseBody JSONObject findCourselistclient(String user_id, Integer pageNo, Integer pageSize)
			throws Exception {
		JSONObject json = new JSONObject();
		CourseCustom courseCustom = new CourseCustom();
		courseCustom.setUser_id(user_id);
		CourseQueryVo courseQueryVo = new CourseQueryVo();
		courseQueryVo.setCourseCustom(courseCustom);
		PageInfo<CourseCustom> queryByPage = courseService.queryByPage(courseQueryVo, pageNo, pageSize);

		json.put("result", 1);
		json.put("queryByPage", queryByPage);

		return json;
	}
	//id查找课程
	@RequestMapping("/findCourseByidclient")
	public @ResponseBody JSONObject findCourseByidclient(Integer id)
			throws Exception {
		JSONObject json = new JSONObject();
	
		try {
			Course course = courseService.findCourseByid(id);
			json.put("result",1);
			json.put("course",course);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result",-1);
			json.put("message",e.getMessage());
			return json;
		}
		
		
		

	
	
	}
	//删除课程
	@RequestMapping("/deleteCourseByidclient")
	public @ResponseBody JSONObject deleteCourseByidclient(Integer id,String user_id)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			Course course = courseService.findCourseByid(id);
			if(!course.getUser_id().equals(user_id)) {
				json.put("result",-1);
				json.put("message","信息不符合");
				return json;
			}
			courseService.deleteCourse(id);
			json.put("result",1);
			json.put("message","删除成功");
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result",-1);
			json.put("message",e.getMessage());
			return json;
		}
	
	
	}
	//修改课程
	@RequestMapping("/updateCourseByidclient")
	public @ResponseBody JSONObject updateCourseByidclient(Course course)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			Course course1 = courseService.findCourseByid(course.getId());
			if(!course1.getUser_id().equals(course.getUser_id())) {
				json.put("result",-1);
				json.put("message","信息不符合");
				return json;
			}
			course.setCreate_time(course1.getCreate_time());
			courseService.updateCourse(course);
			
			json.put("result",1);
			json.put("message","修改成功");
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result",-1);
			json.put("message",e.getMessage());
			return json;
		}
	
		
	
	
	}
	
//到添加页面
	@RequestMapping("/insertPage")
	public String insertPage() throws Exception {

		return "/WEB-INF/admin/insertCoursePage.jsp";
	}
//添加课程信息
	@RequestMapping("/insertCourse")
	public ModelAndView insertCourse(Course course) throws Exception {
		course.setCreate_time(current_time());
		courseService.insertCourse(course);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/course/findCourselist.action");
		return modelAndView;
	}
//修改页面
	@RequestMapping("/updatePage")
	public ModelAndView updatePage(Integer id) throws Exception {

		Course course = courseService.findCourseByid(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("course", course);
		modelAndView.setViewName("/WEB-INF/admin/insertCoursePage.jsp");
		return modelAndView;
	}
//修改课程
	@RequestMapping("/updateCourse")
	public String updateCourse(Course course) throws Exception {

		course.setCreate_time(current_time());

		courseService.updateCourse(course);

		return "redirect:/course/findCourselist.action";

	}

	private String current_time() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
//删除课程信息
	@RequestMapping("/deleteCourse")
	public ModelAndView deleteCourse(Integer id) throws Exception {
		courseService.deleteCourse(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/course/findCourselist.action");
		return modelAndView;

	}
}
