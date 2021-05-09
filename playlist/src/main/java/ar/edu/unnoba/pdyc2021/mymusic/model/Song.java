package ar.edu.unnoba.pdyc2021.mymusic.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "song",fetch = FetchType.LAZY)
    private List<PlaylistsSongs> playlistsSongs;
	    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Enumerated(EnumType.STRING)
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	public void setPlaylistsSongs(List<PlaylistsSongs> playlistsSongs) {
		this.playlistsSongs = playlistsSongs;
	}


}

