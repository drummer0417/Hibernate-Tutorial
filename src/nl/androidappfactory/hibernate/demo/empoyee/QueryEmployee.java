package nl.androidappfactory.hibernate.demo.empoyee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.androidappfactory.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {

		Session session = null;

		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).buildSessionFactory();

			session = factory.getCurrentSession();
			session.beginTransaction();

			List<Employee> employees = session.createQuery("from Employee e where e.firstName like 'Piet%'")
					.getResultList();

			for (Employee employee : employees) {
				System.out.println("emp: " + employee);
			}

		} catch (Exception e) {

			System.out.println("Foutje: " + e.getMessage());
		}

	}

}
