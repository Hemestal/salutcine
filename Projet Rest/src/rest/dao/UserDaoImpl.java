package rest.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rest.model.User;
 
public class UserDaoImpl implements UserDao{
 
        private DAOFactory daoFactory;
       
        private static final String SQL_SELECT_BY_USERNAME_AND_PWD = "SELECT * FROM users WHERE username = ? AND password = ?";

    	private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
        
    	private static final String SQL_CREATE_USER = "INSERT INTO users (username,password,email,country,city,zip_code)"
    												+ "VALUES(?,?,?,?,?,?)";
       
        UserDaoImpl(DAOFactory daoFactory){
            this.daoFactory = daoFactory;
        }
   
        @Override
        public User login(String username, String password) throws DAOException{
            Connection con = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            User user = null;
 
            try {
 
                con = daoFactory.getConnection();
                preparedStatement = DAOFactory.initializePreparedStatement( con, SQL_SELECT_BY_USERNAME_AND_PWD, false, username, password );
                resultSet = preparedStatement.executeQuery();
 
                if ( resultSet.next() ) {
                    user = User.map( resultSet );
                }
            } catch ( SQLException e ) {
                throw new DAOException( e );
            } finally {
                DAOFactory.close( resultSet, preparedStatement, con );
            }
 
            return user;
        }
 
        @Override
        public void register(User user) throws DAOException {
           
            Connection con = null;
            PreparedStatement preparedStatement = null;
           
            try {
               
                con = daoFactory.getConnection();
               
                preparedStatement = DAOFactory.initializePreparedStatement(con, SQL_CREATE_USER, false,
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getCountry(),
                    user.getCity(),
                    user.getZip_code());
               
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
		public User find(int id) throws DAOException {

			Connection con = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    User user = null;

		    try {

		        con = daoFactory.getConnection();
		        preparedStatement = DAOFactory.initializePreparedStatement( con, SQL_SELECT_BY_ID, false, id );
		        resultSet = preparedStatement.executeQuery();

		        if ( resultSet.next() ) {
		        	user = User.map( resultSet );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        DAOFactory.close( resultSet, preparedStatement, con );
		    }

		    return user;
			
		}
}