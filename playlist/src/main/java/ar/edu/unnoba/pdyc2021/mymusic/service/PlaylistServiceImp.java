package ar.edu.unnoba.pdyc2021.mymusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ar.edu.unnoba.pdyc2021.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2021.mymusic.model.Playlists_Songs;
import ar.edu.unnoba.pdyc2021.mymusic.model.Song;
import ar.edu.unnoba.pdyc2021.mymusic.model.User;
import ar.edu.unnoba.pdyc2021.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc2021.mymusic.repository.Playlists_SongsRepository;
import ar.edu.unnoba.pdyc2021.mymusic.repository.UserRepository;

@Service
public class PlaylistServiceImp implements PlaylistService {
	@Autowired
    private PlaylistRepository playlistRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private Playlists_SongsRepository playlists_songsRepository;

    @Override
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

	@Override
	public Playlist findPlaylist(Long id) {
		// TODO Auto-generated method stub
		return playlistRepository.findById(id).get();
	}

	@Override
	public void deletePlaylist(Long id, String loggedEmail) throws Exception {
		User user = userRepository.findByEmail(loggedEmail);
		 if(playlistRepository.existsById(id)==false){
	            throw new Exception("Playlist not found.");
       }else{
    	   Playlist p = playlistRepository.findById(id).get();
       	 if(p.getOwner().equals(user)){
                userRepository.deleteById(id); 
                }  	
         else {
           throw new Exception("You cannot delete another playlist.");
       }
	}
       }


	@Override
	public Playlist addPlaylist(Playlist p, String loggedEmail) {
	    User currentUser = userRepository.findByEmail(loggedEmail);
	    p.setOwner(currentUser);
		return playlistRepository.save(p);
	}

	@Override
	public String addSongOnPlaylist(Playlist p, Song s) {
		Playlists_Songs ps = new Playlists_Songs();
		ps.setPlaylist(p);
		ps.setSong(s);
		playlists_songsRepository.save(ps);
		return "";
		
	}

	@Override
	public void deleteSongOnPlaylist(Playlist p, Song s) {
		playlists_songsRepository.delete(playlists_songsRepository.findPlaylists_Songs(p, s));
	}

	@Override
	public void updatePlaylist(Long id, String name, String loggedEmail) throws Exception {
		User user = userRepository.findByEmail(loggedEmail);
		 if(playlistRepository.existsById(id)==false){
	            throw new Exception("Playlist not found.");
       }else{
    	   Playlist p = playlistRepository.findById(id).get();
       	 if(p.getOwner().equals(user)){
              p.setName(name);   
              }  	
         else {
           throw new Exception("You cannot update this playlist.");
       }
	}
       }

		
	}


