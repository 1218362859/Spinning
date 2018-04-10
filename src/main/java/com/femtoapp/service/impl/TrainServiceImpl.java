package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.TrainMapper;
import com.femtoapp.mapper.UserMapper;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.pojo.Train;
import com.femtoapp.pojo.TrainCustom;
import com.femtoapp.pojo.TrainQueryVo;
import com.femtoapp.service.TrainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainMapper trainMapper;

	 
	public Train findTrainByid(Integer id) throws Exception {
		Train train = trainMapper.findTrainByid(id);
		if(train==null) {
			
			throw  new  SpinningException("没有找到");
		}
		return train;
	}

	 
	public void insertTrain(Train train) throws Exception {
		// TODO Auto-generated method stub
		trainMapper.insertTrain(train);
	}

	 
	public List<TrainCustom> findTrainList(TrainQueryVo trainQueryVo) throws Exception {
		List<TrainCustom> trainList = trainMapper.findTrainList(trainQueryVo);
		if (trainList != null && trainList.size() > 0) {
			return trainList;
		} else {
			throw new SpinningException("查找失败");
		}
	}

	 
	public void updateTrain(Train train) throws Exception {
		// TODO Auto-generated method stub
	try {
		trainMapper.updateTrain(train);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("修改部位训练表失败 ");
	}
	}

	 
	public void deleteTrain(Integer id) throws Exception {
		// TODO Auto-generated method stub
	try {
		trainMapper.deleteTrain(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("删除部位训练失败 ");
	}
	}

	 
	public PageInfo<TrainCustom> queryByPage(TrainQueryVo trainQueryVo, Integer pageNo, Integer pageSize) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<TrainCustom> list = trainMapper.findTrainList(trainQueryVo);
	    //用PageInfo对结果进行包装
	    PageInfo<TrainCustom> page = new PageInfo<TrainCustom>(list);
	    //測试PageInfo所有属性
	  
	    
	    
	    return page;
	}

	


}
