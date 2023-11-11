package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Teacher_ent;

public interface Teacher_repo extends JpaRepository<Teacher_ent, Integer> {

}
