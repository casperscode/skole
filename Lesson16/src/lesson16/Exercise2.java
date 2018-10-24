package lesson16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise2 extends Application{
	
	Stage window;
	GridPane GP;
	Button B1, B2;
	Label L1;
	TextField TF1;
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
		
		L1 = new Label();
		TF1 = new TextField();
		
		L1.setText("Nummer:");
		TF1.setPromptText("Nummer");
		
		Button B1 = new Button("Plus");
		B1.setOnAction(e -> {
			String tmp = TF1.getText();
			int tmp1 = Integer.parseInt(tmp);
			tmp1++;			
			TF1.setText(String.valueOf(tmp1));
		});
		
		Button B2 = new Button("Minus");
		B2.setOnAction(e -> {
			String tmp = TF1.getText();
			int tmp1 = Integer.parseInt(tmp);
			tmp1--;			
			TF1.setText(String.valueOf(tmp1));
		});
		
		
		GridPane.setConstraints(L1, 1, 1);
		GridPane.setConstraints(TF1, 1, 2);

		GridPane.setConstraints(B1, 2, 1);
		GridPane.setConstraints(B2, 2, 2);
		
		GP.getChildren().addAll(L1,TF1,B1, B2);
		scene = new Scene(GP, 300, 100);
		
		window.setResizable(false);
		window.setScene(scene);
		window.show();
		
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}