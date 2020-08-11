package com.ragulr.ischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragulr.ischool.entity.Statement;
import com.ragulr.ischool.entity.Student;

public interface StatementRepository extends JpaRepository<Statement, Integer>{

	Statement findByPaymentRecipientAndStatementMonth(Student studentId, String month); // find payment details by studentId and month

}
