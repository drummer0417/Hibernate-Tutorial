package nl.androidappfactory.hibernate.demo.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		Session session = null;
		try {

			// create sessionFactory
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
					.buildSessionFactory();

			// create session
			session = factory.getCurrentSession();

			// start transaction
			session.beginTransaction();

			// get student 2

			Student student = session.get(Student.class, 2);

			// update student
			student.setFirstName("Scooby");
			student.setLastName("Doooooo");
			student.setEmail("scooby.d@androidappfactory.nl");

			// Get all students Pietje and update email
			List<Student> students = session.createQuery("from Student s where s.firstName = 'Pietje' ")
					.getResultList();

			// update all Pietjes lastName to Puk
			for (Student student2 : students) {
				student2.setLastName("Puk");
			}

			// or do it in one query
			session.createQuery(
					"update Student s set s.school = 'Stedelijk College Einhoven - Henegouwe', s.email = 'p.p@gmail.com', s.firstName = 'Pietje' where s.firstName like 'P%'")
					.executeUpdate();
			// session.createQuery("update Student s set s.email = 'P.Pukkie' where
			// s.firstName like 'P%'")
			// .executeUpdate();

			// commit whole session
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Something went wrong: " + e.getMessage());
		} finally {
			session.close();
		}

	}

}
