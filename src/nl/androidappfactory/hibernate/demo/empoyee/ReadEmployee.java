package nl.androidappfactory.hibernate.demo.empoyee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {

		Session session = null;

		try {

			// create session factory
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).buildSessionFactory();

			// create session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// read employee 1
			Employee employee = session.get(Employee.class, 2);
			System.out.println("read: " + employee);

		} catch (Exception e) {

			System.out.println("Foutje: " + e.getMessage());
		} finally {
			session.close();
		}

	}

}
