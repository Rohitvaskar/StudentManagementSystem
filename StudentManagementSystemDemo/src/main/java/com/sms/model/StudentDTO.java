
// DTO:- data transfer object

package com.sms.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Teacher_ent;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO {

	@NotNull
	private int s_id;
	@NotNull
	@Size(min = 2, max = 35, message = "your name should be minmum 2 or maximum 35 characters...")
	private String name;
	@NotNull
	@Size(min = 10, max = 100, message = "your adderess should be minmum 10 or maximum 100 characters...")
	private String adderess;
	@NotNull
	private String phone;

	private Teacher_ent teacherEnt;
	
}
