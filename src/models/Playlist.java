package models;

import java.io.File;
import java.util.*;

public class Playlist {
	ArrayList<Song> playlist;
	int counter;
	String name;
	
	public Playlist(String name){
		this.name = name;
		this.counter = 0;
		playlist = new ArrayList<Song>();
		// TODO Remove 
//		playlist.add(new Song("E:/Music/To the Moon - Original Soundtrack/17 Take Me Anywhere.mp3" ));
//		playlist.add(new Song("E:/Music/To the Moon - Original Soundtrack/01 To the Moon - Main Theme.mp3" ));
//		playlist.add(new Song("E:/Music/Aimer/Your Favorite Things/10 Change the World.mp3" )); 
//		playlist.add(new Song("E:/Music/Jersey Boys [2014] Soundtrack YG/Album/02. December, 1963 (Oh, What A Night).mp3"));
//		playlist.add(new Song("E:/Music/Jersey Boys [2014] Soundtrack YG/Album/23. Sherry.mp3"));
//		playlist.add(new Song("E:/Music/Golden Time/Golden Time OP ED Single/[Nipponsei]_Golden_Time_OP_ED_Single_-_Golden_Time_[Horie_Yui]/01 - Golden Time.mp3"));
		playlist.add(new Song("C:\\Users\\Jimmy\\Music\\----daze - Daze [Nico Nico Chorus].mp3"));
	}
	public Playlist(File io){}
	
	public ArrayList<Song> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(ArrayList<Song> playlist) {
		this.playlist = playlist;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		if (playlist.size()-1 < counter) {counter = 0;}
		if (counter < 0) {counter = playlist.size()-1;}
		else {this.counter = counter;}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void shuffle(){
		//i++ - increments the value of i by 1.
		for(int i=0; i<this.playlist.size(); i++){
			//temp - holding temporary value of current song trying to swap.
			Song temp = this.playlist.get(i);
			Random rn = new Random();
			//Array starts at 0. So -1 shifts size values by 1.
			int number = rn.nextInt(playlist.size() -1);
			System.out.println(number);
			this.playlist.set(i,playlist.get(number));
			this.playlist.set(number,temp);
		}
	}
	public Song getCurrentSong(){
		Song currentSong = playlist.get(counter);
		return currentSong;
	}
}
