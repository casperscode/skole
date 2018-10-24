package standarddialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextInputDialogExample extends Application {
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

    public void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(20);

        // header label
        Label lblHeader = new Label("Text Input Dialog");
        pane.add(lblHeader, 0, 0);
        lblHeader.setTextFill(Color.DARKBLUE);
        lblHeader.setFont(Font.font("Calibri", FontWeight.BOLD, 36));

        // Button
        Button btnGetText = new Button("Get Text");
        pane.add(btnGetText, 0, 1);
        GridPane.setHalignment(btnGetText, HPos.CENTER);
        btnGetText.setOnAction(event -> controller.getTextAction());

        // Status message text
        pane.add(txtStatus, 0, 3);
        txtStatus.setText("No Text");
        txtStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        txtStatus.setFill(Color.FIREBRICK);
    }

    private class Controller {
        public void getTextAction() {
            TextInputDialog dialog = new TextInputDialog("Default Text");
            dialog.setTitle("TextInputDialog");
            dialog.setHeaderText("Enter some text, or use default value.");

            Optional<String> result = dialog.showAndWait();
            // wait for the dialog to close

            String entered = "none.";
            if (result.isPresent()) {
                entered = result.get();
            }
            txtStatus.setText("Text entered: " + entered);
        }
    }

}