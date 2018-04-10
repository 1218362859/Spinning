package com.femtoapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;
import com.femtoapp.service.CollectService;
import com.femtoapp.service.CourseService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
//查找用户的收藏列表
	@RequestMapping("/findlistByUseridclient")
	public @ResponseBody JSONObject findlistByUseridclient(CollectCustom collectCustom) throws Exception {
		JSONObject json = new JSONObject();

		CollectQueryVo collectQueryVo = new CollectQueryVo();
		collectQueryVo.setCollectCustom(collectCustom);
		List<CollectCustom> collectList = collectService.findCollectList(collectQueryVo);
		if (collectList == null) {
			json.put("resule", -1);
			json.put("message", "您还没有收藏哦");
			return json;
		}
		json.put("resule", 1);
		json.put("collectList", collectList);
		return json;
	}
	private String current_time() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
	//添加收藏
	@RequestMapping("/insertCollectclient")
	public @ResponseBody JSONObject insertCollectclient(Integer  aid,String user_id) throws Exception {
		JSONObject json = new JSONObject();
		Collect collect = new Collect();
		collect.setAid(aid);
		collect.setUser_id(user_id);
		collect.setCreate_time(current_time());
		collectService.insertCollect(collect);
		json.put("resule", 1);
		json.put("message", "添加成功");
		return json;
	}
//删除收藏
	@RequestMapping("/deleteCollectclient")
	public @ResponseBody JSONObject deleteCollectclient(Integer  id,String user_id) throws Exception {
		JSONObject json = new JSONObject();
		
		try {
			Collect collect = collectService.findCollectByid(id);
			if(collect.getUser_id().equals(user_id)) {
				
				collectService.deleteCollect(id);
				
				json.put("resule", 1);
				json.put("message", "删除成功");
				return json;
			}
			json.put("resule", -1);
			json.put("message", "您没有该收藏");
			return json;
			
		} catch (Exception e) {
			json.put("resule", -1);
			json.put("message", e.getMessage());
			return json;
		}
		
		
	}
	
}
