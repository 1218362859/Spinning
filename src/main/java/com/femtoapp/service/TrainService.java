package com.femtoapp.service;

import java.util.List;

import com.femtoapp.pojo.Train;
import com.femtoapp.pojo.TrainCustom;
import com.femtoapp.pojo.TrainQueryVo;
import com.github.pagehelper.PageInfo;

public interface TrainService {
	public Train findTrainByid(Integer   id) throws Exception;
	public void insertTrain(Train train) throws Exception;
	public List<TrainCustom> findTrainList(TrainQueryVo trainQueryVo) throws Exception;
	public void updateTrain(Train train) throws Exception;
	public void deleteTrain(Integer id)throws Exception;
	public PageInfo<TrainCustom> queryByPage(TrainQueryVo trainQueryVo, Integer pageNo, Integer pageSize)throws Exception;
}
