package com.ragulr.ischool.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragulr.ischool.entity.Statement;
import com.ragulr.ischool.entity.Student;
import com.ragulr.ischool.entity.Subject;
import com.ragulr.ischool.repository.StatementRepository;
import com.ragulr.ischool.repository.StudentRepository;

@Service
public class StatementServiceImpl implements StatementService {

	@Autowired
	private StatementRepository statementRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SecurityServiceImpl securityService;

	/**
	 * Add new statement
	 */
	@Override
	public Statement saveStatement(Statement statement) {

		int totalSubjectFee = getTotalSubjectFee(statement.getPaymentRecipient());

		String loggedUser = securityService.findLoggedInUsername();

		statement.setDateOfIssue(new Date());
		statement.setIssuedBy(loggedUser);
		statement.setTotalFee(statement.getSecurityFee() + statement.getAdmissionFee() + totalSubjectFee);

		return statementRepository.save(statement);
	}

	/**
	 * Get total subject fee
	 */
	@Override
	public int getTotalSubjectFee(Student student) {

		Student st = studentRepository.findById(student.getStudentId()).orElse(null);

		Set<Subject> subject = st.getSubjects();

		int subjectFee = 0;

		for (Subject sub : subject) {
			subjectFee += sub.getSubjectFee();
		}
		return subjectFee;
	}

	/**
	 * Get all statement details
	 */
	@Override
	public List<Statement> getStatements() {
		return statementRepository.findAll();
	}

	/**
	 * Get statement details by Id
	 */
	@Override
	public Statement getStatementById(int id) {
		return statementRepository.findById(id).orElse(null);
	}

	/**
	 * Get statement details by studentId and month
	 */
	@Override
	public Statement getStatementByStudentMonth(Student studentId, String month) {
		return statementRepository.findByPaymentRecipientAndStatementMonth(studentId, month);
	}

}
