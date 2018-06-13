package com.xpo.app.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpo.app.dao.IToDoDAO;
import com.xpo.app.model.ToDo;

@Service
public class ToDoService implements IToDoService {
	
	@Autowired
	private IToDoDAO todoDAO;
	
	@Override
	public List<ToDo> getToDoList() throws SQLException {
		return todoDAO.getToDoList();
	}

	@Override
	public boolean addToDo(ToDo todo) {
		return todoDAO.addToDo(todo);
	}

	@Override
	public boolean updateTodo(ToDo todo) {
		return todoDAO.updateTodo(todo);		
	}

	@Override
	public int deleteToDo(String title) {
		return todoDAO.deleteToDo(title);		
	}

}
