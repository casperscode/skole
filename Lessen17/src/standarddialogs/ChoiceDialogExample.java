package standarddialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChoiceDialogExample extends Application {
    private Controller controller = new Controller();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Dialogs Example");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final Text txtStatus = new Text();

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(20);

        // header label
        Label lblHeader = new Label("Choice Dialog");
        pane.add(lblHeader, 0, 0);
        lblHeader.setTextFill(Color.DARKBLUE);
        lblHeader.setFont(Font.font("Calibri", FontWeight.BOLD, 36));

        // get choice button
        Button btnGetChoice = new Button("Get Choice");
        pane.add(btnGetChoice, 0, 1);
        GridPane.setHalignment(btnGetChoice, HPos.CENTER);
        btnGetChoice.setOnAction(event -> controller.getChoiceAction());

        // status text
        pane.add(txtStatus, 0, 3);
        txtStatus.setText("Selection: None");
        txtStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        txtStatus.setFill(Color.FIREBRICK);
    }

    private class Controller {
        public void getChoiceAction() {
            String[] arrayData = { "First", "Second", "Third", "Fourth" };
            ArrayList<String> dialogData = new ArrayList<>();
            dialogData.addAll(Arrays.asList(arrayData));

            ChoiceDialog<String> dialog = new ChoiceDialog<String>(dialogData.get(0), dialogData);
            dialog.setTitle("ChoiceDialog");
            dialog.setHeaderText("Select your choice");

            Optional<String> result = dialog.showAndWait();
            // wait for the dialog to close

            String selected = "cancelled.";
            if (result.isPresent()) {
                selected = result.get();
            }
            txtStatus.setText("Selection: " + selected);
        }
    }

}