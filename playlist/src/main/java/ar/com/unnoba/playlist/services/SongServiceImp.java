package ar.com.unnoba.playlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.unnoba.playlist.models.Song;
import ar.com.unnoba.playlist.repositories.SongRepository;

import java.util.List;

/**
 * Created by jpgm on 27/04/21.
 */
@Service
public class SongServiceImp implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }
}
