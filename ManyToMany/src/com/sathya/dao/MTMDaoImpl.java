package com.sathya.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Course;
import com.sathya.entity.Student;
import com.sathya.util.HibernateUtil;

public class MTMDaoImpl implements IMTMDao 
{
	private  SessionFactory   factory;
	public MTMDaoImpl() {
		factory=HibernateUtil.getSessionFactory();
	}
	@Override
	public void saveStudentsAndCourses() {
		Student   s1=new  Student();
		s1.setSid(1);  s1.setName("A");
		Student   s2 = new  Student();
		s2.setSid(2);  s2.setName("B");
		
		Course  c1= new  Course();
		c1.setCid(101);  c1.setName("Java");
		Course  c2 =new  Course();
		c2.setCid(102);  c2.setName("Oracle");
		Course  c3 = new  Course();
		c3.setCid(103);  c3.setName("Hadoop");
		
		Set<Course>  courses =new  HashSet<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		s1.setCourses(courses);
		
		Set<Course>   courses2 =new  HashSet<>();
		courses2.add(c2);
		courses2.add(c3);
		s2.setCourses(courses2);
		
		Set<Student>  students = new  HashSet<>();
		students.add(s1);
		students.add(s2);
		
		c2.setStudents(students);
		c3.setStudents(students);
		
		Set<Student>   students2 = new  HashSet<>();
		students2.add(s1);
		c1.setStudents(students2);
		
		Session  session=factory.openSession();
		Transaction  tx=session.beginTransaction();
		session.save(s1);
		session.save(s2);
		tx.commit();
		session.close();
		
	}
	@Override
	public void addCourseToStudent() {
		Session  session=factory.openSession();
		Student   s2=(Student)session.get(Student.class, 2);
		Course    c1 =(Course)session.get(Course.class, 101);
		
		Set<Student>  students = c1.getStudents();
		Transaction  tx=session.beginTransaction();
		students.add(s2);
		tx.commit();
		session.close();
	
	}
}
