/**
 * 
 */
package com.sid.e2e.springboot.test;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sid.e2e.springboot.Section01StudentDetailsAccess;
import com.sid.e2e.springboot.studentdetails.entity.Student;
import com.sid.e2e.springboot.studentdetails.repo.StudentRepo;

/**
 * @author Lenovo
 *
 */
@SpringBootTest(classes = Section01StudentDetailsAccess.class)
public class Section01StudentDetailsAccessTest {

	@Autowired
	private StudentRepo studentRepo;
	
	@Ignore
	public void testCreateStudent() {
		Student student=new Student();
		student.setName("Sidddhant");
		student.setCourse("java spring course");
		student.setFee(31.85);
		
		studentRepo.save(student);
	}
	
	@Test
	public void findStudent() {
		Optional<Student> findById = studentRepo.findById(7l);
		Student student=findById.get();
		System.out.println(student);
	}
	
	
	@Ignore
	public void testUpdateStudent() {
		Student student= studentRepo.findById(1l).get();
		student.setFee(35d);
		
		studentRepo.save(student);
	}

	@Ignore
	public void testDeleteStudent() {
		studentRepo.deleteById(2l);
	}

}
