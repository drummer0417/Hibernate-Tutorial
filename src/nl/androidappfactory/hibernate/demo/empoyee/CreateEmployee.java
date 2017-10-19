package nl.androidappfactory.hibernate.demo.empoyee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {

		Session session = null;

		try {

			// create session factory
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).buildSessionFactory();

			// create session
			session = factory.getCurrentSession();

			// start transaction
			session.beginTransaction();

			// create and save new employees
			Employee emp1 = new Employee("Hans", "van Meurs", "het mooie Wipro");
			Employee emp2 = new Employee("Pietje", "Puk", "Hema");
			Employee emp3 = new Employee("Jan", "Jansen", "Jumbo");

			session.save(emp1);
			session.save(emp2);
			session.save(emp3);

			System.out.println("saved: " + emp1);
			System.out.println("saved: " + emp2);
			System.out.println("saved: " + emp3);

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Something went wrong: " + e.getMessage());
		} finally {

			// close session
			session.close();
		}

	}

}
