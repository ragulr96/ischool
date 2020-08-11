package com.ragulr.ischool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragulr.ischool.entity.Subject;
import com.ragulr.ischool.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	/**
	 * Add new subject
	 */
	@Override
	public Subject saveSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	/**
	 * Add list of new subjects
	 */
	@Override
	public List<Subject> saveSubjects(List<Subject> subjects) {
		return subjectRepository.saveAll(subjects);
	}
	
	/**
	 * Get all subject details
	 */
	@Override
	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}

	/**
	 * Get subject details by Id
	 */
	@Override
	public Subject getSubjectById(int id) {
		return subjectRepository.findById(id).orElse(null);
	}

	/**
	 * Get subject details by sujectName
	 */
	@Override
	public Subject getSubjectByName(String subjectName) {
		return subjectRepository.findBySubjectName(subjectName);
	}
	
	/**
	 * Remove a subject
	 */
	@Override
	public String deleteSubject(int id) {
		subjectRepository.deleteById(id);
		return "Subject " + id + " deleted !";
	}
}
