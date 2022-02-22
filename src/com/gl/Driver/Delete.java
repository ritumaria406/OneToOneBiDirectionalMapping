package com.gl.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.gl.entity.*;


public class Delete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)				
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			int teacherDetailId = 1;
			
			session.beginTransaction();
			
			TeacherDetails teacherDetail = session.get(TeacherDetails.class, teacherDetailId);
			if(teacherDetail != null)
			{
				//Please note as in the teacher details cascade type = ALL, entry will also be deleted from the teacher table
				System.out.println("Deleting the record");
				session.delete(teacherDetail);
			}
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}
	}

