package com.ragulr.ischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ragulr.ischool.entity.Subject;
import com.ragulr.ischool.service.SubjectServiceImpl;

@RestController
public class SubjectController {
	
	@Autowired
	private SubjectServiceImpl subjectService;
	
	/**
	 * Add new Subject
	 * @param subject
	 * @return
	 */
	@PostMapping("/addSubject")
	public Subject addSubject(@RequestBody Subject subject) {
		return subjectService.saveSubject(subject);
	}

	/**
	 * Add list if subjects
	 * @param subjects
	 * @return
	 */
	@PostMapping("/addSubjects")
	public List<Subject> addSubjects(@RequestBody List<Subject> subjects) {
		return subjectService.saveSubjects(subjects);
	}

	/**
	 * Get subjects details
	 * @return
	 */
	@GetMapping("/subjects")
	public List<Subject> findAllSubjects() {
		return subjectService.getSubjects();
	}
	
	/**
	 * Get subject details by subjectId
	 * @param id
	 * @return
	 */
	@GetMapping("/subjectById/{id}")
	public Subject findSubjectById(@PathVariable int id) {
		return subjectService.getSubjectById(id);
	}
	
	/**
	 * Get subject details by subjectName
	 * @param subjectName
	 * @return
	 */
	@GetMapping("/subjectByName/{subjectName}")
	public Subject findSubjectByName(@PathVariable String subjectName) {
		return subjectService.getSubjectByName(subjectName);
	}
	
	/**
	 * Remove a subject
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteSubject/{id}")
	public String deleteSubject(@PathVariable int id) {
		return subjectService.deleteSubject(id);
	}


}
