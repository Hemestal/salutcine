package rest.dao;

import java.util.List;

import rest.model.Film;

public interface FilmDao {

	void create( Film film ) throws DAOException;

    Film find( String title ) throws DAOException;

    Film find( int id ) throws DAOException;
    
    List<Film> getFilmList() throws DAOException;
	
	List<Film> getFilmListOwnedByUser(int id) throws DAOException;
}
