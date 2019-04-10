package models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.media.*;
import javafx.util.Duration;

public class Song {
	// ATRIBUTES!!
	String name;
	String artistName;
	Duration length;
	Media musicFile;
	Mp3File mp3File;


	public Song(String filename) {
		musicFile = new Media(new File(filename).toURI().toString());
		length = musicFile.getDuration();
		
		try {
			mp3File = new Mp3File(filename);
		} catch (UnsupportedTagException | InvalidDataException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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


	public Media getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(Media musicFile) {
		this.musicFile = musicFile;
	}
	
	public Image getAlbumArt() {
		Image image;
		if (mp3File.hasId3v2Tag()){
		     ID3v2 id3v2tag = mp3File.getId3v2Tag();
		     byte[] imageData = id3v2tag.getAlbumImage();
		     
		     //converting the bytes to an image
		     try {
				BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
				image = SwingFXUtils.toFXImage(img, null);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				image = new Image("C:\\Users\\Jimmy\\Pictures\\Ahri Stuff\\50552110.jpg");
			}
		}
		else 
		{
			image = new Image("C:\\Users\\Jimmy\\Pictures\\Ahri Stuff\\50552110.jpg");
		}
		
		return image;
	}
	
}
