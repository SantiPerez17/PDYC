package ar.edu.unnoba.pdyc2021.mymusic.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unnoba.pdyc2021.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2021.mymusic.model.User;
import ar.edu.unnoba.pdyc2021.mymusic.service.PlaylistService;

@Path("/playlists")
public class PlaylistResource {
	@Autowired
    private PlaylistService playlistService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(){
    	/*ModelMapper modelMapper = new ModelMapper();
    	Type ListType = new TypeToken<List<playlistDTO>>(){}.getType();
    	List<playlistDTO> list = modelMapper.map(playlistService.getPlaylists(), ListType);
        */
    	List<Playlist> list = playlistService.getPlaylists();
    	
        return Response.ok(list).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Playlist getCountryById(@PathParam("id") Long id)
    {
    	return playlistService.findPlaylist(id);
    }

}
