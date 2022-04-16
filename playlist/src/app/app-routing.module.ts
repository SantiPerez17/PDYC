import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { PlaylistListComponent } from './Components/playlist-list/playlist-list.component';
import { SongsListComponent } from './Components/songslist/songslist.component';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'playlists', component: PlaylistListComponent},
  {path:'songs', component: SongsListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
