import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class viewNotesController implements Initializable{


    @FXML
    private TextField notes;

    @FXML
    private TextField addNote;

    @FXML
    void toNewNote(ActionEvent event) throws IOException {
        Parent newNoteParent = FXMLLoader.load(getClass().getResource("newNote.fxml"));
        Scene newNoteScene = new Scene(newNoteParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newNoteScene);
        window.show();
    }

    @FXML
    void toMainMenu1(ActionEvent event) throws IOException {
        Parent newNoteParent = FXMLLoader.load(getClass().getResource("physicianMenu.fxml"));
        Scene newNoteScene = new Scene(newNoteParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newNoteScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}