package rest.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAOFactory {

    private static final String PROPERTIES_FILE       = "/rest/dao/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_LOGIN = "login";
    private static final String PROPERTY_PWD    = "pwd";

    private String              url;
    private String              username;
    private String              password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( PROPERTIES_FILE );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + PROPERTIES_FILE + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_LOGIN );
            motDePasse = properties.getProperty( PROPERTY_PWD );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + PROPERTIES_FILE, e );
        }

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }

     Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }
     
	public static PreparedStatement initializePreparedStatement( Connection con, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
		
		PreparedStatement preparedStatement = con.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
		
		for ( int i = 0; i < objets.length; i++ ) {
			preparedStatement.setObject( i + 1, objets[i] );
		}
		
		return preparedStatement;
	}
	
	public static void close( ResultSet resultSet ) {
	    if ( resultSet != null ) {
	        try {
	            resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
	        }
	    }
	}

	public static void close( Statement statement ) {
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
	        }
	    }
	}

	public static void close( Connection connexion ) {
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
	        }
	    }
	}

	public static void close( Statement statement, Connection connexion ) {
		close( statement );
		close( connexion );
	}

	public static void close( ResultSet resultSet, Statement statement, Connection connexion ) {
		close( resultSet );
		close( statement );
		close( connexion );
	}



    public FilmDao getFilmDao() {
    	return new FilmDaoImpl( this );
    }

	public UserDao getUserDao() {
		return new UserDaoImpl( this );
	}


}