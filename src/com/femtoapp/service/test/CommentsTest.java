package com.femtoapp.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.femtoapp.pojo.Comments;
import com.femtoapp.pojo.CommentsCustom;
import com.femtoapp.pojo.CommentsQueryVo;
import com.femtoapp.service.CommentsService;


public class CommentsTest {
	@Test
	public void findCommentsById() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CommentsService service = ac.getBean(CommentsService.class);
		Comments comments = service.findCommentsByid(1);
		System.out.println(comments);
	}
	
	

	@Test
	public void insertComments() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CommentsService service = ac.getBean(CommentsService.class);
		Comments comments = new Comments();
		comments.setFrom_user("1");
		comments.setTime("2017-11-25 21:07");
		service.insertComments(comments);
	}

	@Test
	public void updateComments() throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CommentsService service = ac.getBean(CommentsService.class);
		Comments comments = new Comments();
		comments.setId(1);
		comments.setTime("2017-11-25 21:05");
		service.updateComments(comments);
	}

	@Test
	public void findCommentslist() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-transation.xml" });
		CommentsService service = ac.getBean(CommentsService.class);
		CommentsQueryVo uqv=new CommentsQueryVo();
		CommentsCustom uc=new CommentsCustom();
		uqv.setCommentsCustom(uc);
		List<CommentsCustom> findCommentsList = service.findCommentList(null);
		System.out.println(findCommentsList);

	}
}
