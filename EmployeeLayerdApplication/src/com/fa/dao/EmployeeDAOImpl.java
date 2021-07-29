package com.fa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.fa.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_QUERY="INSERT INTO EMPLOYEE_LAYERD VALUES(EMP_SEQ.NEXTVAL,?,?,?,?)";
	private static final String DS_JNDI_NAME ="java:/comp/env/DsJndi";
	@Override	
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		con=polledJdbcConnection(DS_JNDI_NAME);
		ps=con.prepareStatement(INSERT_QUERY);
		ps.setString(1, bo.getEname());
		ps.setString(2, bo.getEadd());
		ps.setString(3, bo.getDept());
		ps.setFloat(4, bo.getSalary());
		count=ps.executeUpdate();
		return count;
	}
	private Connection polledJdbcConnection(String jndi)throws Exception {
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		ic=new InitialContext();
		ds=(DataSource)ic.lookup(jndi);
		con=ds.getConnection();
		return con;
	}

}
