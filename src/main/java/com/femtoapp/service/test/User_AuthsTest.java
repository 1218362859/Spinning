package com.femtoapp.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.femtoapp.pojo.User_Auths;
import com.femtoapp.pojo.User_AuthsCustom;
import com.femtoapp.pojo.User_AuthsQueryVo;
import com.femtoapp.service.User_AuthsService;
import com.github.pagehelper.PageInfo;

public class User_AuthsTest {
	@Test
	public void findUser_AuthsById() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		User_AuthsService service = ac.getBean(User_AuthsService.class);
		User_Auths user_Auths = service.findUser_AuthsByid(1);
		System.out.println(user_Auths);
	}

	@Test
	public void insertUser_Auths() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		User_AuthsService service = ac.getBean(User_AuthsService.class);
		User_Auths user_Auths = new User_Auths();
		user_Auths.setUser_id("1");
		for (int i = 0; i < 5; i++) {
			service.insertUser_Auths(user_Auths);
		}
		
	}
	

	@Test
	public void updateUser_Auths() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		User_AuthsService service = ac.getBean(User_AuthsService.class);
		User_Auths user_Auths = new User_Auths();
		user_Auths.setId(1);
		user_Auths.setUser_id("1");
			
		service.updateUser_Auths(user_Auths);
	}

	@Test
	public void findUser_Authslist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		User_AuthsService service = ac.getBean(User_AuthsService.class);
		User_AuthsQueryVo uqv = new User_AuthsQueryVo();
		User_AuthsCustom uc = new User_AuthsCustom();
		uqv.setUser_AuthsCustom(uc);
		List<User_AuthsCustom> findUser_AuthsList = service.findUser_AuthsList(null);
		System.err.println(findUser_AuthsList);

	}

	
	
	@Test
	public void findUser_AuthsUserLazyLoading() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		User_AuthsService service = ac.getBean(User_AuthsService.class);
		User_Auths user_Auths = service.findUser_AuthsUserLazyLoading(2);
		System.out.println(user_Auths.getId() + user_Auths.getIdentifier());

	}

	@Test
	public void queryByPageTest() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		User_AuthsService service = ac.getBean(User_AuthsService.class);
		
		
		PageInfo<User_AuthsCustom> page = service.queryByPage( null,1, 10);

		

	}
}
