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
import com.femtoapp.pojo.Badge;
import com.femtoapp.service.CollectService;
import com.femtoapp.service.BadgeService;

public class BadgeTest {
	@Test
	public void findBadgeByUser_id() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		BadgeService service = ac.getBean(BadgeService.class);
		List<Badge> list = service.findBadgeByUser_id("1");
		System.err.println(list);
	}

	private String current_time() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateNowStr = sdf.format(d);

		return dateNowStr;
	}

	@Test
	public void insertBadge() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-dao.xml",
				"applicationContext-service.xml", "applicationContext-transation.xml" });
		BadgeService service = ac.getBean(BadgeService.class);
		Badge badge = new Badge();
		badge.setName("12");
		badge.setContent("123");
		badge.setUser_id("1");
		badge.setCreate_time(current_time());
		service.insertBadge(badge);
	}

}
