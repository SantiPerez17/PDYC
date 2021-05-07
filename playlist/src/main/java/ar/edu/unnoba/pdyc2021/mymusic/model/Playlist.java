/**
 * 
 */
package ar.edu.unnoba.pdyc2021.mymusic.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import ar.edu.unnoba.pdyc2021.mymusic.model.*;

/**
 * @author Santiago
 *
 */
@Entity
@Table(name = "playlists")
public class Playlist {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn
	    private User owner;
	    
	    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
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

		public User getOwner() {
			return owner;
		}

		public void setOwner(User owner) {
			this.owner = owner;
		}


		public void setPlaylistsSongs(List<PlaylistsSongs> playlistsSongs) {
			this.playlistsSongs = playlistsSongs;
		}

		public List<PlaylistsSongs> getPlaylistsSongs() {
			return playlistsSongs;
		}
 
	

}
