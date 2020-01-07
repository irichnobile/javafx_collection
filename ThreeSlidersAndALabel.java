//******************************************************************************
//	ThreeSlidersAndALabel.java		Author: Ian Nobile
//	
//	This JavaFX application consists of three sliders and a label. The sliders 
//	are used to define the red, green, and blue components of the background 
//	colour of the label. Each slider represents a coefficient between 0 and 255 
//	for the red, green, and blue amounts respectively. As the user moves a 
//	slider, the background colour of the label changes. 
//	
//******************************************************************************

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ThreeSlidersAndALabel extends Application
{
	private Slider sRed = new Slider(0, 255, 128);
	private Slider sGreen = new Slider(0, 255, 128);
	private Slider sBlue = new Slider(0, 255, 128);
	
	public void start(Stage primaryStage)
	{
		//Creates label and sets its initial width, height and background colour
		Label label = new Label("Three Sliders and a Label");
		label.setMinSize(100.0, 50.0);
		label.setBackground(new Background(new BackgroundFill(Color.rgb(
				(int)sRed.getValue(), (int)sGreen.getValue(), 
				(int)sBlue.getValue()), null, null)));
		
		//Adjusts the Red slider's properties, incl. setting up a listener that 
		//will change the red component of the background colour of the label:
		sRed.setShowTickMarks(true);
		sRed.setShowTickLabels(true);
		sRed.valueProperty().addListener((obsr, oldr, newr)->
			label.setBackground(new Background(new BackgroundFill(Color.rgb(
					newr.intValue(), (int)sGreen.getValue(), 
					(int)sBlue.getValue()), null, null))));
	
		//Adjusts the Green slider's properties, incl. setting up a listener
		//that will change the green component of the background colour of the
		//label:
		sGreen.setShowTickMarks(true);
		sGreen.setShowTickLabels(true);
		sGreen.valueProperty().addListener((obsg, oldg, newg)->
			label.setBackground(new Background(new BackgroundFill(Color.rgb(
					(int)sRed.getValue(), newg.intValue(), 
					(int)sBlue.getValue()), null, null))));
		
		//Adjusts the Blue slider's properties, incl. setting up a listener that
		//will change the blue component of the background colour of the label:
		sBlue.setShowTickMarks(true);
		sBlue.setShowTickLabels(true);
		sBlue.valueProperty().addListener((obsb, oldb, newb)->
			label.setBackground(new Background(new BackgroundFill(Color.rgb(
					(int)sRed.getValue(), (int)sGreen.getValue(), 
					newb.intValue()), null, null))));
		
		GridPane gridPane = new GridPane();
		gridPane.add(label, 1, 0, 1, 1);
		gridPane.add(sRed, 0, 2, 1, 1);
		gridPane.add(sGreen, 1, 2, 1, 1);
		gridPane.add(sBlue, 2, 2, 1, 1);
		
		Scene scene = new Scene(gridPane);
		
		primaryStage.setTitle("ThreeSlidersAndALabel");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	} //end start
	
	
	//--------------------------------------------------------------------------
	//	<<main method>>
	//--------------------------------------------------------------------------
	public static void main(String[] args)
	{
		Application.launch(args);
		
	} //end main

} //end class

