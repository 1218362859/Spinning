package com.femtoapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.femtoapp.pojo.Comments;
import com.femtoapp.pojo.CommentsCustom;
import com.femtoapp.pojo.CommentsQueryVo;
import com.femtoapp.pojo.T_Activity;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.pojo.T_ActivityQueryVo;
import com.femtoapp.pojo.Zans;
import com.femtoapp.pojo.T_Activity;
import com.femtoapp.service.CommentsService;
import com.femtoapp.service.T_ActivityService;
import com.femtoapp.service.ZansService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/t_Activity")
public class T_ActivityController {

	@Autowired
	private T_ActivityService t_ActivityService;
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private ZansService zansService;
	
	//点击数加一
			@RequestMapping("/updateClicks_countclient")
			public @ResponseBody  JSONObject updateClicks_countclient(Integer aid ) throws Exception {
				JSONObject json = new JSONObject();
				try {
					t_ActivityService.updateT_ActivityClicks_count(aid, 1);
					
					json.put("result",1);
					json.put("message", "点击次数+1");
					return json;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					json.put("result",-1);
					json.put("message", "点击数异常");
					return json;
				}
			
				
				
			}
	//点赞
		@RequestMapping("/updateZanclient")
		public @ResponseBody  JSONObject updateZanclient(String user_id,Integer aid ) throws Exception {
			
			JSONObject json = new JSONObject();
			
			Zans zans;
			try {
				zans = zansService.findZanByUser_id(user_id, aid);
				if(zans==null) {
					t_ActivityService.updateT_ActivityZans(aid, 1);
					Zans zans2 = new Zans();
					zans2.setAid(aid);
					zans2.setUser_id(user_id);
					zans2.setCreate_time(current_time());
					zansService.insertZans(zans2);
					json.put("result",1);
					json.put("message", "点赞成功");
					return json;
				}else {
					
					t_ActivityService.updateT_ActivityZans(aid, -1);
					zansService.deleteZans(zans);
					json.put("result",0);
					json.put("message", "已取消赞");
					return json;
				}
			} catch (Exception e) {
				json.put("result",-1);
				json.put("message", "点赞异常");
				return json;
			}
			
			
			
			
			
			
		}
	
	//添加活动赛事文章等信息
	@RequestMapping("/insertContentclient")
	public ModelAndView insertContentclient(T_Activity t_Activity) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		t_ActivityService.insertT_Activity(t_Activity);
		
		modelAndView.setViewName("/ueditor.jsp");

		return modelAndView;
	
	
	
	}
	@RequestMapping("/insertCommentsclient")
	public @ResponseBody JSONObject insertCommentsclient(Comments comments) throws Exception {
		JSONObject json = new JSONObject();
		
		try {
			comments.setTime(current_time());
			commentsService.insertComments(comments);
		} catch (Exception e) {
			json.put("result", -1);
			json.put("message","添加失败");
			
			return json;
			
		}
		json.put("result", 1);
		json.put("message","评论成功");
		return json;
		
	}
	
	//查找活动赛事的评论信息列表
		@RequestMapping("/findCommentsListclient")
		public @ResponseBody JSONObject findCommentsListclient(CommentsCustom commentsCustom) throws Exception {
			CommentsQueryVo commentsQueryVo = new CommentsQueryVo();
			commentsQueryVo.setCommentsCustom(commentsCustom);
			JSONObject json = new JSONObject();
			List<CommentsCustom> commentList;
			try {
				commentList = commentsService.findCommentList(commentsQueryVo);
			} catch (Exception e) {
				json.put("result",-1);
				json.put("message","查找列表失败");
				
				return json;
			}
			
			
			json.put("result",1);
			json.put("commentList",commentList);
			
			return json;
		}
	
	//根据id查找活动赛事文章等信息
	@RequestMapping("/findT_ActivityByidclient")
	public @ResponseBody JSONObject findT_ActivityByidclient(Integer aid)
			throws Exception {
		JSONObject json = new JSONObject();
	
		try {
			T_Activity t_Activity =t_ActivityService.findT_ActivityByid(aid);
			json.put("result",1);
			json.put("t_Activity",t_Activity);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result",-1);
			json.put("message",e.getMessage());
			return json;
		}
		
		
		

	
	
	}
	//根据id删除活动赛事文章
	@RequestMapping("/deleteT_ActivityByidclient")
	public @ResponseBody JSONObject deleteT_ActivityByidclient(Integer aid,String user_id)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			T_Activity t_Activity = t_ActivityService.findT_ActivityByid(aid);
			if(!t_Activity.getUser_id().equals(user_id)) {
				json.put("result",-1);
				json.put("message","信息不符合");
				return json;
			}
			t_ActivityService.deleteT_Activity(aid);
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
	//修改活动赛事文章
	@RequestMapping("/updateT_ActivityByidclient")
	public @ResponseBody JSONObject updateT_ActivityByidclient(T_Activity t_Activity)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			T_Activity t_Activity1 = t_ActivityService.findT_ActivityByid(t_Activity.getAid());
			if(!t_Activity1.getUser_id().equals(t_Activity.getUser_id())) {
				json.put("result",-1);
				json.put("message","信息不符合");
				return json;
			}
			t_Activity.setUser_id(t_Activity1.getUser_id());
			t_Activity.setClicks_count(t_Activity1.getClicks_count());
			t_Activity.setZan_count(t_Activity1.getZan_count());
			t_Activity.setCreate_time(t_Activity1.getCreate_time());
			
			t_ActivityService.updateT_Activity(t_Activity);
			
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
	
	
//查找活动赛事文章列表
	@RequestMapping("/findT_Activitylist")
	public ModelAndView findT_Activitylist(T_ActivityCustom t_ActivityCustom,Integer pageNo, Integer pageSize) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		T_ActivityQueryVo t_ActivityQueryVo = new T_ActivityQueryVo();
		t_ActivityQueryVo.setT_ActivityCustom(t_ActivityCustom);
		PageInfo<T_ActivityCustom> queryByPage = t_ActivityService.queryByPage(t_ActivityQueryVo, pageNo, pageSize);
		modelAndView.addObject("queryByPage", queryByPage);
		modelAndView.addObject("t", t_ActivityCustom);
		modelAndView.setViewName("/WEB-INF/admin/t_Activitylist.jsp");

		return modelAndView;
	}
//根据类型状态查找活动赛事列表
	@RequestMapping("/findActivityclient")
	public  @ResponseBody JSONObject findActivityclient(String type,String state,String user_id,Integer pageNo, Integer pageSize) throws Exception {
		 JSONObject json = new JSONObject();
		 
		 T_ActivityQueryVo t_ActivityQueryVo = new T_ActivityQueryVo();
		 T_ActivityCustom t_ActivityCustom = new T_ActivityCustom();
		 t_ActivityCustom.setType(type);
		 t_ActivityCustom.setState(state);
		 t_ActivityCustom.setUser_id(user_id);
			t_ActivityQueryVo.setT_ActivityCustom(t_ActivityCustom);
			PageInfo<T_ActivityCustom> queryByPage = t_ActivityService.queryByPage(t_ActivityQueryVo, pageNo, pageSize);
		 
			json.put("result",1);
			json.put("queryByPage",queryByPage);
			
		return json;
		 
	
	
	
	}
	
	//删除活动赛事

	@RequestMapping("/deleteT_Activity")
	public ModelAndView deleteT_Activity(Integer aid) throws Exception {
		t_ActivityService.deleteT_Activity(aid);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/t_Activity/findT_Activitylist.action");
		return modelAndView;

	}

	private String current_time() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
//到添加页面
	@RequestMapping("/insertPage")
	public String insertPage() throws Exception {

		return "/WEB-INF/admin/insertActivityPage.jsp";
	}
//到修改页面
	@RequestMapping("/updatePage")
	public ModelAndView updatePage(Integer aid) throws Exception {

		T_Activity t_Activity = t_ActivityService.findT_ActivityByid(aid);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("t_Activity", t_Activity);
		modelAndView.setViewName("/WEB-INF/admin/insertActivityPage.jsp");
		return modelAndView;
	}
//修改赛事活动
	@RequestMapping("/updateT_Activity")
	public String updateT_Activity(T_Activity t_Activity) throws Exception {

		t_Activity.setCreate_time(current_time());

		t_ActivityService.updateT_Activity(t_Activity);

		return "redirect:/t_Activity/findT_Activitylist.action";

	}
//添加赛事活动
	@RequestMapping("/insertT_Activity")
	public ModelAndView insertT_Activity(T_Activity t_Activity) throws Exception {
		t_Activity.setCreate_time(current_time());
		t_ActivityService.insertT_Activity(t_Activity);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/t_Activity/findT_Activitylist.action");
		return modelAndView;
	}
}
