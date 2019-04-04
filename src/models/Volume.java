package models;



public class Volume {
	int volume;
	public Volume(){
		volume = 50;
	}
	
	
	public Volume(int volume){
		this.volume = volume;
		
	}
	
	public int getVolume() {
		return volume;
	
	}
	public void setVolume(int volume) {
		this.volume = volume;
		if (volume < 0) {this.volume = 0;}
		if (volume >= 100) {this.volume = 100;}
	}

	

	
	}
