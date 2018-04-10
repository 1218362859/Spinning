package com.femtoapp.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.OriginalCustom;
import com.femtoapp.pojo.OriginalQueryVo;
import com.femtoapp.service.OriginalService;


public class OriginalTest {
	@Test
	public void findUser_Authslist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		OriginalService service = ac.getBean(OriginalService.class);
		OriginalQueryVo uqv = new OriginalQueryVo();
		OriginalCustom uc = new OriginalCustom();
		uc.setNickname("ÀîËÄ");
		uqv.setOriginalCustom(uc);
		List<OriginalCustom> findOriginalList = service.findOriginalList(null);
		System.err.println(findOriginalList);

	}
}
