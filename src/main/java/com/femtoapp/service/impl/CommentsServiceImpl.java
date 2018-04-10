package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.CommentsMapper;
import com.femtoapp.pojo.CommentsCustom;
import com.femtoapp.pojo.Comments;
import com.femtoapp.pojo.CommentsCustom;
import com.femtoapp.pojo.CommentsQueryVo;
import com.femtoapp.service.CommentsService;

public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsMapper  commentsMapper;

	 
	public Comments findCommentsByid(Integer id) throws Exception {

		Comments comments = commentsMapper.findCommentsByid(id);
		
		if(comments==null) {
			
			throw new SpinningException("√ª”–’“µΩ");
		}
		return comments;
	}

	 
	public void insertComments(Comments comments) throws Exception {
		// TODO Auto-generated method stub
		commentsMapper.insertComments(comments);
	}

	 
	public List<CommentsCustom> findCommentList(CommentsQueryVo commentsQueryVo) throws Exception {
		List<CommentsCustom> commentsList = commentsMapper.findCommentsList(commentsQueryVo);
		if (commentsList != null && commentsList.size() > 0) {
			return commentsList;
		} else {
			throw new SpinningException("≤È’“ ß∞‹");
		}
	}

	 
	public void updateComments(Comments comments) throws Exception {
		// TODO Auto-generated method stub
		try{
		commentsMapper.updateComments(comments);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("–ﬁ∏ƒ∆¿¬€ ß∞‹");
	}
	}

	 
	public void deleteComments(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
		commentsMapper.deleteComments(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("…æ≥˝∆¿¬€ ß∞‹");
	}
	}



}
