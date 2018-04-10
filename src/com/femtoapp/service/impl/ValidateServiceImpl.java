package com.femtoapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.ValidateMapper;
import com.femtoapp.pojo.Validate;
import com.femtoapp.service.ValidateService;

public class ValidateServiceImpl  implements ValidateService {

	@Autowired
	private ValidateMapper validateMapper;
	 
	public Validate findValidateByPhonenum(String phonenum) throws Exception {
		// TODO Auto-generated method stub
		Validate validate = validateMapper.findValidateByPhonenum(phonenum);
		
		if(validate==null) {
			throw new SpinningException("验证码有误，请重新输入");
		}
		
		return validate;
	}

	 
	public void insertValidate(Validate validate) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			validateMapper.insertValidate(validate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SpinningException("验证码发送错误");
		}
	}

}
