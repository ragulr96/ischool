package com.ragulr.ischool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragulr.ischool.entity.Student;
import com.ragulr.ischool.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Add new student
	 */
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	/**
	 * Add list of new students
	 */
	@Override
	public List<Student> saveStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	/**
	 * Get all student details
	 */
	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	/**
	 * Get student details by studentId
	 */
	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}

	/**
	 * Get student details by firstName
	 */
	@Override
	public Student getStudentByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	/**
	 * Remove a student
	 */
	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student " + id + " deleted !";
	}

//	@Override
//	public Student updateStudent(Student student) {
//		Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
//		existingStudent.setFirstName(student.getFirstName());
//		existingStudent.setSecondName(student.getSecondName());
//		existingStudent.setAddress(student.getAddress());
//		existingStudent.setSubjects(student.getSubjects());
//		return studentRepository.save(existingStudent);
//	}
}
