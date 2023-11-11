package com.sms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student_ent;
import com.sms.entity.Teacher_ent;
import com.sms.exception.ResourceNotFoundException;
import com.sms.model.TeacherDTO;
import com.sms.repository.Student_repo;
import com.sms.repository.Teacher_repo;
import com.sms.service.Teacher_service;
import com.sms.utility.Converter;

@Service
public class Teacher_serviceImpl implements Teacher_service {

	@Autowired
	private Teacher_repo teacher_repo;

	@Autowired
	private Student_repo stdRepo;

	@Autowired
	private Teacher_repo teachRepo;

	@Autowired
	private Converter converter;

	@Override
	public TeacherDTO registerTeacher(Teacher_ent teacher_ent) {
		return converter.convertToTeacherDTO(teacher_repo.save(teacher_ent));
	}

	@Override
	public String assingStudentToTeacher(int t_id, int s_id) {

		Student_ent stdEnts = stdRepo.findById(s_id)
				.orElseThrow(() -> new ResourceNotFoundException("Student ", " s_id ", s_id));

		Teacher_ent teachEnts = teachRepo.findById(t_id)
				.orElseThrow(() -> new ResourceNotFoundException("Student ", " s_id ", t_id));

		List<Student_ent> students = new ArrayList<>();
		students.add(stdEnts);

		teachEnts.setStudents(students);
		stdEnts.setTeacher(teachEnts);

		teachRepo.save(teachEnts);

		return "Student assing to a teacher successfully.....";
	}

}
