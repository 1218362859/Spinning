package com.femtoapp.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.Train;
import com.femtoapp.pojo.TrainCustom;
import com.femtoapp.pojo.TrainQueryVo;
import com.femtoapp.service.TrainService;

public class TrainTest {
	@Test
	public void findTrainById() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		TrainService service = ac.getBean(TrainService.class);
		Train Train = service.findTrainByid(1);
		System.out.println(Train);
	}

	@Test
	public void insertTrain() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		TrainService service = ac.getBean(TrainService.class);
		Train train = new Train();
		train.setUser_id("1");
		train.setSite(" ÷");
		service.insertTrain(train);
	}

	@Test
	public void updateTrain() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		TrainService service = ac.getBean(TrainService.class);
		Train train = new Train();
		train.setSite("Ω≈");
		train.setId(1);
		service.updateTrain(train);
	}

	@Test
	public void findTrainlist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		TrainService service = ac.getBean(TrainService.class);
		TrainQueryVo uqv = new TrainQueryVo();
		TrainCustom uc = new TrainCustom();
		uqv.setTrainCustom(uc);
		List<TrainCustom> findTrainList = service.findTrainList(null);
		System.out.println(findTrainList);

	}
}
