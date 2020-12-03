package rest.dao;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1456196783477037394L;

	public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOException( Throwable cause ) {
        super( cause );
    }
}