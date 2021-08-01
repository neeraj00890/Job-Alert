package com.project.Job_Alert.service;

import java.util.List;
import java.util.Map;

public interface IHibernatePersistanceService {
	public List<Object> executeQuery(String query, Map<String, Object> params);
	public List<Object> executeQuery(String query);
	public void executeUpdate(String query, Map<String, Object> params);
}
