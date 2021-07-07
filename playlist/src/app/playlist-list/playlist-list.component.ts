import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlaylistService } from '../playlist.service';
import {Playlist} from '../playlist';
@Component({
  selector: 'app-playlist-list',
  templateUrl: './playlist-list.component.html',
  styleUrls: ['./playlist-list.component.css']
})
export class PlaylistListComponent implements OnInit {
  playlists : Playlist[];

  constructor(private router: ActivatedRoute, 
    private playlistService: PlaylistService) {}


  ngOnInit(){
    this.playlistService.getPlaylists().subscribe(res =>{
      this.playlists=res;
    })
  }

}
