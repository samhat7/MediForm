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

public class orderMedsController implements Initializable{


    @FXML
    private TextField pain;

    @FXML
    private TextField antiCoagulant;

    @FXML
    private TextField betaBlocker;

    @FXML
    private TextField antiRetroviral;

    @FXML
    private TextField insulin;

    @FXML
    private TextField antiInflammatory;

    @FXML
    private TextField ursodiol;

    @FXML
    private TextField calciumReducer;

    @FXML
    void orderMeds(ActionEvent event) throws IOException {
        Main.patient.setPain(Main.patient.getPain() + Integer.parseInt(pain.getText()));
        Main.patient.setAnticoagulant(Main.patient.getAnticoagulant() + Integer.parseInt(antiCoagulant.getText()));
        Main.patient.setBetaBlocker(Main.patient.getBetaBlocker() + Integer.parseInt(betaBlocker.getText()));
        Main.patient.setAntiretroviral(Main.patient.getAntiretroviral() + Integer.parseInt(antiRetroviral.getText()));
        Main.patient.setInsulin(Main.patient.getInsulin() + Integer.parseInt(insulin.getText()));
        Main.patient.setAntiInflammatory(Main.patient.getAntiInflammatory() + Integer.parseInt(antiInflammatory.getText()));
        Main.patient.setUrsodiol(Main.patient.getUrsodiol() + Integer.parseInt(ursodiol.getText()));
        Main.patient.setCalciumReducer(Main.patient.getCalciumReducer() + Integer.parseInt(calciumReducer.getText()));

        DatabaseInterface.updatePatient(Main.patient);

        Parent orderMedsParent = FXMLLoader.load(getClass().getResource("physicianMedicalForm.fxml"));
        Scene orderMedsScene= new Scene(orderMedsParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderMedsScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
