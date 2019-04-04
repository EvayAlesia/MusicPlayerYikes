package view;

//UI elements (ie. buttons, sliders) 
//mp: MediaController/MediaPlayer 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import models.MediaController;

public class maincontroller {
	MediaController mp = new MediaController();
	@FXML
	private Button play;
	@FXML
	private Button next;
	@FXML
	private Button previous;
	@FXML
	private Button shuffle;
	@FXML
	private Button stop;
	
	

	@FXML
	protected void playmusic(ActionEvent e) {
		mp.play();
	}

	@FXML
	protected void next(ActionEvent e) {
		mp.next();
	}

	@FXML
	protected void previous(ActionEvent e) {
		mp.previous();
	}
	
	@FXML
	protected void stop(ActionEvent e) {
		mp.stop();
		
	}

	@FXML
	protected void shuffle(ActionEvent e) {
		mp.shuffle();
	}
	
	@FXML
	private Slider volumeSlider;

	@FXML
	protected void changeVolume(MouseEvent e) {
		
			// Double: converting decimal into an integer
			mp.setVolume((int)volumeSlider.getValue());
			
		
			
		
	}

}
