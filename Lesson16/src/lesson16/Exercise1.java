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

public class Exercise1 extends Application{
	
	Stage window;
	GridPane GP;
	Button B1;
	Label L1, L2, L3;
	TextField TF1, TF2, TF3;
	Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Exercise 1");
		GP = new GridPane();
		GP.setGridLinesVisible(false);
		GP.setVgap(8);
		GP.setHgap(10);
		GP.setAlignment(Pos.CENTER);
		GP.setPadding(new Insets(20,20,20,20));
		
		L1 = new Label();
		L2 = new Label();
		L3 = new Label();
		TF1 = new TextField();
		TF2 = new TextField();
		TF3 = new TextField();
		
		L1.setText("Fornavn");
		L2.setText("Efternavn");
		L3.setText("Fulde navn");
		TF1.setPromptText("Fornavn");
		TF2.setPromptText("Efternavn");
		TF3.setPromptText("Fulde navn");
		
		Button B1 = new Button("Kombiner");
		B1.setOnAction(e -> TF3.setText(TF1.getText()+" "+TF2.getText()));
		
		
		GridPane.setConstraints(L1, 1, 1);
		GridPane.setConstraints(L2, 2, 1);
		GridPane.setConstraints(TF1, 1, 2);
		GridPane.setConstraints(TF2, 2, 2);
		GridPane.setConstraints(L3, 1, 3);
		GridPane.setConstraints(TF3, 1, 4, 2, 1);
		GridPane.setConstraints(B1, 2, 5);
				
		
		GP.getChildren().addAll(L1,L2,L3,TF1,TF2,TF3,B1);
		scene = new Scene(GP, 400, 200);
		
		window.setResizable(false);
		window.setScene(scene);
		window.show();
		
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
