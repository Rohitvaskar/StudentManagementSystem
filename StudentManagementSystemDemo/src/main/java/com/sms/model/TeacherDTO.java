package com.sms.model;

import java.util.List;

import com.sms.entity.Student_ent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {

	private int t_id;
	private String name;
	private String adderess;
	private String phone;

	private boolean status = Boolean.TRUE;

	List<Student_ent> students;

}
