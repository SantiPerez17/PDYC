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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import ar.edu.unnoba.pdyc2021.mymusic.dto.playlistDTO;
import ar.edu.unnoba.pdyc2021.mymusic.dto.songDTO;
import ar.edu.unnoba.pdyc2021.mymusic.dto.userDTO;
import ar.edu.unnoba.pdyc2021.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2021.mymusic.model.Playlists_Songs;
import ar.edu.unnoba.pdyc2021.mymusic.model.Song;
import ar.edu.unnoba.pdyc2021.mymusic.model.User;
import ar.edu.unnoba.pdyc2021.mymusic.service.PlaylistService;

@Path("/playlists")
public class PlaylistResource {
	@Autowired
    private PlaylistService playlistService;
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(){
    	List<Playlist> playlists = playlistService.getPlaylists();
    	List<playlistDTO> list=new ArrayList<playlistDTO>();
    	for (Playlist p:playlists) {
    		playlistDTO dto=new playlistDTO();
    		dto.setName(p.getName());
    		dto.setAuthor(p.getOwner().getEmail());
    		List<Playlists_Songs> playlistsongs= p.getPlaylists_Songs();
    		List<Song> canciones = new ArrayList<Song>();
    		for (Playlists_Songs s:playlistsongs) {
    			canciones.add(s.getSong());
    		}
    		ModelMapper modelMapper = new ModelMapper();
        	Type ListSongType = new TypeToken<List<songDTO>>(){}.getType();
        	List<songDTO> listsongs = modelMapper.map(canciones, ListSongType);
    		dto.setSongs(listsongs);
    		list.add(dto);
    		
    	}
    	
        return Response.ok(list).build();
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Playlist addPlaylist(Playlist p)
    {
    	return playlistService.addPlaylist(p);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountryById(@PathParam("id") Long id)
    {
    	Playlist list = playlistService.findPlaylist(id);
    	playlistDTO playlistdto = new playlistDTO();
    	playlistdto.setName(list.getName());
    	playlistdto.setAuthor(list.getOwner().getEmail());
    	List<Playlists_Songs> playlistsongs= list.getPlaylists_Songs();
    	List<Song> canciones = new ArrayList<Song>();
		for (Playlists_Songs s:playlistsongs) {
			canciones.add(s.getSong());
		}
    	ModelMapper modelMapper = new ModelMapper();
    	Type ListSongType = new TypeToken<List<songDTO>>(){}.getType();
    	List<songDTO> listsongs = modelMapper.map(canciones, ListSongType);
		playlistdto.setSongs(listsongs);
    	return Response.ok(playlistdto, MediaType.APPLICATION_JSON).build();
    	
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlaylist(@PathParam("id") Long id)
    {
    	playlistService.deletePlaylist(id);
  
    }
   /* @PUT
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Song updateSong(@RequestBody Song song, @PathParam("id") Long id)
    {
    		return songService.updateSong(song, id);
  
    }
    
*/
}
