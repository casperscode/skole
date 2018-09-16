package testElemts;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.management.monitor.Monitor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class mouseStuff extends Application {

	int SIZE_W;
	int SIZE_H;
	int CSIZE_W;
	int CSIZE_H;
	
	double xC;
	double yC;
	
	Stage window;
	
	Pane pane = new Pane();
	Canvas canvas = new Canvas();
	Scene scene;
	BorderPane bPane = new BorderPane();;
	MenuBar vBox1 = new MenuBar();
	HBox hBox = new HBox();
	Menu file = new Menu("File");
	Menu help = new Menu("Help");
	MenuItem new1 = new MenuItem();
	MenuItem open = new MenuItem();
	MenuItem save = new MenuItem();
	MenuItem exit = new MenuItem();
	MenuItem about = new MenuItem();
	SeparatorMenuItem space = new SeparatorMenuItem();
	SeparatorMenuItem space2 = new SeparatorMenuItem();
	Label xcord = new Label("X-Coordinate");
	Label ycord = new Label("Y-Coordinate");
	GraphicsContext gc;
	ColorPicker cp = new ColorPicker();
	
	
	
	final FileChooser fileChooser = new FileChooser();
	
	//Image img = new Image();
	
	private static final String OUTSIDE_TEXT = "Mouse position ";
		
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("mouse stuff");
		
		SIZE_W = 600;
		SIZE_H = 600;
		canvas.setWidth(600);
		canvas.setHeight(600);
		
		//img = /res/BG.png;
		//pane.setBackground(new Background(new BackgroundImage(BG.png, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null)));
		
		gc = canvas.getGraphicsContext2D();
		
		cp.setOnAction(e -> {
			gc.setStroke(cp.getValue());
		}); 
		
		
		window.widthProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
		        System.out.println("Width: " + newSceneWidth);
		        CSIZE_W = (int) observableValue.getValue();
		        SIZE_W = (int) observableValue.getValue();
		        System.out.println(observableValue);
		    }
		});
		
		window.heightProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
		        System.out.println("Height: " + newSceneHeight);
		        CSIZE_H = (int) observableValue.getValue();
		        SIZE_H = (int) observableValue.getValue();
		        System.out.println(observableValue);
		    }
		});
		
		final Label reporter = new Label(OUTSIDE_TEXT);
		
		vBox1.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		vBox1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(1), BorderStroke.THIN)));
		vBox1.setPadding(new Insets(0,0,0,0));
		
		
		//bPane.addEventHandler();
		
		bPane.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
            	String msg = "X: " + event.getX() + ", Y: " + (event.getY()-25) + " ";
    	        reporter.setText(msg);
            	}
            });
		
		
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
            	scene.setOnMousePressed(e -> {
            		gc.setLineWidth(1.5);
					gc.beginPath();
					gc.lineTo(e.getSceneX(), e.getSceneY()-25);
					gc.stroke();
					//stepsX.add(e.getSceneX()-490);
					//stepsY.add(e.getSceneY()-24);
				});
					
				scene.setOnMouseDragged(e -> {
					gc.setLineWidth(1.5);
					gc.lineTo(e.getSceneX(), e.getSceneY()-25);
					gc.stroke();
					//stepsX.add(e.getSceneX()-490);
					//stepsY.add(e.getSceneY()-24);
				});
				
            }
        });
		
			
		
		hBox.setSpacing(10);
		hBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
		hBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), BorderStroke.THIN)));
		hBox.setAlignment(Pos.BASELINE_CENTER);
		
		new1.setText("New");
		new1.setOnAction(e -> ny());
		open.setText("Open");
		open.setOnAction((final ActionEvent e) -> openF());
		save.setText("Save");
		save.setOnAction(e -> save());
		exit.setText("Exit");
		exit.setOnAction(e -> Platform.exit());
		
		about.setText("About");
		
		
		help.getItems().addAll(about);
		file.getItems().addAll(new1, space, save,  open, space2, exit);
		vBox1.getMenus().addAll(file, help);
		hBox.getChildren().addAll(cp, reporter);
		pane.getChildren().add(canvas);
		bPane.setTop(vBox1);
		bPane.setCenter(pane);
		bPane.setBottom(hBox);
		scene = new Scene(bPane, SIZE_W, SIZE_H);
		window.setScene(scene);
		window.show();
	}
	
	
	//Main
	public static void main(String[] args) { launch(args); }
	
	
	public void openF()	{
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
           // openFile(file);

           // where my problem is 
            Image image1 = new Image(file.toURI().toString());
            // what I tried to do
                // Image image1 = new Image(file);
            ImageView ip = new ImageView(image1);
            BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        }
        
    }
	
	public void save() {
		FileChooser fileChooser = new FileChooser();
        
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
       
        //Show save file dialog
        File file = fileChooser.showSaveDialog(window);
         
        if(file != null){
            try {
                WritableImage writableImage = new WritableImage(CSIZE_W, CSIZE_H);
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                Logger.getLogger(mouseStuff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
	
	public void ny() {
		gc = null;
		gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, CSIZE_W, CSIZE_H);
		
	}
	
}
	