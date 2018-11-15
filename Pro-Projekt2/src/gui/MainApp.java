package gui;



import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.YatzyDice;

public class MainApp extends Application {
    private final Controller controller = new Controller();
        
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 473, 600);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // Shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // Shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final TextField[] txfResults = new TextField[15];
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField(), txfBonus = new TextField(),
            txfSumOther = new TextField(), txfTotal = new TextField();

    // Label Array
    private final Label[] lbls = new Label[15];
    
    private final Label lblRolled = new Label();
    private final Button button = new Button(" Roll ");
    
    boolean[] bools = new boolean[5];
    boolean[] isScorable = new boolean[15];
    boolean[] elegible = new boolean[15];
    private boolean hasSelectedScore = false;
    private int sameSum;
    private int bonus = 0;
    private int sumOther;
    private int total;
    private boolean hasRolled;
    private Label cnt = new Label();

    private void initContent(GridPane pane) {
    	
    	Arrays.fill(elegible, Boolean.FALSE);
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
  
        // BackgroundImage myBI= new BackgroundImage(new Image("file:C:\\Users\\Casper\\Documents\\GitHub\\skole\\skole\\Pro-Projekt2\\src\\gui\\BG3.png",473, 600,false,true),
        // BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        // 
        // pane.setBackground(new Background(myBI));
                   
        

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        //dicePane.setGridLinesVisible(true);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(20);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");
        dicePane.setStyle("-fx-border-style: solid");
        //dicePane.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        dicePane.setPrefSize(480, 125);
           
        Separator sp = new Separator();
                
        for(int i=0; i < 5; i++) {  
        	txfValues[i] = new TextField();
        	txfValues[i].setPrefSize(70, 70);
        	//txfValues[i].setPromptText("0");
        	txfValues[i].setAlignment(Pos.CENTER);
        	txfValues[i].setEditable(false);
        	txfValues[i].setStyle("-fx-control-inner-background: cornflowerblue");
        	txfValues[i].setFont(Font.font("Curier new", FontWeight.BOLD, 36));
        	cbxHolds[i] = new CheckBox();
        	cbxHolds[i].setText("Keep");
        	cbxHolds[i].setFont(Font.font("Curier new",FontWeight.BOLD, 14));
        	
        	dicePane.add(cbxHolds[i], i, 1);
        	dicePane.add(txfValues[i], i, 0);
        }
       
        sp.setPrefWidth(430);
                     
        lblRolled.setText("Throw Count:");
        lblRolled.setFont(Font.font("Curier new",FontWeight.BOLD, 12));
        cnt.setText(" "+Integer.toString(controller.dice.getThrowCount()));
        cnt.setFont(Font.font("Curier new",FontWeight.BOLD, 12));
        
        
      
        button.setOnAction(e -> controller.rollButton());
                
        
        dicePane.add(button, 4, 3);
        dicePane.add(sp, 0, 2, 5, 1);
        dicePane.add(lblRolled, 2, 3, 2, 1);
        dicePane.add(cnt, 3, 3, 1, 1);
        
        // add txfValues, chbHolds, lblRolled and btnRoll
        // TODO

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        // scorePane.setGridLinesVisible(true);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(8);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        scorePane.setPrefSize(480, 565);
        int w = 50; // width of the text fields
       
        for (int i = 0; i < 15; i++) {
        	txfResults[i] = new TextField();
        	lbls[i] = new Label();
        	lbls[i].setAlignment(Pos.CENTER);
        	lbls[i].setFont(Font.font("Curier new",FontWeight.BOLD, 14));
        	txfResults[i].setEditable(false);
        	txfResults[i].setPrefWidth(w);
        	txfResults[i].setStyle("-fx-control-inner-background: orange");
        	
        	if(i < 6) {
        		scorePane.add(lbls[i], 1, i);
        		scorePane.add(txfResults[i], 2, i);
        	}else {
        		scorePane.add(lbls[i], 5, i-6);
        		scorePane.add(txfResults[i], 6, i-6);
        	}
        	
        	txfResults[i].setOnMouseClicked(event -> controller.mouseClicked(event));
        }
     
        
        // Ops�tning af de fire nederste kasser til sum, bonus, sum og total  
        scorePane.add(txfSumSame, 2, 10);
        scorePane.add(txfBonus, 2, 11);
        scorePane.add(txfSumOther, 6, 10);
        scorePane.add(txfTotal, 6, 11);
        txfSumSame.setPrefWidth(w);
        txfBonus.setPrefWidth(w);
        txfSumOther.setPrefWidth(w);
        txfTotal.setPrefWidth(w);
        txfSumSame.setEditable(false);
        txfBonus.setEditable(false);
        txfSumOther.setEditable(false);
        txfTotal.setEditable(false);
        txfSumSame.setText(Integer.toString(sameSum));
        txfBonus.setText(Integer.toString(bonus));
        txfSumOther.setText(Integer.toString(sumOther));
        txfTotal.setText(Integer.toString(total));
        Label lblSS = new Label("Sum:");
        Label lblB = new Label("Bonus:");
        Label lblSO = new Label("Sum:");
        Label lblT = new Label("Total:");
        lblSS.setFont(Font.font("Curier new",FontWeight.BOLD, 14));
        lblB.setFont(Font.font("Curier new",FontWeight.BOLD, 14));
        lblSO.setFont(Font.font("Curier new",FontWeight.BOLD, 14));
        lblT.setFont(Font.font("Curier new",FontWeight.BOLD, 14));
        scorePane.add(lblSS, 1, 10);
        scorePane.add(lblB, 1, 11);
        scorePane.add(lblSO, 5, 10);
        scorePane.add(lblT, 5, 11);
        txfSumSame.setStyle("-fx-control-inner-background: orange");
        txfBonus.setStyle("-fx-control-inner-background: orange");
        txfSumOther.setStyle("-fx-control-inner-background: orange");
        txfTotal.setStyle("-fx-control-inner-background: orange");
        
        // ops�tning af labels
        lbls[0].setText("1's:");
        lbls[1].setText("2's:");
        lbls[2].setText("3's:");
        lbls[3].setText("4's:");
        lbls[4].setText("5's:");
        lbls[5].setText("6's:");
            
        lbls[6].setText("One Pair:");
        lbls[7].setText("Two Pair:");
        lbls[8].setText("Three Same:");
        lbls[9].setText("Four Same:");
        lbls[10].setText("Full House:");
        lbls[11].setText("Small Str:");
        lbls[12].setText("Large Str:");
        lbls[13].setText("Chance:");
        lbls[14].setText("Yatzy:");
             
        // add labels for results, add txfResults,
        // add labels and text fields for sums, bonus and total.
        // TODO
        controller.reset();
    }

    // -------------------------------------------------------------------------

    private class Controller {
        private YatzyDice dice = new YatzyDice();
		private int counter = 0;

        
        
        private void reset()
        {
        	for (int i=0;i<15;i++)
        	{
        		isScorable[i]=true;
        		txfResults[i].clear();
        		
        		if(i < 5) {
        			cbxHolds[i].setDisable(true);
        			txfValues[i].clear();
        		}
        	}
        	dice.resetThrowCount();
        	sameSum = 0;
        	sumOther = 0;
        	bonus = 0;
        	counter = 0;        	
        }
        
        private void selectScore()
        {
        	counter++;
        	hasSelectedScore=true;
        	dice.resetThrowCount();
        	cnt.setText(" "+Integer.toString(dice.getThrowCount()));
        	
        	
        	if(sameSum >= 63)
        	{
        		bonus = 50;
        		txfBonus.setText(""+bonus);
        	}
        	for(int i=0;i<5;i++)
        	{
        		cbxHolds[i].setSelected(false);
        		txfValues[i].clear();
        		cbxHolds[i].setDisable(true);
        	}
        	
        	for (int i = 0; i < 15; i++) {
        		if(isScorable[i])        			
        			txfResults[i].setStyle("-fx-control-inner-background: orange");
        		
        	}
        	
        	hasRolled= false;
        	
        	if(counter > 14) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setContentText("You have finished the game. Your score was:" +total);
        		alert.setTitle("Game Over");
        		alert.showAndWait();
        		reset();
        	}
        }

        // Create a method for btnRoll's action.
        // Hint: Create small helper methods to be used in the action method.
        // TODO
        private void mouseClicked(MouseEvent event) 
        {
            TextField txf = (TextField) event.getSource();
           
	     for(int i=0; i<15;i++)
	     {     
	    	 if(hasRolled) {
	    		 
	    		 if (!hasSelectedScore) {
	    			 
	    			 if(isScorable[i]) {
	    				 
	    				 if(txf== txfResults[i]) {
			    		
		    				 if (i<6) {
		    					 txf.setText(Integer.toString(dice.sameValuePoints(i+1)));
				    			 sameSum += dice.sameValuePoints(i+1);
				    			 selectScore();	    			 
				         	 }
				    		 
				    		 if(i==6) {
				    			txf.setText(""+dice.onePairPoints()); 
				    			sumOther += dice.onePairPoints();
				    			selectScore();
				    		 }
				    		 
				    		 if(i==7) {
				    			 txf.setText(""+ dice.twoPairPoints());
				    	   		 sumOther += dice.twoPairPoints();
				    			 selectScore();
				    		 }
				    		 
				    		 if(i==8) {
				    			 txf.setText(""+dice.threeSamePoints());
				    	   		 sumOther += dice.threeSamePoints();
				    			 selectScore();
				    		 }
				    		 
				    		 if(i==9) {
				    			 txf.setText(""+dice.fourSamePoints());
				    	   		 sumOther += dice.fourSamePoints();
				    			 selectScore();
				    		 }
				    		 
				    		 if(i==10) {
				    			 txf.setText(""+dice.fullHousePoints());
				    	   		 sumOther += dice.fullHousePoints();
				    			 selectScore();
				    		 }
				    		 
				    		 if(i==11) {
				    			 txf.setText(""+dice.smallStraightPoints());
				    	   		 sumOther += dice.smallStraightPoints();
				    			 selectScore();
				    		 }
				    		 
				    		 if(i==12) {
				    			 txf.setText(""+dice.largeStraightPoints());
				    	   		 sumOther += dice.largeStraightPoints();
				    			 selectScore();
				    		 }
				    		 
				    		 if(i==13) {
				    			 txf.setText(""+dice.chancePoints());
				    	   		 sumOther += dice.chancePoints();
				    			 selectScore();
				    		 }
				    		 
				    		 if(i==14) {
				    			 txf.setText(""+dice.yatzyPoints());
				    			 sumOther += dice.yatzyPoints();
				    			 selectScore();
				    		 }
				    			 
				    		 isScorable[i]=false;
				    		 
				    		 for(int e = 0; e < 15; e++) {
				    			 
				    			 if(isScorable[e]) {
				    				 txfResults[e].clear();
				    			 }
				    		 }
				        }
			   		 }
			     }
	    	  }
	    	 
	     txfSumSame.setText(""+sameSum);
	     txfSumOther.setText(""+sumOther);
	     total = sameSum+sumOther +bonus;
	     txfTotal.setText(""+total);
	     }           
	   }
        
        
        private void rollButton() {
        	hasRolled = true;
        	hasSelectedScore = false;
        	        	
        	if(dice.getThrowCount()<3) {
        	
        		cnt.setText(" "+Integer.toString(dice.getThrowCount()+1));
        		
        		for (int i=0;i<5;i++) {   			
        			cbxHolds[i].setDisable(false);
        			bools[i] = cbxHolds[i].isSelected();
        			
        			if( cbxHolds[i].isSelected())
        				cbxHolds[i].setDisable(true);
        		}
        		
        		dice.throwDice(bools);
        		
        		for(int i=0;i<5;i++) {
        			int[] values = dice.getValues();
        			txfValues[i].setText( ""+values[i]);
        	   	}
        		
        	
	        	for(int i = 0; i < 15; i++) {
	        			        			        		
	        		if(i<6) {
	        			if(dice.sameValuePoints(i+1) != 0) {	        				
	        				
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.sameValuePoints(i+1)));	
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        				if(isScorable[i])
	        					txfResults[i].setText("");
	        				}
	        			}
	        		
	        		
	        		if(i == 6) {
	        			if(dice.onePairPoints() != 0) {
	        				
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.onePairPoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 7) {
	        			if(dice.twoPairPoints() != 0) {
	        				
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.twoPairPoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 8) {
	        			if(dice.threeSamePoints() != 0 ) {
	        				
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.threeSamePoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 9) {
	        			if(dice.fourSamePoints() !=0 ) {
	        			
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.fourSamePoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 10) {
	        			if(dice.fullHousePoints() != 0) {
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.fullHousePoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 11) {
	        			if(dice.smallStraightPoints() == 15) {
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.smallStraightPoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 12) {
	        			if(dice.largeStraightPoints() == 20) {
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.largeStraightPoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 13) {
	        			if(dice.chancePoints() != 0) {
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.chancePoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}
	        		
	        		if(i == 14) {
	        			       		
	        			if(dice.yatzyPoints() != 0) {
	        				if(isScorable[i]) {
	        					txfResults[i].setStyle("-fx-control-inner-background: lightgreen");
	        					txfResults[i].setText(Integer.toString(dice.yatzyPoints()));
	        				}
	        			}else {
	        				txfResults[i].setStyle("-fx-control-inner-background: orange");
	        			}
	        		}else {
	        			
	        		}       		
	        	}
        	
        	}
        }
        	
        // Create a method for btnRoll's action.
        // Hint: Create small helper methods to be used in the action method.
        // TODO

        // -------------------------------------------------------------------------

        // Create a method for mouse click on one of the text fields in txfResults.
        // Hint: Create small helper methods to be used in the mouse click method.
        // TODO
    }
}
  	

