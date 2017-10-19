package nl.androidappfactory.hibernate.demo.empoyee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {

		Session session = null;

		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).buildSessionFactory();
			session = factory.getCurrentSession();
			session.beginTransaction();

			Employee emp = session.get(Employee.class, 7);

			emp.setFirstName("J");
			emp.setLastName("Doedel");

			session.update(emp);

			session.createQuery("update Employee e set e.lastName = 'P' where e.firstName = 'Pietje'").executeUpdate();

			session.getTransaction().commit();

			System.out.println("read: " + emp);

		} catch (Exception e) {
			System.out.println("Foutje: " + e.getMessage());
		} finally {
			session.close();
		}

	}

}
