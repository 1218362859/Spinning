package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.CollectMapper;
import com.femtoapp.mapper.UserMapper;
import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;
import com.femtoapp.pojo.User;
import com.femtoapp.pojo.UserCustom;
import com.femtoapp.pojo.UserQueryVo;
import com.femtoapp.service.CollectService;
import com.femtoapp.service.UserService;

public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectMapper collectMapper;

	public Collect findCollectByid(Integer id) throws Exception {
		Collect collect = collectMapper.findCollectByid(id);
		
		if (collect == null) {

			throw new SpinningException("√ª”–’“µΩ");
		}
		return collect;
	}

	public void insertCollect(Collect collect) throws Exception {
		// TODO Auto-generated method stub
		try {
		collectMapper.insertCollect(collect);	} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SpinningException("ÃÌº” ’≤ÿ ß∞‹");
		}

	}

	public List<CollectCustom> findCollectList(CollectQueryVo collectQueryVo) throws Exception {
		List<CollectCustom> collectList = collectMapper.findCollectList(collectQueryVo);
		if (collectList != null && collectList.size() > 0) {
			return collectList;
		} else {
			throw new SpinningException("≤È’“ ß∞‹");
		}
	}

	public void updateCollect(Collect collect) throws Exception {
		// TODO Auto-generated method stub
		try {
		collectMapper.updateCollect(collect);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("–ﬁ∏ƒ ’≤ÿ ß∞‹");
	}

	}

	public void deleteCollect(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
		collectMapper.deleteCollect(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("…æ≥˝ ’≤ÿ ß∞‹");
	}
	}


}
