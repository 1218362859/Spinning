package com.femtoapp.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;
import com.femtoapp.service.CollectService;


public class CollectTest {
	@Test
	public void findCollectById() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CollectService service = ac.getBean(CollectService.class);
		Collect collect = service.findCollectByid(1);
		System.out.println(collect);
	}
	
	

	@Test
	public void insertCollect() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CollectService service = ac.getBean(CollectService.class);
		Collect collect = new Collect();
		collect.setAid(1);
		collect.setCreate_time("2017-11-25 21:02");
		collect.setUser_id("1");
		service.insertCollect(collect);
	}

	@Test
	public void updateCollect() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CollectService service = ac.getBean(CollectService.class);
		Collect collect = new Collect();
		collect.setAid(1);
		collect.setCreate_time("2017-11-25 21:03");
		collect.setUser_id("1");
		collect.setId(1);
		service.updateCollect(collect);
	}

	@Test
	public void findCollectlist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CollectService service = ac.getBean(CollectService.class);
		CollectQueryVo uqv=new CollectQueryVo();
		CollectCustom uc=new CollectCustom();
		uqv.setCollectCustom(uc);
		List<CollectCustom> findCollectList = service.findCollectList(null);
		System.out.println(findCollectList);

	}
}
