package com.ragulr.ischool.service;

import java.util.List;

import com.ragulr.ischool.entity.Statement;
import com.ragulr.ischool.entity.Student;

public interface StatementService {

	Statement saveStatement(Statement statement); // add new statement
	
	int getTotalSubjectFee(Student student); // calculate total subject fee
	
	List<Statement> getStatements(); // get all statements
	
	Statement getStatementById(int id); // get statement by id
	
	Statement getStatementByStudentMonth(Student studentId, String month); // get statement by studentId and month
}
