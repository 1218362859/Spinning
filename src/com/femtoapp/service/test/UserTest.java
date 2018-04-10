package com.femtoapp.service.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.User;
import com.femtoapp.pojo.UserCustom;
import com.femtoapp.pojo.UserQueryVo;
import com.femtoapp.service.UserService;


public class UserTest {
	@Test
	public void findUserById() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		UserService service = ac.getBean(UserService.class);
		User user = service.findUserByid("1");
		System.out.println(user);
	}
	
	

	@Test
	public void insertUser() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		UserService service = ac.getBean(UserService.class);
		User user = new User();
		user.setUid(UUID.randomUUID().toString());
		user.setNickname("张三12345");
		service.insertUser(user);
	}

	@Test
	public void updateUser() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		UserService service = ac.getBean(UserService.class);
		User user = new User();
		user.setUid("1");
		user.setNickname("张三11");
		service.updateUser(user);
	}

	@Test
	public void findUserlist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		UserService service = ac.getBean(UserService.class);
		UserQueryVo uqv=new UserQueryVo();
		UserCustom uc=new UserCustom();
		uqv.setUserCustom(uc);
		List<UserCustom> findUserList = service.findUserList(null);
		System.out.println(findUserList);

	}
}
