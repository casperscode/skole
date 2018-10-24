package lesson16;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise3 extends Application{
	
	Stage window;
	GridPane GP;
	Button B1, B2;
	Label L1, L2, L3, L4;
	TextField TF1, TF2, TF3, TF4;
	Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Exercise 2");
		GP = new GridPane();
		GP.setGridLinesVisible(false);
		GP.setVgap(8);
		GP.setHgap(10);
		GP.setAlignment(Pos.CENTER);
		GP.setPadding(new Insets(20,20,20,20));
		
		L1 = new Label("Investment");
		L2 = new Label("Years");
		L3 = new Label("Interest");
		L4 = new Label("Future Value");
		TF1 = new TextField();
		TF2 = new TextField();
		TF3 = new TextField();
		TF4 = new TextField();
		
		TF1.setPromptText("Investment");
		TF2.setPromptText("Years");
		TF3.setPromptText("Interest");
		TF4.setPromptText("Future Value");
		
		Button B1 = new Button("Calculate");
		B1.setOnAction(e -> summing());
		
		
		GridPane.setConstraints(L1, 1, 1);
		GridPane.setConstraints(L2, 1, 2);
		GridPane.setConstraints(L3, 1, 3);
		GridPane.setConstraints(L4, 1, 6);
		GridPane.setConstraints(TF1, 2, 1);
		GridPane.setConstraints(TF2, 2, 2);
		GridPane.setConstraints(TF3, 2, 3);
		GridPane.setConstraints(TF4, 2, 6);
		GridPane.setConstraints(B1, 2, 4);

		
		GP.getChildren().addAll(L1,L2, L3, L4, TF1, TF2, TF3, TF4, B1);
		scene = new Scene(GP, 350, 250);
		
		window.setResizable(false);
		window.setScene(scene);
		window.show();
		
	}
	
		
	public static void main(String[] args) {
		launch(args);
	}
	
	public void summing() {
		double invest = Integer.parseInt(TF1.getText());
		double years = Integer.parseInt(TF2.getText());
		double interest = Integer.parseInt(TF3.getText());
		double sum = invest;
		
		  for (int i = 0; i < years; i++ ){
			  sum = sum*(1+interest/100);
		  }
		  
		TF4.setText(String.valueOf(sum));
	}

}