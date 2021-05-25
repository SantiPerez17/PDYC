package ar.edu.unnoba.pdyc2021.mymusic.resource;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;


import ar.edu.unnoba.pdyc2021.mymusic.dto.editplaylistDTO;
import ar.edu.unnoba.pdyc2021.mymusic.dto.playlistDTO;
import ar.edu.unnoba.pdyc2021.mymusic.dto.songDTO;
import ar.edu.unnoba.pdyc2021.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2021.mymusic.model.Playlists_Songs;
import ar.edu.unnoba.pdyc2021.mymusic.model.Song;
import ar.edu.unnoba.pdyc2021.mymusic.repository.SongRepository;
import ar.edu.unnoba.pdyc2021.mymusic.service.PlaylistService;
import ar.edu.unnoba.pdyc2021.mymusic.service.SongService;

@Path("/playlists")
public class PlaylistResource {
	@Autowired
    private PlaylistService playlistService;
	
	@Autowired
	private SongService songService;
	
	@Autowired
	private SongRepository songR;
	   
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(editplaylistDTO p)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String loggedEmail = (String) auth.getPrincipal();
    	ModelMapper modelMapper = new ModelMapper();
        Playlist pl = modelMapper.map(p,Playlist.class);    	
    	playlistService.addPlaylist(pl,loggedEmail);
    	return Response.status(Response.Status.CREATED).entity("Playlist created with name: " + p.getName()).build();	
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylistById(@PathParam("id") Long id)
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
/*   
    @POST
    @Path("/{id}/songs/")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addSong(@PathParam("id") Long id, @RequestBody Song song) {
    	if (songR.existsById(song.getId()) == true){
    		playlistService.addSongOnPlaylist(playlistService.findPlaylist(id), song);
    		return "guardada " + songService.findSong(song.getId()).getName() + " en playlist " + playlistService.findPlaylist(id).getName();
    	}else {
		return  "nocsite gola";
    	}			
    }
    
    @DELETE
    @Path("/{id}/songs/{song_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addSong(@PathParam("id") Long id, @PathParam("song_id") Long song_id) {
    	if (songR.existsById(songService.findSong(song_id).getId()) == true){
    		playlistService.deleteSongOnPlaylist(playlistService.findPlaylist(id), songService.findSong(song_id));
    		return "hola";
    	}else {
		return  "nocsite gola";
    	}			
    }
    
  */  
    @DELETE
    @Path("/{id}")
    public Response deletePlaylist(@PathParam("id") long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedEmail = (String) auth.getPrincipal();
        try{
        	
            playlistService.deletePlaylist(id,loggedEmail);
            return Response.ok().build();
        } catch (Exception e){
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlaylist(@RequestBody editplaylistDTO epl, @PathParam("id") Long id)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedEmail = (String) auth.getPrincipal();
        try{
        	
        	playlistService.updatePlaylist(id, epl.getName(),loggedEmail);
        	 return Response.ok().entity("Playlist updated.").build();
        } catch (Exception e){
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        }
    }
    

}
