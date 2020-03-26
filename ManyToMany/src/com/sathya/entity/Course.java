package com.sathya.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course
{
	@Id
	private  int  cid;
	@Column(length=10)
	private  String  name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course",
	joinColumns=@JoinColumn(name="cid_fk"),
	inverseJoinColumns=@JoinColumn(name="sid_fk"))
	private   Set<Student>    students;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
