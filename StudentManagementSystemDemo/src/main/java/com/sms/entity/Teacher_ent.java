package com.sms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher_ent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int t_id;
	@Column(length = 35)
	private String name;
	@Column(length = 100)
	private String adderess;
	@Column(unique = true)
	private String phone;

	private boolean status = Boolean.TRUE;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("teacher")
	List<Student_ent> students;

}
