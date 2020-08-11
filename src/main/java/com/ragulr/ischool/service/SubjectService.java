package com.ragulr.ischool.service;

import java.util.List;

import com.ragulr.ischool.entity.Subject;

public interface SubjectService {

	Subject saveSubject(Subject subject); // add new subject

	List<Subject> saveSubjects(List<Subject> subjects); // add list of subjects

	List<Subject> getSubjects(); // get all subject details

	Subject getSubjectById(int id); // get subject details by subjectID

	Subject getSubjectByName(String subjectName); // get subject details by subjectName

	String deleteSubject(int id); // remove a subject

}
