import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class viewRegFormController implements Initializable{

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
    private TextField patientID1;
    
    @FXML
    void toRegHome(ActionEvent event) throws IOException {
        Parent regHomeParent = FXMLLoader.load(getClass().getResource("regHome.fxml"));
        Scene regHomeScene = new Scene(regHomeParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(regHomeScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name = Main.patient.getName();
        String[] nameSplit = name.split(" ");
        firstName1.setText(nameSplit[0]);
        lastName1.setText(nameSplit[1]);

        dateOfBirth1.setText(Main.patient.getDateOfBirth());
        address1.setText(Main.patient.getAddress());
        city1.setText(Main.patient.getCity());
        state1.setText(Main.patient.getState());
        phoneNumber1.setText(Main.patient.getPhone());
        insuranceProvider1.setText(Main.patient.getInsuranceProvider());
        primaryPhysician1.setText(Main.patient.getPrimaryPhysician());
        emergContactName1.setText(Main.patient.getEmergencyContactName());
        emergPhoneNumber1.setText(Main.patient.getEmergencyContactNumber());
        reasonForVisit1.setText(Main.patient.getSymptoms());
        insuranceID1.setText(Main.patient.getInsuranceID());
        currentMeds1.setText(Main.patient.getMedicationName());
        medHistory1.setText(Main.patient.getMedicalHistory());
        dateOfVisit1.setText(Main.patient.getDateOfVisit());
    }
}
