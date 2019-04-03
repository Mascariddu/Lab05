package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Parola;
import it.polito.tdp.anagrammi.model.ParolaModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	ParolaModel p = new ParolaModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TxtInserimento;

    @FXML
    private Button BtnAnagramma;

    @FXML
    private TextArea TxtResult1;

    @FXML
    private TextArea TxtResult2;

    @FXML
    private Button BtnReset;

    @FXML
    void DoAnagrammi(ActionEvent event) {
    	
    	TxtResult1.clear();
    	TxtResult2.clear();
    	
    	for(String parola: p.getAnagrammi(TxtInserimento.getText())) {
    		
    		if(p.esattezza(parola))
    			TxtResult1.appendText(parola+"\n");
    		else TxtResult2.appendText(parola+"\n");
    		
    	}	

    }

    @FXML
    void DoReset(ActionEvent event) {
    	
    	TxtResult1.clear();
    	TxtResult2.clear();
    	TxtInserimento.clear();
    	
    }
    
    public void setModel(ParolaModel model) {
    	
    	this.p=model;
 
    }

    @FXML
    void initialize() {
        assert TxtInserimento != null : "fx:id=\"TxtInserimento\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert BtnAnagramma != null : "fx:id=\"BtnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert TxtResult1 != null : "fx:id=\"TxtResult1\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert TxtResult2 != null : "fx:id=\"TxtResult2\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert BtnReset != null : "fx:id=\"BtnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}


