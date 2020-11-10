package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.LoginBO;
@Repository
public class LoginDAOImpl implements ILoginDAO {
	@Autowired
private SimpleJdbcCall sjc;
	@Override
	public String login(LoginBO bo) {
		//set procedure name
		sjc.setProcedureName("p_authentication");
		//prepare Map object having IN param names and values
		Map<String,Object> inParams=Map.of("pname",bo.getUname(), "pwd", bo.getPassword());
		//call PL/SQL procedure get the outparam name and value
		Map<String, Object> outParams=sjc.execute(inParams);
		//get result from OUT paaram
		return (String) outParams.get("result");
	}

}
