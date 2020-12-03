package rest.ressources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import rest.dao.DAOConfigurationException;
import rest.dao.DAOFactory;
import rest.dao.FilmDao;
import rest.model.Film;
import rest.model.User;


@Path("/films")
public class FilmsResource {

    @Context
    UriInfo 	uriInfo;
    @Context
    Request 	request;
    
    DAOFactory 	daoFactory 	= DAOFactory.getInstance();
    FilmDao 	filmDao 	= daoFactory.getFilmDao();

    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getFilms(@Context HttpServletRequest req) {
    	
    	List<Film> films = new ArrayList<>();
    	
    	try {
			films.addAll(DAOFactory.getInstance().getFilmDao().getFilmList());
		} 
    	
    	catch (DAOConfigurationException e) {
			e.printStackTrace();
		} 
    	
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(!films.isEmpty())
    		return Response.ok(films, req.getContentType()).status(Response.Status.OK).build();
    	
        return Response.ok("{}", req.getContentType()).status(Response.Status.OK).build();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newFilm(@FormParam("title") String title,
            @FormParam("type") String type,
            @FormParam("year") String year,
            @FormParam("producer") String producer,
            @FormParam("director") String director,
            @FormParam("rating") int rating,
            @Context HttpServletRequest req,
            @Context HttpServletResponse servletResponse) throws IOException {
    	
    	User user = (User) req.getSession().getAttribute("user");
    	
    	if(user != null) {
        
	    	Film film = new Film(user.getId(), title, type, year, producer, director, rating);
	    	
	    	try {
				filmDao.create(film);
			}
	    	
	    	catch (Exception e) {
				e.printStackTrace();
			}
    	
    	}

        servletResponse.sendRedirect("../create_film.html");
    }

    
    
    @GET
    @Path("{film}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getFilm(@PathParam("film") int id, @Context HttpServletRequest req) {
    	
    	Film ret = null;
    	
    	try {
			ret = filmDao.find(id);
		} 
    	
    	catch (NumberFormatException e) {
			e.printStackTrace();
		} 
    	
    	catch (DAOConfigurationException e) {
			e.printStackTrace();
		} 
    	
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(ret != null)
    		return Response.ok(ret, req.getContentType()).status(Response.Status.OK).build();
    	
    	
    	return Response.ok("{}", req.getContentType()).status(Response.Status.OK).build();
    }
    
   
    
    @GET
    @Path("/search/{keywords}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response findFilmsWithKeywords(@PathParam("keywords") String keywords, @Context HttpServletRequest req) {
    	
    	Film ret = null;
    	
    	try {
			
    		ret = filmDao.find(keywords);
		} 
    	
    	catch (NumberFormatException e) {
			e.printStackTrace();
		} 
    	
    	catch (DAOConfigurationException e) {
			e.printStackTrace();
		} 
    	
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(ret != null)
    		return Response.ok(ret, req.getContentType()).status(Response.Status.OK).build();
    	
    	
    	return Response.ok("{}", req.getContentType()).status(Response.Status.OK).build();
    }
    
    @GET
    @Path("/search/owner/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response findBooksOwnedByUser(@PathParam("id") int id, @Context HttpServletRequest req) {
    	
    	List<Film> ret = null;
    	
    	try {
			
    		ret = filmDao.getFilmListOwnedByUser(id);
		} 
    	
    	catch (NumberFormatException e) {
			e.printStackTrace();
		} 
    	
    	catch (DAOConfigurationException e) {
			e.printStackTrace();
		} 
    	
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(ret != null)
    		return Response.ok(ret, req.getContentType()).status(Response.Status.OK).build();
    	
    	
    	return Response.ok("{}", req.getContentType()).status(Response.Status.OK).build();
    }

}