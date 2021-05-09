package ar.edu.unnoba.pdyc2021.mymusic.dto;

import java.util.List;

import ar.edu.unnoba.pdyc2021.mymusic.model.Song;

public class playlistDTO {
	private String name;
	private String author;
	private List<songDTO> songs;
	
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
	public List<songDTO> getSongs() {
		return songs;
	}
	public void setSongs(List<songDTO> songs) {
		this.songs = songs;
	}
	

}
