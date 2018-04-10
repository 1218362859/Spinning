package com.femtoapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.femtoapp.exception.SpinningException;
import com.femtoapp.pojo.Badge;
import com.femtoapp.pojo.Original;
import com.femtoapp.pojo.OriginalCustom;
import com.femtoapp.pojo.OriginalQueryVo;
import com.femtoapp.pojo.User;
import com.femtoapp.pojo.User_Auths;
import com.femtoapp.pojo.User_AuthsCustom;
import com.femtoapp.pojo.Validate;
import com.femtoapp.service.BadgeService;
import com.femtoapp.service.OriginalService;
import com.femtoapp.service.UserService;
import com.femtoapp.service.User_AuthsService;
import com.femtoapp.service.ValidateService;
import com.femtoapp.tool.MD5Tools;
import com.femtoapp.tool.SendTelMessage;
import com.femtoapp.tool.ValidateCode;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private User_AuthsService user_AuthsService;
	@Autowired
	private ValidateService validateService;
	@Autowired
	private UserService userService;
	@Autowired
	private BadgeService badgeService;
	@Autowired
	private OriginalService originalService;

	@RequestMapping("/loginPage")
	public String loginPage() throws Exception {

		// 转发到登录的页面
		return "/WEB-INF/login.jsp";
	}

	//根据用户id查找原始数据列表
	@RequestMapping("/findOriginalListclient")
	public  @ResponseBody JSONObject findOriginalListclient(String uid) throws Exception {
		 JSONObject json = new JSONObject();
		
		 try {
			List<Original> list = originalService.findOriginalByUser_id(uid);
			json.put("result", 1);
			json.put("list", list);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		json.put("result", -1);
		json.put("message",e.getMessage());
		return json;
		}
		 
		 	
	
	}
	//删除原始数据列表
	@RequestMapping("/deleteOriginal")
	public   ModelAndView deleteOriginal(Integer id) throws Exception {
		
		originalService.deleteOriginal(id);
		
		 ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/user/findOriginallist.action");
			return modelAndView;
	}
	//分页显示原始数据列表
	@RequestMapping("/findOriginallist")
	public   ModelAndView findOriginallist(OriginalCustom originalCustom,Integer pageNo, Integer pageSize) throws Exception {
		OriginalQueryVo originalQueryVo = new OriginalQueryVo();
		originalQueryVo.setOriginalCustom(originalCustom);
		PageInfo<OriginalCustom> queryByPage = originalService.queryByPage(originalQueryVo, pageNo, pageSize);
		 
		 
		 ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("queryByPage", queryByPage);
			modelAndView.addObject("nickname", originalCustom.getNickname());
			modelAndView.setViewName("/WEB-INF/admin/Originallist.jsp");

			return modelAndView;
	}
	
	
	//用户上传原始数据
	@RequestMapping("/insertOriginaltclient")
	public  @ResponseBody JSONObject insertOriginaltclient(Original original) throws Exception {
		 JSONObject json = new JSONObject();
		
		 original.setCreate_time(current_time());
		 originalService.insertOriginal(original);
		 
		 json.put("result", 1);
		json.put("message","添加成功");
		return json;
		 
		 	
	
	}
	//上传头像
	@RequestMapping("/ResultuploadPhoneclient")
	public @ResponseBody JSONObject ResultuploadPhoneclient(
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,String uid)
			throws Exception {
		JSONObject json = new JSONObject();
		if(uid==null) {
			
			json.put("result", -1);
			json.put("message", "未接收到用户id");
			return json;
		}
		User user=null;
		try {
			user = userService.findUserByid(uid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			json.put("result", -1);
			json.put("message", "未找到该用户");
			return json;
		}
		if(file==null) {
			
			json.put("result", -1);
			json.put("message", "文件为空");
			return json;
			
		}
		String path;
		try {
			path = uploadFile(file, request);
			File oldfile = new File("C:"+user.getPhotourl());
			if (oldfile.exists() && oldfile.isFile()){
				oldfile.delete();
			}
		} catch (IOException e) {
			json.put("result", -1);
			json.put("message", "上传失败，IO异常");

			return json;
		}
		user.setPhotourl(path.substring(2, path.length()));
		try {
			
			userService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("result", -1);
			json.put("message", "修改失败");

			return json;
		}
		json.put("result", 1);
		json.put("path", path);
		json.put("message", "上传成功");

		
		
		
		return json;

	}

	private String uploadFile(MultipartFile file, HttpServletRequest request)

			throws IOException {

		String path="C:\\resources\\fileUpload\\images\\"+current_time_day()+"\\";//路径
		String newFileName=UUID.randomUUID().toString()+file.getOriginalFilename();//文件新名称  uuid+文件原名称
		File targetFile  =new File(path,newFileName);    
		//如果文件夹不存在则创建    
		if  (!targetFile  .exists()  && !targetFile  .isDirectory())      
		{       
		    System.out.println("//不存在");  
		     //file .mkdir();  //只能创建单个目录
		    targetFile .mkdirs();// 创建多级目录
		}   
				file.transferTo(targetFile);//将内存中的数据写入
				
				return targetFile.getAbsolutePath();
						
	
		
	
	}
	
	
	
	//分页查找用户列表
	@RequestMapping("/finduserlist")
	public ModelAndView finduserlist(User_AuthsCustom user_AuthsCustom,Integer pageNo, Integer pageSize) throws Exception {

		PageInfo<User_AuthsCustom> queryByPage = user_AuthsService.queryByPage(user_AuthsCustom,pageNo, pageSize);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("queryByPage", queryByPage);
		modelAndView.addObject("user", user_AuthsCustom);
		
		modelAndView.setViewName("/WEB-INF/admin/userlist.jsp");

		return modelAndView;
	}
	
	
	
	
	
//更具用户id查找徽章list
	@RequestMapping("/findBadgeByUser_idclient")
	public @ResponseBody JSONObject findBadgeByUser_idclient(String user_id) throws Exception {
		JSONObject json = new JSONObject();
		try {
			List<Badge> list = badgeService.findBadgeByUser_id(user_id);
			json.put("result", 1);
			json.put("list", list);
			return json;
		} catch (Exception e) {

			json.put("result", -1);
			json.put("message", "您没有获得徽章");
			return json;
		}


	}
	private static String current_time_day() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
	//修改用户基本信息
	@RequestMapping("/updateUserclient")
	public @ResponseBody JSONObject updateUserclient(User user ,String uid) throws Exception {
		
		JSONObject json = new JSONObject();
		
		
		try {
			User userByid = userService.findUserByid(uid);
			user.setLevel(userByid.getLevel());
			user.setRegist_time(userByid.getRegist_time());
			user.setPurview(userByid.getPurview());
			user.setPhotourl(userByid.getPhotourl());
			userService.updateUser(user);
			json.put("result",1);
			json.put("message","修改个人信息成功");
			json.put("user",userService.findUserByid(uid));
			return json;
			
		} catch (Exception e) {
			json.put("result",-1);
			json.put("message", e.getMessage());
			return json;
		}
		
		
		
		
	}
	//添加用户徽章
	@RequestMapping("/insertBadgeclient")
	public @ResponseBody JSONObject insertBadgeclient(String name,String  content,String user_id) throws Exception {
		JSONObject json = new JSONObject();
		Badge badge = new Badge();
		badge.setContent(content);
		badge.setName(name);
		badge.setUser_id(user_id);
		badge.setCreate_time(current_time());
		badgeService.insertBadge(badge);
		
		json.put("result", 1);
		json.put("message", "恭喜您获得新的徽章");
		return json;
		
	
	}
//修改密码
	@RequestMapping("/changePasswordclient")
	public @ResponseBody JSONObject changePasswordclient(Integer id, String oldPassword, String newPassword)
			throws Exception {

		JSONObject json = new JSONObject();

		User_Auths user_Auths;
		try {
			user_Auths = user_AuthsService.findUser_AuthsByid(id);
			if (user_Auths.getCredential().equals(MD5Tools.MD5(oldPassword))) {

				user_Auths.setCredential(MD5Tools.MD5(newPassword));
				user_AuthsService.updateUser_Auths(user_Auths);
				json.put("result", 1);
				json.put("message", "修改密码成功");
				return json;
			}

			json.put("result", -1);
			json.put("message", "旧密码输入错误");
			return json;
		} catch (Exception e) {
			json.put("result", -1);
			json.put("message", "数据错误");
			return json;
		}

	}
//客户端登录
	@RequestMapping("/loginclient")
	public @ResponseBody JSONObject loginclient(User_AuthsCustom user_AuthsCustom) throws Exception {

		JSONObject json = new JSONObject();
		User_Auths user_Auths = user_AuthsService.findUser_AuthsByIdentifier(user_AuthsCustom.getIdentifier());

		if (user_Auths.getIdentity_type().equals(user_AuthsCustom.getIdentity_type())) {

			if ((MD5Tools.MD5(user_AuthsCustom.getCredential())).equals(user_Auths.getCredential())) {

				User_Auths user_Auths2 = user_AuthsService.findUser_AuthsUserLazyLoading(user_Auths.getId());
				json.put("result", 1);
				json.put("message", "登陆成功");
				json.put("user", user_Auths2);
				return json;
			}
			json.put("result", -1);
			json.put("message", "密码错误");
			return json;
		}
		json.put("result", -1);
		json.put("message", "登陆类型不匹配");
		return json;

	}
//查找用户名是否可用
	@RequestMapping("/findUsernameclient")
	public @ResponseBody JSONObject findUsernameclient(String username) throws Exception {
		JSONObject json = new JSONObject();
		try {
			User_Auths u = user_AuthsService.findUser_AuthsByIdentifier(username);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			json.put("result", 1);
			json.put("message", "可以使用该账号");
			return json;
		}

		json.put("result", -1);
		json.put("message", "该账号已被注册");

		return json;
	}

	private String current_time() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
	private String current_time1() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
	/*
	 * 注册发送验证码
	 */
	@RequestMapping("/SendValidateCodeByphonenumclient")
	public @ResponseBody JSONObject SendValidateCodeByphonenumclient(String phonenum) throws Exception {
		JSONObject json = new JSONObject();

		try {
			User_Auths user_Auths = user_AuthsService.findUser_AuthsByPhonenum(phonenum);
			json.put("result", -1);
			json.put("message", "该号码已被注册");
			return json;
		} catch (Exception e) {
			String code = ValidateCode.createCode(4);// 生成一个四位随机码
			int result_code = SendTelMessage.SMSsend(code, phonenum);// 将该nub发送到该phone上，返回发送结果result 1为成功发送 -1 为发送失败

			if (result_code == 1) {
				Validate validate = new Validate();
				validate.setPhonenum(phonenum);
				validate.setValidateCode(code);
				validate.setCreate_time(current_time());
				validateService.insertValidate(validate);

				json.put("result", 1);
				json.put("message", "验证码已成功发送到您的手机");
				return json;
			} else {
				json.put("result", 0);
				json.put("message", "服务器忙");
				return json;
			}
		}

	}

	// 忘记密码发送短信
	@RequestMapping("/LossPasswordSendValidateCodeclient")
	public @ResponseBody JSONObject LossPasswordSendValidateCodeclient(String phonenum) throws Exception {

		JSONObject json = new JSONObject();
		try {
			User_Auths user_Auths = user_AuthsService.findUser_AuthsByPhonenum(phonenum);
			String code = ValidateCode.createCode(4);// 生成一个四位随机码
			int result_code = SendTelMessage.SMSsend(code, phonenum);// 将该nub发送到该phone上，返回发送结果result 1为成功发送 -1 为发送失败

			if (result_code == 1) {
				Validate validate = new Validate();
				validate.setPhonenum(phonenum);
				validate.setValidateCode(code);
				validate.setCreate_time(current_time());
				validateService.insertValidate(validate);
				json.put("id", user_Auths.getId());
				json.put("result", 1);
				json.put("message", "验证码已成功发送到您的手机");
				return json;
			} else {
				json.put("result", 0);
				json.put("message", "服务器忙");
				return json;
			}
		} catch (Exception e) {
			json.put("result", -1);
			json.put("message", "该手机号码未注册");
			return json;
		}

	}

	// 忘记密码后验证并修改
	@RequestMapping("/LossPassChangeclient")
	public @ResponseBody JSONObject LossPassChangeclient(Integer id, String newPassword, String phonenum, String code)
			throws Exception {

		JSONObject json = new JSONObject();

		User_Auths user_Auths;
		try {

			user_Auths = user_AuthsService.findUser_AuthsByid(id);
		} catch (Exception e1) {
			json.put("result", -1);
			json.put("message", "找不到该用户");
			return json;
		}

		try {
			Validate validate = validateService.findValidateByPhonenum(phonenum);
			if (validate.getValidateCode().equals(code) && user_Auths.getPhonenum().equals(phonenum)) {
				user_Auths.setId(id);
				user_Auths.setCredential(MD5Tools.MD5(newPassword));
				user_AuthsService.updateUser_Auths(user_Auths);
				json.put("result", 1);
				json.put("message", "修改成功");
				return json;

			}
			json.put("result", -1);
			json.put("message", "验证码错误");
			return json;

		} catch (Exception e) {
			json.put("result", -1);
			json.put("message", "验证码有误");
			return json;
		}

	}

	// 注册 验证手机号码
	@RequestMapping("/registerUserclient")
	public @ResponseBody JSONObject registerUserclient(String username, String password, String phonenum, String code)
			throws Exception {

		JSONObject json = new JSONObject();
		try {
			User_Auths u = user_AuthsService.findUser_AuthsByIdentifier(username);
		} catch (Exception e) {
			try {
				Validate validate = validateService.findValidateByPhonenum(phonenum);
				if (validate.getValidateCode().equals(code)) {
					String uid = UUID.randomUUID().toString();
					User user = new User();
					user.setPurview(0);
					user.setNickname("把时间停留片刻");
					user.setRegist_time(current_time());
					user.setUid(uid);
					userService.insertUser(user);
					User_Auths user_Auths = new User_Auths();
					user_Auths.setUser_id(uid);
					user_Auths.setIdentity_type("account");
					user_Auths.setIdentifier(username);
					user_Auths.setCredential(MD5Tools.MD5(password));
					user_Auths.setPhonenum(phonenum);
					user_AuthsService.insertUser_Auths(user_Auths);
					json.put("result", 1);
					json.put("message", "注册成功，请立即登录");
					return json;
				}
				json.put("result", -1);
				json.put("message", "验证码错误");
				return json;

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				json.put("result", -1);
				json.put("message", "验证码有误");
				return json;
			}
		}

		json.put("result", -1);
		json.put("message", "该账号已被注册");

		return json;

	}

	@RequestMapping("/login")
	public String login(HttpSession session, User_AuthsCustom user_AuthsCustom) throws Exception {

		User_Auths user_Auths;
			user_Auths = user_AuthsService.findUser_AuthsByIdentifier(user_AuthsCustom.getIdentifier());
			
			
			
		
		
		
		if (user_Auths.getIdentity_type().equals(user_AuthsCustom.getIdentity_type())) {

			if ((MD5Tools.MD5(user_AuthsCustom.getCredential())).equals(user_Auths.getCredential())) {
				User user = userService.findUserByid(user_Auths.getUser_id());
				if(user.getPurview()!=1) {
					
					throw new SpinningException("权限不足");
				}
				User_Auths user_Auths2 = user_AuthsService.findUser_AuthsUserLazyLoading(user_Auths.getId());
				session.setAttribute("user", user_Auths2);
				return "/WEB-INF/admin/index.jsp";
			}
			throw new SpinningException("密码错误");
		}
		throw new SpinningException("登录类型不匹配");
		
		
	}

	// 退出
	@RequestMapping("/loginout")
	public String loginout(HttpSession session) throws Exception {

		session.invalidate();// session过期
		return "/WEB-INF/login.jsp";
	}

	
//删除用户的登录信息表
	@RequestMapping("/deleteUser_Auths")
	public ModelAndView deleteUser_Auths(Integer id) throws Exception {

		user_AuthsService.deleteUser_Auths(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/user/finduserlist.action");

		return modelAndView;

	}

}
