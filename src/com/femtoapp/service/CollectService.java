package com.femtoapp.service;

import java.util.List;

import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;

public interface CollectService {

	
	public Collect findCollectByid(Integer   id) throws Exception;
	public void insertCollect(Collect collect) throws Exception;
	public List<CollectCustom> findCollectList(CollectQueryVo collectQueryVo) throws Exception;
	public void updateCollect(Collect collect) throws Exception;
	public void deleteCollect(Integer id)throws Exception;
}
