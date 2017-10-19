package nl.androidappfactory.hibernate.demo.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create transaction
			System.out.println("start transaction: ");
			session.beginTransaction();

			// Get student(s)
			List<Student> students = session
					.createQuery("from Student s where s.email like '%androidappfactory.nl' or s.firstName like 'Cas%'")
					.getResultList();
			System.out.println("Results:.............");
			for (Student student : students) {
				System.out.println("result: " + student.toString());
			}

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("commit transaction	 ");
			System.out.println("Hibernate error: " + e.getMessage());
		} finally {
			// session.clear();
			factory.close();
			System.out.println("done ");
		}
	}

}
