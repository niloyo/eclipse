package composite;

import java.util.ArrayList;

public abstract class User {

	String username;
	ArrayList<IComponent> playlists = new ArrayList();

	public void createPlaylist(Playlist newPlaylist) {
	//Create a new playlist.
	}

	public void deletePlaylist(Playlist newPlaylist) {
	//Deletes a playlist.
	}  

	public void playPlaylist(PlaylistName ) {
	//Plays a specific playlist.
	}

	public void playSong(SongName ) {
	//Plays a specific song.
	}
}