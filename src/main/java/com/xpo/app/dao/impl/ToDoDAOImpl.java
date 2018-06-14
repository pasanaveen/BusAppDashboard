package com.xpo.app.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xpo.app.dao.IToDoDAO;
import com.xpo.app.mapper.ToDoMapper;
import com.xpo.app.model.ToDo;

@Transactional
@Repository
public class ToDoDAOImpl implements IToDoDAO {
	
	private static final Logger logger = LogManager.getLogger(ToDoDAOImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public ToDoDAOImpl(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }
	
	String GET_TODO_SQL = "SELECT TITLE, IS_CHECKED, DUE_DATE, ASSIGNED_WHO, PRIORITY FROM dashboard.todo";
	String ADD_TODO_SQL = "INSERT INTO dashboard.todo (TITLE, IS_CHECKED, DUE_DATE, ASSIGNED_WHO, PRIORITY) VALUES (?, ?, ?, ?, ?)";
	String UPDATE_TODO_SQL = "UPDATE dashboard.todo SET TITLE = ?,IS_CHECKED = ?,DUE_DATE = ?,ASSIGNED_WHO = ?,PRIORITY = ? WHERE TITLE = ?";
	String DELETE_TODO_SQL = "DELETE FROM dashboard.todo WHERE TITLE = ?";
	
	@Override
	public List<ToDo> getToDoList() throws SQLException {
		RowMapper<ToDo> todoMapper = new ToDoMapper();
		return this.jdbcTemplate.query(GET_TODO_SQL, todoMapper);
	}

	@Override
	public boolean addToDo(ToDo todo) {
		int add = jdbcTemplate.update(ADD_TODO_SQL, todo.getTitle(), todo.getIsChecked(), todo.getDueDate(), todo.getUser(), todo.getPriority());
		
		if(add == 1) {
			//System.out.println("Created a To Do Record");
			logger.debug("Created a To Do Record");
			return true;
		} else {
			logger.error("Record not added");
			return false;
		}
	}

	@Override
	public boolean updateTodo(ToDo todo) {
		int add = jdbcTemplate.update(UPDATE_TODO_SQL, todo.getTitle(), todo.getIsChecked(), todo.getDueDate(), todo.getUser(), todo.getPriority(), todo.getTitle());
		
		if(add == 1) {
			
			logger.debug("Updated a To Do Record");
			return true;
		} else {
			logger.error("Record not updated");
			return false;
		}
	}

	@Override
	public int deleteToDo(String title) {
		Object[] params = { title };
		int[] types = {Types.VARCHAR};
		
		int rows = jdbcTemplate.update(DELETE_TODO_SQL, params, types);
		
		logger.debug("Rows Created = " + rows);
		return rows;
	}
}
