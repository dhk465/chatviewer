package daehee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Controller {
    @FXML
    private Button openButton;
    @FXML
    private Label pathLabel;
    private Path path;
    private File file;

    Message msg;

    public void openFileChooser(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatviewer.fxml"));
        loader.setController(this);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Message File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Message Files", "*.msg"));
        file = fileChooser.showOpenDialog(((Node)actionEvent.getTarget()).getScene().getWindow());
        if (file != null) {
            path = Paths.get(file.getAbsolutePath());
            msg = new Message(path);
            pathLabel.setText(path.toString());
        }
    } // use of File legitimate?

    public Path getPath() {
        return path;
    }
}
