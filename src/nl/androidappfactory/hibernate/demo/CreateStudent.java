package nl.androidappfactory.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use session to save the Java object

			// create Student object
			Student student = new Student("jjjj", "Pddddd12233", "jp.nl");
			System.out.println("created: " + student);

			// create transaction
			System.out.println("start transaction: ");
			session.beginTransaction();

			// save the student
			System.out.println("save student");
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

			// new student is:
			System.out.println("generated: " + student);

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
