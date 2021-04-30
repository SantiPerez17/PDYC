package ar.com.unnoba.playlist.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.unnoba.playlist.models.Song;
import ar.com.unnoba.playlist.services.SongService;

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
        //Falta aplicar los conceptos de DTO
        List<Song> songs = songService.getSongs();
        return Response.ok(songs).build();
    }
}
