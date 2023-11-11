package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Student_ent;

public interface Student_repo extends JpaRepository<Student_ent, Integer> {

}
