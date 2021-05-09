package ar.edu.unnoba.pdyc2021.mymusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unnoba.pdyc2021.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2021.mymusic.repository.PlaylistRepository;

@Service
public class PlaylistServiceImp implements PlaylistService {
	@Autowired
    private PlaylistRepository playlistRepository;

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
	public void deletePlaylist(Long id) {
		playlistRepository.deleteById(id);
		
	}

	@Override
	public Playlist addPlaylist(Playlist p) {
		return playlistRepository.save(p);
	}

}
