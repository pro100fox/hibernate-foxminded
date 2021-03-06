package com.foxminded.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.foxminded.hibernate.onetomany.entities.Department;
import com.foxminded.hibernate.onetomany.entities.Employee;
import com.foxminded.hibernate.onetomany.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = new Department();
		department.setDepartmentName("Sales");
		
		
		Employee emp1 = new Employee("Nina", "Mayers", "111");
		Employee emp2 = new Employee("Tony", "Almeida", "222");
		department.addEmployee(emp1);
		department.addEmployee(emp2);
		session.save(department);
		
		emp1.setDepartment(department);
		emp2.setDepartment(department);
		
		session.save(emp1);
		session.save(emp2);

		transaction.commit();
		session.close();
	}
}