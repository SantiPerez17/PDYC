package ar.edu.unnoba.pdyc2021.mymusic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unnoba.pdyc2021.mymusic.model.Song;
import ar.edu.unnoba.pdyc2021.mymusic.repository.SongRepository;

import java.util.List;

@Service
public class SongServiceImp implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }
    
    public Song findSong(Long id) {
        return songRepository.findById(id).get();
    }
	@Override
	public Song addSong(Song song) {
		return songRepository.save(song);
		
	}

	@Override
	public void deleteSong(Long id) {
		// TODO Auto-generated method stub
		songRepository.deleteById(id);
	}

	@Override
	public List<Song> findByAuthor(String author) {
		return songRepository.findSongsByAuthor(author);
	}

	@Override
	public List<Song> findByGenre(String genre) {
		return songRepository.findSongsByGenre(genre);
	}
	
	@Override
	public List<Song> findByAuthorAndGenre(String author,String genre) {
		return songRepository.findSongsByAuthorAndGenre(author,genre);
	}
	
	@Override
    public Song updateSong(Song song, Long id) {
        Song s = songRepository.findById(id).get();
        if (song.getName()!=null) {s.setName(song.getName());;}
        if (song.getAuthor()!=null) {s.setAuthor(song.getAuthor());}
        if (song.getGenre()!=null) {s.setGenre(song.getGenre());}
        return songRepository.save(s);
    }
    
}
