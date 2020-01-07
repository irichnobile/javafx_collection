//******************************************************************************
//	TenRandomCircles.java		Author: Ian Nobile
//
//	This program exhibits the window and shape creation functionality of the 
//	JavaFX suite.
//	
//******************************************************************************

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TenRandomCircles extends Application
{
	//--------------------------------------------------------------------------
	//	This program draws ten random circles and targets the largest of them  
	//	with a semi-transparent red.
	//--------------------------------------------------------------------------
	public void start(Stage primaryStage)
	{
		Random random = new Random();
		Group group = new Group();
		int iMaxRadius = 0;
		int iMaxCircle = 0;
		//	This is the (puzzling) format for creating an array of shapes:
		Circle[] circle = new Circle[10];
		
		//	Sets position, radius, fill and stroke before grouping together:
		for(int i=0; i<=9; i++)
		{
			int x = random.nextInt(300)+100;
			int y = random.nextInt(300)+100;
			int radius = random.nextInt(100)+1;
			
			circle[i] = new Circle(x,y,radius);
			circle[i].setStroke(Color.BLACK);
			circle[i].setFill(null);
			
			group.getChildren().add(circle[i]);
			
		} //end for
		
		//	If radius is larger than preset, records size and location:
		for(int i=0; i<=9; i++)
		{
			if(circle[i].getRadius()>=iMaxRadius)
			{
				iMaxRadius = (int) circle[i].getRadius();
				iMaxCircle=i;
				
			} //end if
			
		} //end for
		
		//	Fills the largest circle:
		circle[iMaxCircle].setFill(Color.RED);
		circle[iMaxCircle].setOpacity(0.3);
		
		Scene scene = new Scene(group, 500, 500);
		primaryStage.setTitle("Ten Random Circles");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	} //end Stage
	
	public static void main(String[] args)
	{
		//--------------------------------------------------------------------------
		//	The application actually runs from here
		//--------------------------------------------------------------------------
		Application.launch();
		
	} //end main
	
} //end class

