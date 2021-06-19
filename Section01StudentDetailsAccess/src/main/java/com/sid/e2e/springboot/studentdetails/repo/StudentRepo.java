package com.sid.e2e.springboot.studentdetails.repo;

import org.springframework.data.repository.CrudRepository;

import com.sid.e2e.springboot.studentdetails.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {

}
