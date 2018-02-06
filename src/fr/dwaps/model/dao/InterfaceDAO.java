package fr.dwaps.model.dao;

import java.util.List;

public interface InterfaceDAO {
	List<Object> findAll();
	Object find(long id);
}
