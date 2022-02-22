package com.gl.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.gl.entity.*;



public class Read {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)				
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			int theTeacherDetailId = 1;			
			
			TeacherDetails newTeacherD = session.get(TeacherDetails.class, theTeacherDetailId);
			if(newTeacherD != null)
			{
				System.out.println("Teacher details :" +newTeacherD);
				System.out.println("Teacher  " +newTeacherD.getTeacher());
			}
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
