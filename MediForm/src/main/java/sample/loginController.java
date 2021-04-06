package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void toRegHome(ActionEvent event) throws IOException {
        Parent regHomeParent = FXMLLoader.load(getClass().getResource("toRegHome.fxml"));
        Scene regHomeScene = new Scene(regHomeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(regHomeScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

