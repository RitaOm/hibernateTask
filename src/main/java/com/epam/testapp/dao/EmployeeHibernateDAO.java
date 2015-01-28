package com.epam.testapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.epam.testapp.bean.Employee;

@Transactional
public class EmployeeHibernateDAO implements IEmployeeDAO {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList(int firstResult, int resultsPerPage)
			throws SQLException {
		Transaction tx = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			Session session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(resultsPerPage);
			list = criteria.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
