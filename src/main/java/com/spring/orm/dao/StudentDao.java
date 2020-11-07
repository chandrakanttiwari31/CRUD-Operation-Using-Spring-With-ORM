package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// save student
	@Transactional
	public boolean insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		if(i>0)
		{
			
			return true;
		}
		
		return false;

	}

	// get single student
	public Student getstudent(int id)

	{
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}

// get all student
	public List<Student> getallstudent() {

		List<Student> st = this.hibernateTemplate.loadAll(Student.class);
		return st;
	}

	// deleting data
	@Transactional
	public boolean deletestudent(int id) {

		Student s = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(s);
		return false;
	}

	// updating data
	@Transactional
	public boolean updatestudent(Student s) {

		this.hibernateTemplate.update(s);
		return false;
	}
}
