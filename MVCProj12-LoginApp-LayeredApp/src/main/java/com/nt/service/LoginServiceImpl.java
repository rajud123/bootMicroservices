package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.LoginBO;
import com.nt.dao.ILoginDAO;
import com.nt.dto.LoginDTO;
@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
private ILoginDAO dao;
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public String login(LoginDTO dto) {
		String msg=null;
		LoginBO bo=new LoginBO();
		//copy properties from dto to bo
		BeanUtils.copyProperties(dto, bo);
		//use dao
		msg=dao.login(bo);
		return msg;
	}

}
