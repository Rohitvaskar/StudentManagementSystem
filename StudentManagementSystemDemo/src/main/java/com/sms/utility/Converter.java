package com.sms.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.entity.Student_ent;
import com.sms.entity.Teacher_ent;
import com.sms.model.StudentDTO;
import com.sms.model.TeacherDTO;

@Component
public class Converter {

//	convert from DTO to Entity
	public Student_ent convertToEntity(StudentDTO studentDto) {

		Student_ent stdEnt = new Student_ent();
		if (studentDto != null) {
			BeanUtils.copyProperties(studentDto, stdEnt);
		}
		return stdEnt;
	}

//	convert from DTO to Entity
	public StudentDTO convertToDTO(Student_ent student_ent) {

		StudentDTO stdDto = new StudentDTO();
		if (student_ent != null) {
			BeanUtils.copyProperties(student_ent, stdDto);
		}
		return stdDto;
	}

	// ---------------------------------------------------------------------------------------------------------

//	convert from DTO to Entity
	public Teacher_ent convertToTeacherEntity(TeacherDTO teacherDTO) {

		Teacher_ent teachEnt = new Teacher_ent();
		if (teacherDTO != null) {
			BeanUtils.copyProperties(teacherDTO, teachEnt);
		}
		return teachEnt;
	}

//	convert from DTO to Entity
	public TeacherDTO convertToTeacherDTO(Teacher_ent teacher_ent) {

		TeacherDTO teachDTO = new TeacherDTO();
		if (teacher_ent != null) {
			BeanUtils.copyProperties(teacher_ent, teachDTO);

		}
		return teachDTO;
	}

}
