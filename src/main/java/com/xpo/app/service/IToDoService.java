package com.xpo.app.service;

import java.sql.SQLException;
import java.util.List;

import com.xpo.app.model.ToDo;

public interface IToDoService {
	
	List<ToDo> getToDoList() throws SQLException;
	boolean addToDo(ToDo todo);
    boolean updateTodo(ToDo todo);
    int deleteToDo(String title);
}
