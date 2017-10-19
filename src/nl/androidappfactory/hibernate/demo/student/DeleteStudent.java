package nl.androidappfactory.hibernate.demo.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {

		Session session = null;

		try {

			// create session factory
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
					.buildSessionFactory();

			// create session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// get student with id
			// Student student = session.get(Student.cla ss, 3217);
			// System.out.println("get: " + student);
			//
			// // delete student ...
			// session.delete(student);

			// delete all students with firstName = 'jjjj'

			session.createQuery("delete from Student s where s.firstName = 'jjjj'").executeUpdate();

			// commit
			session.getTransaction().commit();

		} catch (Exception e) {

		} finally {
			session.close();
		}
	}

}
