package ar.edu.unnoba.pdyc2021.mymusic.resource;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import ar.edu.unnoba.pdyc2021.mymusic.dto.songDTO;
import ar.edu.unnoba.pdyc2021.mymusic.model.Song;
import ar.edu.unnoba.pdyc2021.mymusic.service.SongService;

/**
 * Created by jpgm on 27/04/21.
 */

/*
URI para retornar listado de canciones es
GET http://localhost:8080/myapp/songs
 */

@Path("/songs")
public class SongResource {

    @Autowired
    private SongService songService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongs(){
    	ModelMapper modelMapper = new ModelMapper();
    	Type ListType = new TypeToken<List<songDTO>>(){}.getType();
    	List<songDTO> list = modelMapper.map(songService.getSongs(), ListType);
    	
        return Response.ok(list).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/filter")
    public Response getSongs(@QueryParam("author") String author, @QueryParam("genre") String genre) {
    	List<Song> list = new ArrayList<Song>();
    	if (author != null && genre == null) {
    		list = songService.findByAuthor(author);
    	}
   		if (genre != null && author == null) {
    			list = songService.findByGenre(genre);
    	}
    	if( genre!=null && author != null ) {
    			list = songService.findByAuthorAndGenre(author,genre);
    	}
    	ModelMapper modelMapper = new ModelMapper();
    	Type ListType = new TypeToken<List<songDTO>>(){}.getType();
    	List<songDTO> listy = modelMapper.map(list, ListType);
    	return Response.ok(listy).build();
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Song addSong(Song song)
    {
    	return songService.addSong(song);
    }
    
    @GET
    @Path("/filter/author/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> hola(@PathParam("author") String author){
    	return songService.findByAuthor(author);
    }
    
    @GET
    @Path("/filter/genre/{genre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> chau(@PathParam("genre") String genre){
    	return songService.findByGenre(genre);
    }
    
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Song getCountryById(@PathParam("id") Long id)
    {
    	return songService.findSong(id);
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteSong(@PathParam("id") Long id)
    {
    	songService.deleteSong(id);
  
    }
    @PUT
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Song updateSong(@RequestBody Song song, @PathParam("id") Long id)
    {
    		return songService.updateSong(song, id);
  
    }
    
    
}
