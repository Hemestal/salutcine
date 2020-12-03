package rest.model;

import java.sql.SQLException;


public class Cinema {
	
	int id;
	String name;
	String opening;
	String closure;
	String city;
	String country;
	String zip_code;
	
	public Cinema() {
		
	}

	public Cinema(String name, String opening, String closure, String city, String country, String zip_code) {
		this.name = name;
		this.opening = opening;
		this.closure = closure;
		this.city = city;
		this.country = country;
		this.zip_code = zip_code;
	}

    public static Cinema map( java.sql.ResultSet resultSet ) throws SQLException {
    	Cinema Cinema = new Cinema();
    	
    	Cinema.setId(resultSet.getInt( "id" ) );
    	Cinema.setname(resultSet.getString("name"));
    	Cinema.setopening(resultSet.getString("opening"));
    	Cinema.setclosure(resultSet.getString("closure"));
    	Cinema.setCountry(resultSet.getString("country"));
    	Cinema.setCity(resultSet.getString("city"));
    	Cinema.setZip_code(resultSet.getString("zip_code"));
    	
	    return Cinema;
	}
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getopening() {
		return opening;
	}

	public void setopening(String opening) {
		this.opening = opening;
	}

	public String getclosure() {
		return closure;
	}

	public void setclosure(String closure) {
		this.closure = closure;
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
		return "Cinema [id=" + id + ", name=" + name + ", opening=" + opening + ", closure=" + closure + ", city="
				+ city + ", country=" + country + ", zip_code=" + zip_code + "]";
	}
	
	
	
}
