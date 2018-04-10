package com.femtoapp.mapper;

import java.util.List;

import com.femtoapp.pojo.Train;
import com.femtoapp.pojo.TrainCustom;
import com.femtoapp.pojo.TrainQueryVo;


public interface TrainMapper {

	
	public Train findTrainByid(Integer   id) throws Exception;
	public void insertTrain(Train train) throws Exception;
	public List<TrainCustom> findTrainList(TrainQueryVo trainQueryVo) throws Exception;
	public void updateTrain(Train train) throws Exception;
	public void deleteTrain(Integer id)throws Exception;
}
