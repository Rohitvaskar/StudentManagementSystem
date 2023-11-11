package com.sms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student_ent;
import com.sms.exception.ResourceNotFoundException;
import com.sms.model.StudentDTO;
import com.sms.repository.Student_repo;
import com.sms.service.Student_service;
import com.sms.utility.Converter;

@Service
public class Student_serviceImpl implements Student_service {

	@Autowired
	private Student_repo stdRepo;

	@Autowired
	private Converter converter;

//	@Override
//	public Student_ent createStudent(Student_ent student_ent) {
//		return stdRepo.save(student_ent);
//	}

	@Override
	public StudentDTO createStudent(Student_ent student_ent) {
		Student_ent student_ent2 = stdRepo.save(student_ent);
		return converter.convertToDTO(student_ent2);
	}

	@Override
	public List<StudentDTO> getAllStudent() {
		List<Student_ent> student_ent3 = stdRepo.findAll();
		List<StudentDTO> dtoList = new ArrayList<>();

		for (Student_ent student_ent : student_ent3) {
			dtoList.add(converter.convertToDTO(student_ent));
		}

		return dtoList;
	}

	@Override
	public StudentDTO getStudentById(int id) {
		Student_ent stdEnt = stdRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student ", " s_id ", id));
		return converter.convertToDTO(stdEnt);
	}

	@Override
	public StudentDTO updateById(int id, Student_ent student_ent) {

		Student_ent stdEnt1 = stdRepo.findById(id).get();
		stdEnt1.setName(student_ent.getName());
		stdEnt1.setAdderess(student_ent.getAdderess());
		stdEnt1.setPhone(student_ent.getPhone());

		Student_ent stdEnt2 = stdRepo.save(stdEnt1);

		return converter.convertToDTO(stdEnt2);
	}

	@Override
	public String deleteById(int id) {
		stdRepo.deleteById(id);
		return "student deleted id:- " + id;
	}

}
