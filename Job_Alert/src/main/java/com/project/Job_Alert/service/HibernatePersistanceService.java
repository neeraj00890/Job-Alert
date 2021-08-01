package com.project.Job_Alert.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernatePersistanceService implements IHibernatePersistanceService {

	@Autowired
	SessionFactory sessionFactory;

	public List<Object> executeQuery(String query, Map<String, Object> params) {
		Session session = sessionFactory.openSession();
		Query sql = session.createQuery(query);
		params.forEach((key, value) -> {
			sql.setParameter(key, value);
		});
		return sql.list();
	}

	public List<Object> executeQuery(String query) {
		Session session = sessionFactory.openSession();
		Query sql = session.createQuery(query);
		return sql.list();
	}

	public void executeUpdate(String query, Map<String, Object> params) {
		Session session = sessionFactory.openSession();
		Query sql = session.createQuery(query);
		params.forEach((key, value) -> {
			sql.setParameter(key, value);
		});
		sql.executeUpdate();
	}

}
