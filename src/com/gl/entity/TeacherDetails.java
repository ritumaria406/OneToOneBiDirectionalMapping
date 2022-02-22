package com.gl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.Table;;

@Entity
@Table(name="teacher_details")
public class TeacherDetails {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="hobby")
	private String hobby;
	
	// the value in the mapped by is the same as the one in the Teacher class 
	@OneToOne(mappedBy = "teacherDetails",cascade = CascadeType.ALL)
	private Teacher teacher;
	
	public TeacherDetails() {
	
	}
	
	
	public TeacherDetails(int id, String city, String hobby, Teacher teacher) {
		
		this.city = city;
		this.hobby = hobby;
		this.teacher = teacher;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	@Override
	public String toString() {
		return "TeacherDetails [id=" + id + ", city=" + city + ", hobby=" + hobby + ", teacher=" + teacher + "]";
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public TeacherDetails(String city, String hobby) {
		
		this.city = city;
		this.hobby = hobby;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
