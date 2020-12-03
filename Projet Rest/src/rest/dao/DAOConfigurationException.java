package rest.dao;


public class DAOConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 3964259434328541455L;

	public DAOConfigurationException( String message ) {
        super( message );
    }

    public DAOConfigurationException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOConfigurationException( Throwable cause ) {
        super( cause );
    }
}