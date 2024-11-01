package org.example.dao;

import java.util.List;

public interface IDao<T>{
	boolean create(T o);
	T getById(Long id);
	List<T> getAll();
}
