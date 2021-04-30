package ar.com.unnoba.playlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.unnoba.playlist.models.Song;

/**
 * Created by jpgm on 27/04/21.
 */

@Repository("songRepository")
public interface SongRepository extends JpaRepository<Song,Long>{
}

