package com.ragulr.ischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ragulr.ischool.entity.Student;
import com.ragulr.ischool.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	/**
	 * Add new Student
	 * @param student
	 * @return
	 */
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	/**
	 * Add list of students
	 * @param students
	 * @return
	 */
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studentService.saveStudents(students);
	}

	/**
	 * Get student details
	 * @return
	 */
	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return studentService.getStudents();
	}
	
	/**
	 * Get student details by student Id
	 * @param id
	 * @return
	 */
	@GetMapping("/studentById/{id}")
	public Student findStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	/**
	 * Get student details by firstName
	 * @param firstName
	 * @return
	 */
	@GetMapping("/studentByName/{firstName}")
	public Student findStudentByName(@PathVariable String firstName) {
		return studentService.getStudentByFirstName(firstName);
	}
	
	/**
	 * Remove a student
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
}
