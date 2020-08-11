package com.ragulr.ischool.service;

import java.util.List;

import com.ragulr.ischool.entity.Student;

public interface StudentService {

	Student saveStudent(Student student); // add new student

	List<Student> saveStudents(List<Student> students); // add list of students

	List<Student> getStudents(); // get all students details

	Student getStudentById(int id); // get students details by studentID

	Student getStudentByFirstName(String firstName); // get students details by firstName

	String deleteStudent(int id); // remove a student

}
