package com.sms.service;

import com.sms.entity.Teacher_ent;
import com.sms.model.TeacherDTO;

public interface Teacher_service {

	TeacherDTO registerTeacher(Teacher_ent teacher_ent);

	String assingStudentToTeacher(int t_id, int s_id);

}
