package com.xpo.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpo.app.model.ToDo;
import com.xpo.app.service.IToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

	private static final Logger logger = LogManager.getLogger(ToDoController.class);
	private final IToDoService todoService;
	
	public ToDoController(IToDoService todoService) {
		super();
		logger.debug("In the constructor");
		this.todoService = todoService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "get", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<ToDo> getTodoList() throws SQLException {
		return todoService.getToDoList();
	}
	@CrossOrigin
	@RequestMapping(value = "/add", produces = {"application/JSON"}, method = RequestMethod.POST)
	public boolean addTodoList(@RequestBody ToDo todo) throws SQLException {
		logger.debug("title = " + todo.getTitle() + "\n boolean = " + todo.getIsChecked());
		return todoService.addToDo(todo);
	}
	@CrossOrigin
	@RequestMapping(value = "/update", produces = {"application/JSON"}, method = RequestMethod.PUT)
	public boolean updateTodoList(@RequestBody ToDo todo) throws SQLException {
		logger.debug("title = " + todo.getTitle() + "\n boolean = " + todo.getIsChecked());
		return todoService.updateTodo(todo);
	}	
	@CrossOrigin
	@RequestMapping(value = "/delete", produces = {"application/JSON"}, method = RequestMethod.DELETE)
	public int deleteTodo(String title) throws SQLException {
		logger.debug("title = " + title);
		return todoService.deleteToDo(title);
	}

}
