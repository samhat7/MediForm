import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class regNewPatientController implements Initializable {

    @FXML
    private TextField firstName1;

    @FXML
    private TextField lastName1;

    @FXML
    private TextField dateOfBirth1;

    @FXML
    private TextField address1;

    @FXML
    private TextField city1;

    @FXML
    private TextField state1;

    @FXML
    private TextField phoneNumber1;

    @FXML
    private TextField insuranceProvider1;

    @FXML
    private TextField primaryPhysician1;

    @FXML
    private TextField emergContactName1;

    @FXML
    private TextField emergPhoneNumber1;

    @FXML
    private TextField reasonForVisit1;

    @FXML
    private TextField insuranceID1;

    @FXML
    private TextField currentMeds1;

    @FXML
    private TextField medHistory1;
    
    @FXML
    private TextField dateOfVisit1;

    @FXML
    void submitRegForm(ActionEvent event) throws IOException {
        Patient patientInsert = new Patient(firstName1.getText(), lastName1.getText(), address1.getText(), city1.getText(), state1.getText(), phoneNumber1.getText(), emergContactName1.getText(), emergPhoneNumber1.getText(), insuranceProvider1.getText(), insuranceID1.getText(), primaryPhysician1.getText(), currentMeds1.getText(), medHistory1.getText(), reasonForVisit1.getText(), dateOfBirth1.getText(), dateOfVisit1.getText());

        DatabaseInterface.insertPatient(patientInsert);

        Parent regHomeParent = FXMLLoader.load(getClass().getResource("regHome.fxml"));
        Scene regHomeScene = new Scene(regHomeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(regHomeScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
