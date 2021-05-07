package ar.edu.unnoba.pdyc2021.mymusic.dto;

public class playlistDTO {
	private String name;
	private userDTO author;
	//private String emailauthor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public userDTO getAuthor() {
		return author;
	}
	public void setAuthor(userDTO author) {
		this.author = author;
	}
	

}
