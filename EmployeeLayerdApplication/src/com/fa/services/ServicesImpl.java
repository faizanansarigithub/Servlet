package com.fa.services;

import com.fa.bo.EmployeeBO;
import com.fa.dao.EmployeeDAO;
import com.fa.dao.EmployeeDAOImpl;
import com.fa.dto.EmployeeDTO;

public class ServicesImpl implements Services {
	private EmployeeDAO dao;
	public ServicesImpl() {
		dao=new EmployeeDAOImpl();
	}
	@Override
	public String register(EmployeeDTO dto) throws Exception {
		EmployeeBO bo=null;
		String result =null;
		bo=new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setEadd(dto.getEadd());
		bo.setDept(dto.getDept());
		bo.setSalary(dto.getSalary());
		int count=dao.insert(bo);
		if(count==0)
			result="registeration not successfully";
		else
			result="registeration successfully";
		
		return result;
	}

}
