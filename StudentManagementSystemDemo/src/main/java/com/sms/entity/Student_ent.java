package com.sms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student_ent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;
	@Column(length = 35)
	private String name;
	@Column(length = 100)
	private String adderess;
	@Column(unique = true)
	private String phone;

	private boolean status = Boolean.TRUE;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "t_id")
	@JsonIgnoreProperties("students")
	private Teacher_ent teacher;
}
