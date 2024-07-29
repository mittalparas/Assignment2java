package application;

import java.io.IOException;

import com.google.gson.Gson;
import java.util.List;

import java.net.URL;

import java.util.ResourceBundle;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SampleController {
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
    private AnchorPane anchor_pane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btnSearch;

    @FXML
    private Label errMsgLabel;

    @FXML
    private HBox h_box;

    @FXML
    private Label label1;

    @FXML
    private Label mTitle;

    @FXML
    private Label mYear;

    @FXML
    private ImageView posterImageView;

    @FXML
    private TextField searchTextField;
    
    public void getSearchResults() {
    	
    	OMDBAPIService omdbService = new OMDBAPIService();
    	try {
    		
//    		Example search parameter
    		String searchTerm=searchTextField.getText();
    		String searchParam=searchTerm.toString();
    		System.out.println(searchParam);
    		
//    		Make the API call
    		String jsonInput=omdbService.searchMovies(searchParam);
    		
//    		Print the response
    		System.out.println(jsonInput);
    		System.out.println(jsonInput.getClass());
    		
    		Gson gson=new Gson();
    		
//    		Parse Json string to SearchResult object
    		SearchResult searchResult=new Gson().fromJson(jsonInput, SearchResult.class);
    		
//    		Print the response
    		System.out.println(searchResult);
    		System.out.println(searchResult.getClass());
    		
    		int i=0;
//    		Access individual movie elements and print them
    		for(Movie movie : searchResult.getSearch()) {
    			if(i==0) {
    				System.out.println("Title: "+movie.getTitle());
    				System.out.println("Year: "+movie.getYear());
    				System.out.println("imdb ID: "+movie.getimdbID());
    				System.out.println("Type: "+movie.getType());
    				System.out.println("Poster: "+movie.getPoster());
    				System.out.println();
    				i++;
    				
//    				Title
    				mTitle.setText(movie.getTitle());
    				
//    				Year
    				mYear.setText(movie.getYear());
    				
//    				Image
    				String imageUrl=movie.getPoster();
    				this.setPosteImage(imageUrl);
    			}
    		}
    		

    	}catch(IOException | InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
//    Method to set image for posteImage
    public void setPosteImage(String imageUrl) {
    	Image image=new Image(imageUrl);
    	posterImageView.setImage(image);
    }
	
}
