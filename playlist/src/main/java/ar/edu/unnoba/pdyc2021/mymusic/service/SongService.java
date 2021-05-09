package ar.edu.unnoba.pdyc2021.mymusic.service;

import java.util.List;

import ar.edu.unnoba.pdyc2021.mymusic.model.Song;

/**
 * Created by jpgm on 27/04/21.
 */
public interface SongService {
    public List<Song> getSongs();
    public Song addSong(Song song);
    public Song findSong(Long id);
    public void deleteSong(Long id);
    public List<Song> findByAuthor(String author);
    public List<Song> findByGenre(String genre);
    public Song updateSong(Song song, Long id);
	public List<Song> findByAuthorAndGenre(String author,String genre);
}
