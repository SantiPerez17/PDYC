package ar.edu.unnoba.pdyc2021.mymusic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unnoba.pdyc2021.mymusic.model.Song;

/**
 * Created by jpgm on 27/04/21.
 */

@Repository("songRepository")
public interface SongRepository extends JpaRepository<Song,Long>{
	@Query("select s from Song s where s.author = :author")
	public List<Song> findSongsByAuthor(@Param("author") String author); 
	
	@Query("select s from Song s where s.genre = :genre")
	public List<Song> findSongsByGenre(@Param("genre") String genre);
	
}

