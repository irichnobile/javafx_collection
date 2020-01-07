//********************************************************************************
//	HW1Prob1__ian_nobile.java		Author: Ian Nobile
//
//	This JavaFX application displays a text object and two labeled buttons, label-
//	led “Uppercase”, and “Lowercase”. When the “Uppercase” button is pressed, the 
//	program displays the text in uppercase and vice versa. Two separate handler 
//	methods have been utilised, one for each of the buttons. Finally, all GUI 
//	elements have been organised in a GridPane.
//********************************************************************************

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UpperLowerConverter extends Application
{
	//----------------------------------------------------------------------------
	//	This is where the stage is set, and the elements organised for display.
	//----------------------------------------------------------------------------
	
	private TextField textfield;
	private Button uppercase;
	private Button lowercase;
	
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("UpperLowerConverter");
		
		textfield = new TextField();
		textfield.setPrefWidth(275);
		//	Here is where the default text is set:
		textfield.setText("Type whatever you would like!");
		
		uppercase = new Button("Uppercase");
		lowercase = new Button("Lowercase");
		/*	When clicked, the text within the TextField is copied, permuted to 
		 *	upper- or lowercase and replaces the previously inputted text:	*/
		uppercase.setOnAction(action -> 
			{textfield.setText(textfield.getText().toUpperCase());});
		lowercase.setOnAction(action -> 
			{textfield.setText(textfield.getText().toLowerCase());});
		
		//	Here, considerations are made for the organisation of the elements:
		GridPane gridpane = new GridPane();
		gridpane.setHgap(105);
		gridpane.setVgap(3);
		gridpane.setAlignment(Pos.CENTER);
		//	(name of element, column, row, # of columns occupied, # of rows occupied);
		gridpane.add(textfield, 0, 0, 2, 1);
		gridpane.add(uppercase, 0, 1, 1, 1);
		gridpane.add(lowercase, 1, 1, 1, 1);
		
		Scene scene = new Scene(gridpane, 280, 63);		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}//	end start
	
	public static void main(String[] args)
	{
		//----------------------------------------------------------------------------
		//	The application actually runs from here.
		//----------------------------------------------------------------------------
		Application.launch(args);
		
	}//	end main

}//	end class

