package com.femtoapp.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.T_Activity;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.pojo.T_ActivityQueryVo;
import com.femtoapp.service.T_ActivityService;


public class T_ActivityTest {
	@Test
	public void findT_ActivityById() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		T_ActivityService service = ac.getBean(T_ActivityService.class);
		T_Activity T_Activity = service.findT_ActivityByid(1);
		System.out.println(T_Activity);
	}
	
	

	@Test
	public void insertT_Activity() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		T_ActivityService service = ac.getBean(T_ActivityService.class);
		T_Activity t_Activity = new T_Activity();
		t_Activity.setAid(1);
		t_Activity.setCreate_time("2017-11-25 21:02");
		t_Activity.setUser_id("1");
		for (int i = 0; i < 10; i++) {
			service.insertT_Activity(t_Activity);
		}
		
	}

	@Test
	public void updateT_Activity() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		T_ActivityService service = ac.getBean(T_ActivityService.class);
		T_Activity t_Activity = new T_Activity();
		t_Activity.setAid(79);
		t_Activity.setCreate_time("2017-11-25 21:03");
		t_Activity.setUser_id("79");
		t_Activity.setContent("123a°¢Èý");
		service.updateT_Activity(t_Activity);
	}

	@Test
	public void findT_Activitylist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		T_ActivityService service = ac.getBean(T_ActivityService.class);
		T_ActivityQueryVo uqv=new T_ActivityQueryVo();
		T_ActivityCustom uc=new T_ActivityCustom();
		uqv.setT_ActivityCustom(uc);
		List<T_ActivityCustom> findT_ActivityList = service.findT_ActivityList(null);
		System.out.println(findT_ActivityList);

	}
}
