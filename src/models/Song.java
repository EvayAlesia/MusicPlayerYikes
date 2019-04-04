package models;

import java.io.File;

import javafx.scene.media.*;
import javafx.util.Duration;

public class Song {
	// ATRIBUTES!!
	String name;
	String artistName;
	Duration length;
	AlbumArt art;
	Media musicFile;

	public Song(AlbumArt art, String filename) {
		this.name = name;
		this.artistName = artistName;
		this.art = null;

		musicFile = new Media(new File(filename).toURI().toString());
		length = musicFile.getDuration();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getLength() {
		int minutes = (int) length.toMinutes();
		float seconds = (float) length.toSeconds();
		return minutes + ":" + seconds;
	}

	public AlbumArt getArt() {
		return art;
	}

	public void setArt(AlbumArt art) {
		this.art = art;
	}

	public Media getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(Media musicFile) {
		this.musicFile = musicFile;
	}

}
