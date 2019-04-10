package view;

import java.io.IOException;

import javafx.application.Application;

//UI elements (ie. buttons, sliders) 
//mp: MediaController/MediaPlayer 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
	private ImageView albumart;
	@FXML 
	private Button playlist;
	
	@FXML
	protected void createPlaylist(ActionEvent e) {
		Parent root;
        try {
        	FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Playlist.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node)(e.getSource())).getScene().getWindow().hide();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	@FXML
	protected void playmusic(ActionEvent e) {
		albumart.setImage(mp.getCurrentPlaylist().getCurrentSong().getAlbumArt());
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
