package com.femtoapp.service.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;
import com.femtoapp.pojo.Validate;
import com.femtoapp.service.CollectService;
import com.femtoapp.service.ValidateService;


public class ValidateTest {
	@Test
	public void findValidateByPhonenum() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		ValidateService service = ac.getBean(ValidateService.class);
		Validate validate = service.findValidateByPhonenum("18379607713");
		System.err.println(validate);
	}
	private String current_time() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}
	

	@Test
	public void insertValidate() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		ValidateService service = ac.getBean(ValidateService.class);
		Validate validate = new Validate();
		validate.setPhonenum("18379607713");
		validate.setValidateCode("1234");
		validate.setCreate_time(current_time());
		service.insertValidate(validate);
	}
	
	
	
	
}
