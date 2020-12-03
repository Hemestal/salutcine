package rest.dao;

import java.util.List;

import rest.model.Cinema;

public interface CinemaDao {

	void create( Cinema Cinema ) throws DAOException;

    Cinema find( String title ) throws DAOException;

    Cinema find( int id ) throws DAOException;
    
    List<Cinema> getCinemaList() throws DAOException;
	
}
