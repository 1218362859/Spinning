package com.femtoapp.service;

import java.util.List;
import com.femtoapp.pojo.Comments;
import com.femtoapp.pojo.CommentsCustom;
import com.femtoapp.pojo.CommentsQueryVo;

public interface CommentsService {

	
	public Comments findCommentsByid(Integer   id) throws Exception;
	public void insertComments(Comments comments) throws Exception;
	public List<CommentsCustom> findCommentList(CommentsQueryVo commentsQueryVo) throws Exception;
	public void updateComments(Comments  comments) throws Exception;
	public void deleteComments(Integer id)throws Exception;
}
