package com.gl.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.gl.entity.*;



public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)				
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			Teacher t1 = new Teacher("Mark","Joy","ritu.joy@aspiresys.com");
			TeacherDetails td1 = new TeacherDetails("Kochi","Dancing");
			
			t1.setTeacherDetails(td1);
			
			Teacher t2 = new Teacher("Joe","Thomas","joe.thomas@aspiresys.com");
			TeacherDetails td2 = new TeacherDetails("Mumbai","Reading");
			
			t2.setTeacherDetails(td2);
			session.beginTransaction();
			
			session.save(t1);
			session.save(t2);
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
