package com.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Student_ent;
import com.sms.model.StudentDTO;
import com.sms.service.Student_service;
import com.sms.utility.Converter;

@RestController
@RequestMapping("/api")
public class Student_control {

	@Autowired
	private Student_service studentSerive;

	@Autowired
	private Converter converter;

//	---------------------------------------------------------------------------------------------------------------------------------

//	@PostMapping("/createstudent")
//	ResponseEntity<Student_ent> ceateStudent(@RequestBody Student_ent student_ent) {
//		return new ResponseEntity<Student_ent>(studentSerive.createStudent(student_ent), HttpStatus.CREATED);
//	}

	@PostMapping("/createstudent")
	ResponseEntity<StudentDTO> ceateStudent(@Valid @RequestBody StudentDTO studentDTO) {

		final Student_ent student_ent = converter.convertToEntity(studentDTO);
		return new ResponseEntity<StudentDTO>(studentSerive.createStudent(student_ent), HttpStatus.CREATED);
	}

//	---------------------------------------------------------------------------------------------------------------------------------

//	@GetMapping("/getallstudents")
//	List<Student_ent> getAllStudent() {
//		return studentSerive.getAllStudent();
//
//	}

	@GetMapping("/getallstudents")
	List<StudentDTO> getAllStudent() {
		return studentSerive.getAllStudent();

	}

//	---------------------------------------------------------------------------------------------------------------------------------

//	@GetMapping("/getbyid/{s_id}")
//	Student_ent getStudentById(@PathVariable("s_id") int id) {
//		return studentSerive.getStudentById(id);
//	}

	@GetMapping("/getbyid/{s_id}")
	StudentDTO getStudentById(@PathVariable("s_id") int id) {
		return studentSerive.getStudentById(id);
	}

//	---------------------------------------------------------------------------------------------------------------------------------

//	@PutMapping("/updatebyid/{s_id}")
//	Student_ent updateStudent(@PathVariable("s_id") int id, @RequestBody Student_ent student_ent) {
//
//		return studentSerive.updateById(id, student_ent);
//
//	}

	@PutMapping("/updatebyid/{s_id}")
	StudentDTO updateStudent(@Valid @PathVariable("s_id") int id, @RequestBody StudentDTO studentDto) {
		final Student_ent student_ent4 = converter.convertToEntity(studentDto);
		return studentSerive.updateById(id, student_ent4);
	}

//	---------------------------------------------------------------------------------------------------------------------------------

	@DeleteMapping("/deletebyid/{s_id}")
	String deletebyid(@PathVariable("s_id") int id) {
		return studentSerive.deleteById(id);

	}

}
