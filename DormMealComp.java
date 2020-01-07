//******************************************************************************
//	DormMealComp.java		Author: Ian Nobile
//	
//	Utilising two choice boxes controls and a text control, this JavaFX 
//	application shows the total charges for a semester based on dormitory and/or 
//	meal plan.
//	
//******************************************************************************

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.DecimalFormat;


public class DormMealComp extends Application
{
	private ChoiceBox<String> dormitory;
	private ChoiceBox<String> mealplan;
	private TextField textfield;
	
	
	public void start(Stage primaryStage)
	{
		Label dorms = new Label("Dormitories");
		Label meaps = new Label("Meal Plans");
		//list of dormitories here:
		String[] dormlist = new String[]{" ", //first is blank
										"Allen Hall", 
										"Smith Hall", 
										"William Hall", 
										"University Suites"
										};
		//list of meal plans here: 
		String[] meaplist = new String[]{" ", //also blank
										"7 meals per week", 
										"14 meals per week", 
										"Unlimited meals"
										};
		
		//this sets up the dormitory ChoiceBox
		dormitory = new ChoiceBox<String>();
		dormitory.getItems().addAll(dormlist);
		//starts ChoiceBox with first entry (blank) selected:
		dormitory.getSelectionModel().select(0);
		//runs method (line 90) on change in ChoiceBox selection:
		dormitory.setOnAction(this::processSelection);
		
		//same as above:
		mealplan = new ChoiceBox<String>();
		mealplan.getItems().addAll(meaplist);
		mealplan.getSelectionModel().select(0);
		mealplan.setOnAction(this::processSelection);
		
		//this is where the total cost will appear:
		textfield = new TextField();
		textfield.setPrefWidth(250);
		//default text set in advance:
		textfield.setText("Total Cost: $0.00");
		
		GridPane gridPane = new GridPane();
		//add and centre align the labels:
		gridPane.add(dorms, 0, 0, 1, 1);
		GridPane.setHalignment(dorms, HPos.CENTER);
		gridPane.add(meaps, 1, 0, 1, 1);
		GridPane.setHalignment(meaps, HPos.CENTER);
		gridPane.add(dormitory, 0, 2, 1, 1);
		gridPane.add(mealplan, 1, 2, 1, 1);
		gridPane.add(textfield, 0, 3, 3, 1);
		
		Scene scene = new Scene(gridPane);
		
		primaryStage.setTitle("DormMealComp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	} //end start
	
	//--------------------------------------------------------------------------
	//	Updates TextField according to changes made by the user 
	//--------------------------------------------------------------------------
	public void processSelection(ActionEvent event)
    {
		DecimalFormat fmt = new DecimalFormat("#0.00"); //two decimal points
		
		//arrays with pricing:
		double[] dormprice = {0.00, 1800.00, 2000.00, 2800.00, 3000.00};
		double[] meapprice = {0.00, 600.00, 1000.00, 1800.00};
		double dTotalCost = 0.00;
		
		//translates selected index into associated price and sets variable
		dTotalCost = dormprice[(dormitory.getSelectionModel()
			.getSelectedIndex())] + meapprice[(mealplan.getSelectionModel()
				.getSelectedIndex())];
		
		//sets TextField with updated total cost
		textfield.setText("Total Cost: $" + fmt.format(dTotalCost));
    }
	
	//--------------------------------------------------------------------------
	//	<<main method>>
	//--------------------------------------------------------------------------
	public static void main(String[] args)
	{
		Application.launch(args);
		
	} //end main

} //end class

