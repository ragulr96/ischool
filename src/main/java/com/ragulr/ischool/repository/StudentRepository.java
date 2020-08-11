package com.ragulr.ischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragulr.ischool.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	Student findByFirstName(String firstName); // find student details by firstName
}
