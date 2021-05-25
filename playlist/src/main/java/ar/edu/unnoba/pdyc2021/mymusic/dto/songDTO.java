package ar.edu.unnoba.pdyc2021.mymusic.dto;

import ar.edu.unnoba.pdyc2021.mymusic.model.Genre;

public class songDTO {
	@Override
	public String toString() {
		return "song [name=" + name + ", author=" + author + ", genre=" + genre + "]";
	}

	private String name, author;
	private Genre genre;

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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
