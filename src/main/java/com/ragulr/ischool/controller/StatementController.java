package com.ragulr.ischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ragulr.ischool.entity.Statement;
import com.ragulr.ischool.entity.Student;
import com.ragulr.ischool.service.StatementServiceImpl;

@RestController
public class StatementController {

	@Autowired
	private StatementServiceImpl statementService;

	/**
	 * Add new statement
	 * @param statement
	 * @return
	 */
	@PostMapping("/addStatement")
	public Statement addStatement(@RequestBody Statement statement) {
		return statementService.saveStatement(statement);
	}

	/**
	 * Get statement details
	 * @return
	 */
	@GetMapping("/statements")
	public List<Statement> findAllStatements() {
		return statementService.getStatements();
	}

	/**
	 * Get statement details by statementId
	 * @param id
	 * @return
	 */
	@GetMapping("/statementById/{id}")
	public Statement findStatementById(@PathVariable int id) {
		return statementService.getStatementById(id);
	}

	/**
	 * Get statement details by statementId and month
	 * @param id
	 * @param month
	 * @return
	 */
	@GetMapping("/statementByStudentMonth/{id}/{month}")
	public Statement findStatementByStudentMonth(@PathVariable Student id, @PathVariable String month) {
		return statementService.getStatementByStudentMonth(id, month);
	}

}
