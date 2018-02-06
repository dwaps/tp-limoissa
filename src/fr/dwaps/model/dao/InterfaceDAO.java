package fr.dwaps.model.dao;

import java.util.List;

public interface InterfaceDAO<T> {
	List<T> findAll();
	T find(long id);
	void delete(long id);
	void update(T obj);
	void create(T obj);
}
