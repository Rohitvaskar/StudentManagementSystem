package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Teacher_ent;
import com.sms.model.TeacherDTO;
import com.sms.service.Teacher_service;
import com.sms.utility.Converter;

@RestController
@RequestMapping("/api")
public class Teacher_control {

	@Autowired
	private Teacher_service teacher_service;

	@Autowired
	private Converter converter;

	@PostMapping("/createteacher")
	ResponseEntity<TeacherDTO> ceateStudent(@Valid @RequestBody TeacherDTO teacherDTO) {

		final Teacher_ent teacher_ent = converter.convertToTeacherEntity(teacherDTO);
		return new ResponseEntity<TeacherDTO>(teacher_service.registerTeacher(teacher_ent), HttpStatus.CREATED);
	}

	@PostMapping("/assing/{t_id}/{s_id}")
	public String assingStudentToTeacher(@PathVariable("t_id") int t_id, @PathVariable("s_id") int s_id) {
		return teacher_service.assingStudentToTeacher(t_id, s_id);

	}

}
