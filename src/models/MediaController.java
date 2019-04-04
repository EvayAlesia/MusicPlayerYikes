package models;

import javafx.scene.media.MediaPlayer;

public class MediaController {

	//ATTRIBUTES!
	private Playlist currentPlaylist;
	private Volume volume;
	private MediaPlayer mp; 
	//mp is a java class
	
	

	public MediaController() {
		// TODO: Change parameters in current Playlist later
		currentPlaylist = new Playlist("1");
		volume = new Volume(100);
		mp = new MediaPlayer(currentPlaylist.getCurrentSong().getMusicFile());
	
	}

	public Playlist getCurrentPlaylist() {
		return currentPlaylist;
	}

	public void setCurrentPlaylist(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
	}

	
	
    public int getVolume() {
    	return this.volume.getVolume();
    }
    
	//sets volume to whatever the user did on maincontroller
	public void setVolume(int volume) {
		this.volume.setVolume(volume);
		// Dividing value of number by 100.
		//Double: converting decimal into an integer
		//mp.setVolume calling in from Volume.java
		mp.setVolume((double)this.volume.getVolume() /100);
	}

	public void play() {
		mp.play();

	}

	public void next() {
		mp.stop();
		currentPlaylist.setCounter(currentPlaylist.getCounter() + 1);
		mp = new MediaPlayer(currentPlaylist.getCurrentSong().getMusicFile());
		mp.play();
		mp.setVolume((double)this.volume.getVolume() /100);
	}

	public void previous() {
		mp.stop();
		currentPlaylist.setCounter(currentPlaylist.getCounter() - 1);
		mp = new MediaPlayer(currentPlaylist.getCurrentSong().getMusicFile());
		mp.play();
		mp.setVolume((double)this.volume.getVolume() /100);
	}

	public void shuffle() {
		mp.stop();
		//Calling in method! currentPlaylist is a method! Activates shuffle() from the protected void shuffle from the playlist.java tab
		//currentPlaylist is the playlist object. 
		currentPlaylist.shuffle();
		//No = sign needed because you're calling a method. It has the value 0 in the parameter.
		currentPlaylist.setCounter(0);
		mp = new MediaPlayer(currentPlaylist.getCurrentSong().getMusicFile());
		mp.play();
		mp.setVolume((double)this.volume.getVolume() /100);
		
		
	}
	
	public void stop() {
		mp.stop();
		
		
	}

	
}
