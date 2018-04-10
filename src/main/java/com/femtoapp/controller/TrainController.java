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
import com.femtoapp.pojo.Train;
import com.femtoapp.pojo.T_Activity;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.pojo.T_ActivityQueryVo;
import com.femtoapp.pojo.Train;
import com.femtoapp.pojo.TrainCustom;
import com.femtoapp.pojo.TrainQueryVo;
import com.femtoapp.service.TrainService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/train")
public class TrainController {
	@Autowired
	private TrainService trainService;
//��ҳ���Ҳ�λѵ����
	@RequestMapping("/findTrainlist")
	public ModelAndView findTrainlist(TrainCustom trainCustom,Integer pageNo, Integer pageSize) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		TrainQueryVo trainQueryVo = new TrainQueryVo();
		trainQueryVo.setTrainCustom(trainCustom);
		PageInfo<TrainCustom> queryByPage = trainService.queryByPage(trainQueryVo, pageNo, pageSize);
		modelAndView.addObject("queryByPage", queryByPage);
		modelAndView.addObject("t", trainCustom);
		modelAndView.setViewName("/WEB-INF/admin/trainlist.jsp");
		return modelAndView;
	}
	//�����û�id�����û���ӵĲ�λѵ��List
	@RequestMapping("/findTrainlistclient")
	public  @ResponseBody JSONObject findTrainlistclient(String site ,String user_id,Integer pageNo, Integer pageSize) throws Exception {
		 JSONObject json = new JSONObject();
		 TrainQueryVo trainQueryVo = new TrainQueryVo();
		 TrainCustom trainCustom = new TrainCustom();
		 trainCustom.setSite(site);
		 trainCustom.setUser_id(user_id);
		 trainQueryVo.setTrainCustom(trainCustom);
		 PageInfo<TrainCustom> queryByPage = trainService.queryByPage(trainQueryVo, pageNo, pageSize);
		 
		 json.put("result", 1);
		 json.put("queryByPage", queryByPage);
		return json;
	
	
	}
	//����id���Ҳ�λѵ����Ϣ
	@RequestMapping("/findTrainByidclient")
	public @ResponseBody JSONObject findTrainByidclient(Integer id)
			throws Exception {
		JSONObject json = new JSONObject();
	
		try {
			Train train =trainService.findTrainByid(id);
			json.put("result",1);
			json.put("Train",train);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result",-1);
			json.put("message",e.getMessage());
			return json;
		}
		
		
		

	
	
	}
	//ɾ����λѵ����Ϣ
	@RequestMapping("/deleteTrainByidclient")
	public @ResponseBody JSONObject deleteTrainByidclient(Integer id,String user_id)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			Train Train = trainService.findTrainByid(id);
			if(!Train.getUser_id().equals(user_id)) {
				json.put("result",-1);
				json.put("message","��Ϣ������");
				return json;
			}
			trainService.deleteTrain(id);
			json.put("result",1);
			json.put("message","ɾ���ɹ�");
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result",-1);
			json.put("message",e.getMessage());
			return json;
		}
	
	
	}
	//�޸Ĳ�λѵ����Ϣ
	@RequestMapping("/updateTrainByidclient")
	public @ResponseBody JSONObject updateTrainByidclient(Train Train)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			Train Train1 = trainService.findTrainByid(Train.getId());
			if(!Train1.getUser_id().equals(Train.getUser_id())) {
				json.put("result",-1);
				json.put("message","��Ϣ������");
				return json;
			}
			Train.setCreate_time(Train1.getCreate_time());
			trainService.updateTrain(Train);
			
			json.put("result",1);
			json.put("message","�޸ĳɹ�");
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result",-1);
			json.put("message",e.getMessage());
			return json;
		}
	
		
	
	
	}
	
	
	
	
	
	
	
	
	
	
	//��ת�����ҳ��
	@RequestMapping("/insertPage")
	public String insertPage() throws Exception {

		return "/WEB-INF/admin/insertTrainPage.jsp";
	}
//��Ӳ�λ��Ϣ
	@RequestMapping("/insertTrain")
	public ModelAndView insertTrain(Train train) throws Exception {
		train.setCreate_time(current_time());
		trainService.insertTrain(train);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/train/findTrainlist.action");
		return modelAndView;
	}
	//��ת���޸�ҳ��
	@RequestMapping("/updatePage")
	public ModelAndView updatePage(Integer id) throws Exception {

		 Train train = trainService.findTrainByid(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("train", train);
		modelAndView.setViewName("/WEB-INF/admin/insertTrainPage.jsp");
		return modelAndView;
	}
	//�޸Ĳ�λѵ����Ϣ
	@RequestMapping("/updateTrain")
	public String updateTrain(Train train) throws Exception {

		train.setCreate_time(current_time());

		trainService.updateTrain(train);
		

		return "redirect:/train/findTrainlist.action";

	}
	private String current_time() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
	//ɾ����λѵ����Ϣ
	@RequestMapping("/deleteTrain")
	public ModelAndView deleteTrain(Integer id) throws Exception {
		trainService.deleteTrain(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/train/findTrainlist.action");
		return modelAndView;

	}
}
