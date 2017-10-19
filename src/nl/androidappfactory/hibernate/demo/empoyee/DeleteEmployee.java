package nl.androidappfactory.hibernate.demo.empoyee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {

		Session session = null;

		try {

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).buildSessionFactory();
			session = factory.getCurrentSession();
			session.beginTransaction();

			Employee emp = new Employee();
			emp.setId(4);
			session.delete(emp);

			System.out.println("delete: " + emp);
			session.createQuery("delete Employee e where e.firstName = 'Pietje'").executeUpdate();

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("foutje: " + e.getMessage());
		} finally {
			session.close();
		}

	}

}
