package com.sms.service;

import java.util.List;

import com.sms.entity.Student_ent;
import com.sms.model.StudentDTO;

public interface Student_service {

//	for create new student
//	Student_ent createStudent(Student_ent student_ent);
	StudentDTO createStudent(Student_ent student_ent);

//	fetch all student data
//	List<Student_ent> getAllStudent();
	List<StudentDTO> getAllStudent();

//	fetch by id
//	Student_ent getStudentById(int id);
	StudentDTO getStudentById(int id);

//	update by id
//	Student_ent updateById(int id, Student_ent student_ent);
	StudentDTO updateById(int id, Student_ent student_ent);

//	delete by id
//	String deleteById(int id);
	String deleteById(int id);
}
