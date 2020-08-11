package com.ragulr.ischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragulr.ischool.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	Subject findBySubjectName(String subjectName); // find subject details by subjectName
	
}
