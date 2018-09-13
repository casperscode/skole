package paint;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import java.util.logging.Logger;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import javax.imageio.ImageIO;

//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;

public class hus extends Application{

	Stage window;
	
	Rectangle rect1;
	Polygon poly1;
	Ellipse cirk1;
	Line line1;
	GraphicsContext gc;
	ColorPicker cpl = new ColorPicker();
	ColorPicker cpf = new ColorPicker();
	Canvas canvas = new Canvas(720, 700);
	Pane pane;
	
	List<Double> stepsX = new ArrayList<>();
	List<Double> stepsY = new ArrayList<>();
	
	
	
	//private final LinkedList<Point2D> centers = new LinkedList<>();
	int oCnt = -1;
	
	int lc = 0;
	int thick = 1;
	
	Color stroke;
	Color fill;
	
	static final double BORDER_RADIUS = 4;
	
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Paint v. 0.000001");
				
		stroke = Color.BLACK;
		fill = Color.CORNFLOWERBLUE;
		
		
		pane = new Pane();
		pane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		pane.setPadding(new Insets(20,20,20,20));
		pane.setPrefSize(720, 700);
		pane.setBorder(createBorder());
		
		
		gc = canvas.getGraphicsContext2D();
		
		cpl.setValue(Color.BLACK);
		cpl.setOnAction(e -> {
			gc.setStroke(cpl.getValue());
		});
		
		cpf.setValue(Color.BLACK);
		cpf.setOnAction(e -> {
			gc.setFill(cpf.getValue());
		});
		
		GridPane menu = new GridPane();
		menu.setVgap(8);
		menu.setHgap(10);
		menu.setPadding(new Insets(10,10,10,10));
		
		Label lbl = new Label();
		lbl.setText("PAINT");
		lbl.setFont(Font.font("Courier", 18));
		
		//Linje
		TextField l1 = new TextField();
		l1.setMaxWidth(50);
		l1.setPromptText("x1");
		TextField l2 = new TextField();
		l2.setMaxWidth(50);
		l2.setPromptText("y1");
		TextField l3 = new TextField();
		l3.setMaxWidth(50);
		l3.setPromptText("x2");
		TextField l4 = new TextField();
		l4.setMaxWidth(50);
		l4.setPromptText("y2");
		
		
		
		//Cirkel
		TextField c1 = new TextField();
		c1.setMaxWidth(50);
		c1.setPromptText("x");
		TextField c2 = new TextField();
		c2.setMaxWidth(50);
		c2.setPromptText("y");
		TextField c3 = new TextField();
		c3.setMaxWidth(50);
		c3.setPromptText("xr");
		TextField c4 = new TextField();
		c4.setMaxWidth(50);
		c4.setPromptText("yr");
		
		//trekant
		TextField t1 = new TextField();
		t1.setMaxWidth(50);
		t1.setPromptText("x1");
		TextField t2 = new TextField();
		t2.setMaxWidth(50);
		t2.setPromptText("y1");
		TextField t3 = new TextField();
		t3.setMaxWidth(50);
		t3.setPromptText("x2");
		TextField t4 = new TextField();
		t4.setMaxWidth(50);
		t4.setPromptText("y2");
		TextField t5 = new TextField();
		t5.setMaxWidth(50);
		t5.setPromptText("x3");
		TextField t6 = new TextField();
		t6.setMaxWidth(50);
		t6.setPromptText("y3");
		
		//Firkant
		TextField f1 = new TextField();
		f1.setMaxWidth(50);
		f1.setPromptText("x");
		TextField f2 = new TextField();
		f2.setMaxWidth(50);
		f2.setPromptText("y");
		TextField f3 = new TextField();
		f3.setMaxWidth(50);
		f3.setPromptText("l");
		TextField f4 = new TextField();
		f4.setMaxWidth(50);
		f4.setPromptText("h");
		
		//Knapper
		Button b1 = new Button("Tegn Linje");
		b1.setMinWidth(110);
		b1.setOnAction(e -> {
			
			
			int x1;
			int y1;
			int x2;
			int y2;
			
			x1 = Integer.parseInt(l1.getText());
			y1 = Integer.parseInt(l2.getText());
			x2 = Integer.parseInt(l3.getText());
			y2 = Integer.parseInt(l4.getText());
			
			
			//	centers.add(new Point2D(x1, y1));
			
			gc.setLineWidth(1.5);
			gc.strokeLine(x1, y1, x2, y2);
			gc.stroke();
					
			oCnt++;
			
			l1.clear();
			l2.clear();
			l3.clear();
			l4.clear();
		});
		
		Button b2 = new Button("Tegn Cirkel");
		b2.setMinWidth(110);
		b2.setOnAction(e -> {
			
			double x;
			double y;
			double r;
			double r2;
			
			x = Integer.parseInt(c1.getText());
			y = Integer.parseInt(c2.getText());
			r = Integer.parseInt(c3.getText());
			r2 = Integer.parseInt(c4.getText());
			
			
			gc.setLineWidth(2.0);
			
			if(cpf.getValue() != Color.BLACK) {
				gc.fillOval(x, y, r, r2);
				gc.strokeOval(x, y, r, r2);
				gc.stroke();
				oCnt++;
			}
			else {
				gc.strokeOval(x, y, r, r2);
				gc.stroke();
				oCnt++;
			}
																				
			c1.clear();
			c2.clear();
			c3.clear();
			c4.clear();
		});
		
		Button b3 = new Button("Tegn Trekant");
		b3.setMinWidth(110);
		b3.setOnAction(e -> {
			
			double x1;
			double x2;
			double x3;
			double y1;
			double y2;
			double y3;
			
			x1 = Integer.parseInt(t1.getText());
			y1 = Integer.parseInt(t2.getText());
			x2 = Integer.parseInt(t3.getText());
			y2 = Integer.parseInt(t4.getText());
			x3 = Integer.parseInt(t5.getText());
			y3 = Integer.parseInt(t6.getText());
			
			 
			gc.setLineWidth(2.0);
			
			if(cpf.getValue() != Color.BLACK) {
				gc.fillPolygon(new double[]{x1, x2, x3}, new double[]{y1, y2, y3}, 3);
				gc.strokePolygon(new double[]{x1, x2, x3}, new double[]{y1, y2, y3}, 3);
				oCnt++;
			}
			else {
				gc.strokePolygon(new double[]{x1, x2, x3}, new double[]{y1, y2, y3}, 3);
				oCnt++;
			}
			
			t1.clear();
			t2.clear();
			t3.clear();
			t4.clear();
			t5.clear();
			t6.clear();
		});
		
		Button b4 = new Button("Tegn Firkant");
		b4.setMinWidth(110);
		b4.setOnAction(e -> {
			
			oCnt++;
			int x;
			int y;
			int l;
			int h;
			
			x = Integer.parseInt(f1.getText());
			y = Integer.parseInt(f2.getText());
			l = Integer.parseInt(f3.getText());
			h = Integer.parseInt(f4.getText());
			
			gc.setLineWidth(2.0);
			
			if(cpf.getValue() != Color.BLACK) {
				gc.fillRect(x, y, l, h);
				gc.strokeRect(x, y, l, h);
				gc.stroke();
			}else {
				gc.strokeRect(x, y, l, h);
				gc.stroke();
			}
					
			f1.clear();
			f2.clear();
			f3.clear();
			f4.clear();
		});
		
		Button b5 = new Button("Ny");
		b5.setMinWidth(50);
		b5.setOnAction(e ->	ny());
		
		Button b6 = new Button("Undo");
		b6.setMinWidth(50);
		b6.setOnAction(	e -> {
			
			double[] arrX = stepsX.stream().mapToDouble(Double::doubleValue).toArray(); //via method reference
			double[] arrY = stepsY.stream().mapToDouble(Double::doubleValue).toArray(); //identity function, Java unboxes automatically to get the double value
			
				
			int n = stepsX.size();
			Arrays.toString(arrX);
			Arrays.toString(arrY);
			
			gc.setStroke(Color.WHITE);
			gc.strokePolyline(arrX, arrY, n);
			gc.stroke();

			System.out.println(Arrays.toString(arrX));
		});
		
		Button b7 = new Button("Gem");
		b7.setPrefWidth(70);
		b7.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                 
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);
               
                //Show save file dialog
                File file = fileChooser.showSaveDialog(primaryStage);
                 
                if(file != null){
                    try {
                        WritableImage writableImage = new WritableImage(720, 700);
                        canvas.snapshot(null, writableImage);
                        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                        ImageIO.write(renderedImage, "png", file);
                    } catch (IOException ex) {
                        Logger.getLogger(hus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
             
        });
		
		//Grid arrangement
		GridPane.setConstraints(lbl, 0, 0);
		
		//Linje
		GridPane.setConstraints(b1, 6, 1);
		GridPane.setConstraints(l1, 0, 1);
		GridPane.setConstraints(l2, 1, 1);
		GridPane.setConstraints(l3, 2, 1);
		GridPane.setConstraints(l4, 3, 1);
		
		//Cirkel
		GridPane.setConstraints(b2, 6, 2);
		GridPane.setConstraints(c1, 0, 2);
		GridPane.setConstraints(c2, 1, 2);
		GridPane.setConstraints(c3, 2, 2);
		GridPane.setConstraints(c4, 3, 2);
		
		//trekant
		GridPane.setConstraints(b3, 6, 3);
		GridPane.setConstraints(t1, 0, 3);
		GridPane.setConstraints(t2, 1, 3);
		GridPane.setConstraints(t3, 2, 3);
		GridPane.setConstraints(t4, 3, 3);
		GridPane.setConstraints(t5, 4, 3);
		GridPane.setConstraints(t6, 5, 3);
		
		//firkant
		GridPane.setConstraints(b4, 6, 4);
		GridPane.setConstraints(f1, 0, 4);
		GridPane.setConstraints(f2, 1, 4);
		GridPane.setConstraints(f3, 2, 4);
		GridPane.setConstraints(f4, 3, 4);
		
		//Knapper
		GridPane.setConstraints(b5, 6, 6);
		GridPane.setConstraints(b6, 6, 7);
		
		//TEST//
		CubicCurve curv1 = new CubicCurve();
		
		
		
		menu.setMinWidth(300);
		menu.getChildren().addAll(b1, b2, b3, b4, b6, l1, l2, l3, l4, c1, c2, c3, c4, t1, t2, t3, t4, t5, t6, f1, f2, f3, f4, lbl);
				
		HBox menu2 = new HBox();
		menu2.setPadding(new Insets(10,10,10,10));
		menu2.setSpacing(8);
		
		//Settings
		TextField setFill = new TextField();
		setFill.setMaxWidth(100);
		setFill.setPromptText("Vælg fylde farve");
		
		TextField setLine = new TextField();
		setFill.setMaxWidth(100);
		setFill.setPromptText("Vælg linje farve");
					
		Label lineLabel = new Label("Linje farve");
		lineLabel.setFont(new Font("Bold Courier New", 14));
		Label cbLabel = new Label("fylde farve");
		cbLabel.setFont(new Font("Bold Courier New", 14));
			
		menu2.getChildren().addAll(lineLabel, cpl, cbLabel, cpf, b7, b5);
		
		BorderPane bPane = new BorderPane();
		bPane.setTop(null);
		bPane.setBottom(menu2);
		bPane.setLeft(menu);
		bPane.setCenter(pane);
		bPane.setRight(null);
		
		
		pane.getChildren().add(canvas);
		Scene scene = new Scene(bPane, 1200, 750);
		
		//Mus
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, 
                new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
            	scene.setOnMousePressed(e -> {
					gc.beginPath();
					gc.lineTo(e.getSceneX()-490, e.getSceneY());
					gc.stroke();
					stepsX.add(e.getSceneX()-490);
					stepsY.add(e.getSceneY());
				});
					
				scene.setOnMouseDragged(e -> {
					//gc.beginPath();
					gc.lineTo(e.getSceneX()-490, e.getSceneY());
					gc.stroke();
					stepsX.add(e.getSceneX()-490);
					stepsY.add(e.getSceneY());
				});
				
				
				scene.setOnMouseReleased(e -> {
					
				});
				
				oCnt++;
            }
        });
				
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	private void err1() {
		Boolean answer = ConfirmBox.display("Error", "Point out of bounds");
	}
	*/
	
	static Border createBorder() {
	    return new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(BORDER_RADIUS), BorderStroke.THIN));
	}

	public void ny() {
		gc.clearRect(0, 0, 720, 700);
	}

}


