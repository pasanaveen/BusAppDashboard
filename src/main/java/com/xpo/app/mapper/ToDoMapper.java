package com.xpo.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xpo.app.model.ToDo;

public class ToDoMapper  implements RowMapper<ToDo> {

	@Override
	public ToDo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ToDo todo = new ToDo();
		
		todo.setTitle(rs.getString("TITLE"));
		todo.setIsChecked(rs.getBoolean("IS_CHECKED"));
		todo.setDueDate(rs.getDate("DUE_DATE"));
		todo.setUser(rs.getString("ASSIGNED_WHO"));
		todo.setPriority(rs.getBoolean("PRIORITY"));
		
		return todo;
	}
	
	

}
