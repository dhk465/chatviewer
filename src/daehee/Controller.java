package daehee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import javax.crypto.spec.PSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


public class Controller {
    @FXML
    private Button openButton;
    @FXML
    private Label pathLabel;
    private File file;

    private Message msg;

    public void openFileChooser(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatviewer.fxml"));
        loader.setController(this);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Message File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Message Files", "*.msg"));
        file = fileChooser.showOpenDialog(((Node)actionEvent.getTarget()).getScene().getWindow());
        if (file != null) {
            msg = new Message(Paths.get(file.getAbsolutePath()));
            pathLabel.setText(msg.getMsgPath().toString());
            msg.getTextFromFile();
            try {
                msg.convertMsg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
