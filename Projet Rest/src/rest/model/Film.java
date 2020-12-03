package rest.model;


import java.sql.SQLException;


public class Film {

    private int id;
    private int id_owner;
    private String title;
    private String type;
    private String year;
    private String producer;
    private String director;
    private int rating;
    
    private User owner;

    public Film(){

    }
    
    public Film(int id_owner, String title, String type, String year, String producer, String director, int rating) {
		this.id_owner = id_owner;
		this.title = title;
		this.type = type;
		this.year = year;
		this.producer = producer;
		this.director = director;
		this.rating = rating;
	}



	public static Film map( java.sql.ResultSet resultSet ) throws SQLException {
    	Film film = new Film();

    	film.setId(resultSet.getInt("id"));
    	film.setId_owner(resultSet.getInt("id_owner"));
    	film.setTitle(resultSet.getString("title"));
    	film.setType(resultSet.getString("type"));
    	film.setYear(resultSet.getString("year"));
    	film.setProducer(resultSet.getString("producer"));
    	film.setDirector(resultSet.getString("director"));
    	film.setRating(resultSet.getInt("rating"));
    	
	    return film;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_owner() {
		return id_owner;
	}

	public void setId_owner(int id_owner) {
		this.id_owner = id_owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
    
    

}