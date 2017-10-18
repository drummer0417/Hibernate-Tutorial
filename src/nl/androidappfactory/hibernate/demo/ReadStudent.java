package nl.androidappfactory.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use session to save the Java object

			// create Student object
			Student student = new Student("P.", "Puk2", "Pietje.P@gmail.nl");
			System.out.println("created: " + student);

			// create transaction
			System.out.println("start transaction: ");
			session.beginTransaction();

			// save student
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("after commit: " + student);

			// read the student
			session = factory.getCurrentSession();
			session.beginTransaction();

			Student readStudent = session.get(Student.class, student.getId());
			System.out.println("\nread: " + readStudent);

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
