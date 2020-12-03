package rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rest.model.Film;

public class FilmDaoImpl implements FilmDao {
	
	private DAOFactory daoFactory;

	private static final String SQL_SELECT_BY_TITLE = "SELECT * FROM films WHERE title LIKE ?";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM films WHERE id = ?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM films";
	private static final String SQL_SELECT_ALL_OWNED_BY_USER = "SELECT * FROM films WHERE id_owner = ?";
	
	private static final String SQL_CREATE_FILM = "INSERT INTO films (id_owner, title, type, year, producer, director, rating) "
												+ "VALUES(?,?,?,?,?,?,?)";
	
	FilmDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	@Override
	public void create(Film film) throws DAOException {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			con = daoFactory.getConnection();
			
			preparedStatement = DAOFactory.initializePreparedStatement(con, SQL_CREATE_FILM, false,
				film.getId_owner(),
				film.getTitle(),
				film.getType(),
				film.getYear(),
				film.getProducer(),
				film.getDirector(),
				film.getRating());
			
			preparedStatement.executeUpdate();
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DAOFactory.close(preparedStatement, con);
		}

	}

	@Override
	public Film find(String title) throws DAOException {
		
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Film film = null;

	    try {

	        con = daoFactory.getConnection();
	        preparedStatement = DAOFactory.initializePreparedStatement( con, SQL_SELECT_BY_TITLE, false, '%' + title + '%' );
	        resultSet = preparedStatement.executeQuery();

	        if ( resultSet.next() ) {
	            film = Film.map( resultSet );
	            film.setOwner(daoFactory.getUserDao().find(film.getId_owner()));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOFactory.close( resultSet, preparedStatement, con );
	    }

	    return film;
		
	}
	
	@Override
	public Film find(int id) throws DAOException {
		
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Film film = null;

	    try {

	        con = daoFactory.getConnection();
	        preparedStatement = DAOFactory.initializePreparedStatement( con, SQL_SELECT_BY_ID, false, id );
	        resultSet = preparedStatement.executeQuery();

	        if ( resultSet.next() ) {
	            film = Film.map( resultSet );
	            film.setOwner(daoFactory.getUserDao().find(film.getId_owner()));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOFactory.close( resultSet, preparedStatement, con );
	    }

	    return film;
		
	}
	
	public List<Film> getFilmList() throws DAOException {
		
		
		Connection con = null;
		Statement stmt = null;
	    ResultSet resultSet = null;
	    
	    ArrayList<Film> films = new ArrayList<>();

	    try {

	        con = daoFactory.getConnection();
	        stmt = con.createStatement();
	        resultSet = stmt.executeQuery(SQL_SELECT_ALL);

	        while ( resultSet.next() ) {
	        	Film film = Film.map( resultSet );
	            film.setOwner(daoFactory.getUserDao().find(film.getId_owner()));
	        	films.add(film);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOFactory.close( resultSet, stmt, con );
	    }

	    return films;
		
	}

	@Override
	public List<Film> getFilmListOwnedByUser(int id) throws DAOException {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	    
	    ArrayList<Film> films = new ArrayList<>();

	    try {

	        con = daoFactory.getConnection();
	        preparedStatement = DAOFactory.initializePreparedStatement( con, SQL_SELECT_ALL_OWNED_BY_USER, false, id );
	        resultSet = preparedStatement.executeQuery();

	        while ( resultSet.next() ) {
	        	Film film = Film.map( resultSet );
	        	film.setOwner(daoFactory.getUserDao().find(id));
	            films.add(film);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOFactory.close( resultSet, preparedStatement, con );
	    }

	    return films;
		
	}

}

