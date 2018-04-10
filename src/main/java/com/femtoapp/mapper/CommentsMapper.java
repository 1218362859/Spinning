package com.femtoapp.mapper;

import java.util.List;

import com.femtoapp.pojo.Comments;
import com.femtoapp.pojo.CommentsCustom;
import com.femtoapp.pojo.CommentsQueryVo;


public interface CommentsMapper {

	
	public Comments findCommentsByid(Integer   id) throws Exception;
	public void insertComments(Comments comments) throws Exception;
	public List<CommentsCustom> findCommentsList(CommentsQueryVo commentsQueryVo) throws Exception;
	public void updateComments(Comments  comments) throws Exception;
	public void deleteComments(Integer id)throws Exception;
}
