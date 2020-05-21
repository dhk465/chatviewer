package daehee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import java.io.File;


public class Controller {
    @FXML
    private TextFlow topTextFlow;
    @FXML
    private Label pathLabel;
    private File lastOpened = null;

    public void openFileChooser(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Message File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Message Files", "*.msg"));
        if (lastOpened != null) {
            fileChooser.setInitialDirectory(lastOpened.getParentFile());
        }
        File file = fileChooser.showOpenDialog(((Node) actionEvent.getTarget()).getScene().getWindow());
        if (file != null) {
            Message msg = new Message();
            Renderer renderer = new Renderer();
            pathLabel.setText(file.getPath());
            lastOpened = file;
            topTextFlow.getChildren().clear();
            try {
                msg.read(file);
                renderer.render(msg, topTextFlow);
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
                topTextFlow.getChildren().clear();
                pathLabel.setText("Path");
            }
        }
    }
}
