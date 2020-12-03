package rest.model;

import java.sql.SQLException;


public class User {
	
	int id;
	String username;
	String password;
	String email;
	String city;
	String country;
	String zip_code;
	
	public User() {
		
	}

	public User(String username, String password, String email, String city, String country, String zip_code) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
		this.country = country;
		this.zip_code = zip_code;
	}

    public static User map( java.sql.ResultSet resultSet ) throws SQLException {
    	User user = new User();
    	
    	user.setId(resultSet.getInt( "id" ) );
    	user.setUsername(resultSet.getString("username"));
    	user.setPassword(resultSet.getString("password"));
    	user.setEmail(resultSet.getString("email"));
    	user.setCountry(resultSet.getString("country"));
    	user.setCity(resultSet.getString("city"));
    	user.setZip_code(resultSet.getString("zip_code"));
    	
	    return user;
	}
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", city="
				+ city + ", country=" + country + ", zip_code=" + zip_code + "]";
	}
	
	
	
}
