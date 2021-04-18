import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    void loginUser(ActionEvent event) throws IOException {
        if(username.getText().length() == 0 || password.getText().length() == 0){
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setContentText("Username or Password field is empty.");
            alert1.showAndWait();
            return;
        }
        
        Main.user = DatabaseInterface.findUser(username.getText());

        //check entered pass against database pass
        if(!password.getText().equals(Main.user.getPassword()) || !username.getText().equals(Main.user.getUsername())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username or password was invalid. Please try again.");
            alert.showAndWait();
            return;
        }

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        switch(Main.user.getRoleID()) {
            case 1:              
                Parent regHomeParent = FXMLLoader.load(getClass().getResource("regHome.fxml"));
                Scene regHomeScene = new Scene(regHomeParent);
        
                window.setScene(regHomeScene);
                window.show();
                break;

            default:
                Parent enterIDParent = FXMLLoader.load(getClass().getResource("enterID.fxml"));
                Scene enterIDScene = new Scene(enterIDParent);
        
                window.setScene(enterIDScene);
                window.show();
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}

