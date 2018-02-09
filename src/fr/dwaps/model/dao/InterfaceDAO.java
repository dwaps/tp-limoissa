package fr.dwaps.model.dao;

import java.util.List;

public interface InterfaceDAO<T> {
	List<T> findAll();
	T find(int id);
	void delete(int id);
	void update(T obj);
	void create(T obj);
}
