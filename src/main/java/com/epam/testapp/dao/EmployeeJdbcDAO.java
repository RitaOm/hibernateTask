package com.epam.testapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epam.testapp.bean.Employee;

public class EmployeeJdbcDAO implements IEmployeeDAO {

	private DataSource dataSource;
	
	@Override
	public List<Employee> getEmployeeList(int firstResult, int resultsPerPage)
			throws SQLException {
		Connection connection = dataSource.getConnection();
		List<Employee> list;
		try (Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery("");
			list = parseResultSet(rs);
		} finally {
			connection.close();
		}
		return list;
	}

	private ArrayList<Employee> parseResultSet(ResultSet rs) throws SQLException {
		ArrayList<Employee> result = new ArrayList<Employee>();
		while (rs.next()) {
				
			}
		return result;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
}
