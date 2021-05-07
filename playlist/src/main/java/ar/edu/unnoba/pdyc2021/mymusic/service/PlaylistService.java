package ar.edu.unnoba.pdyc2021.mymusic.service;

import java.util.List;

import ar.edu.unnoba.pdyc2021.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2021.mymusic.model.User;

public interface PlaylistService {
	public List<Playlist> getPlaylists();

	public Playlist findPlaylist(Long id);

}
