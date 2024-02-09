package com.spring.orm.CrudOperations.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.CrudOperations.entity.Student;

public class StudentDao {
	
	HibernateTemplate hibernateTemplate;
	
	

	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Student student) {
		hibernateTemplate.save(student);
		return 1;
	}
	
	//Get a specific student
	public Student getStudent(int id) {
		Student student = hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	//Get all students records from table
	public List<Student> getAllStudents(){
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//updating a student entry
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}
	
	//Deleting a student
	@Transactional
	public void deleteStudent(int id) {
		Student student = hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(student);
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
}
