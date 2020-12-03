package rest.dao;
 
import rest.model.User;
 
public interface UserDao {
   
    void register(User user) throws Exception;
   
    public User login(String username, String password) throws Exception;
    
    public User find(int id) throws DAOException;
   
}