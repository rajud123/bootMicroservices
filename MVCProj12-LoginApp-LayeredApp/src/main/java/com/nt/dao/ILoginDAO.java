package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.nt.bo.LoginBO;

public interface ILoginDAO {
	public String login(LoginBO bo);
}
