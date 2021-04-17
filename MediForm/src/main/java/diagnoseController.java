import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class diagnoseController implements Initializable {
    @FXML
    private CheckBox brokenBone;

    @FXML
    private CheckBox heartAttack;

    @FXML
    private CheckBox laceration;

    @FXML
    private CheckBox hivAids;

    @FXML
    private CheckBox liverFailure;

    @FXML
    private CheckBox kidneyFailure;

    @FXML
    private CheckBox diabetes;

    @FXML
    private CheckBox inflammatoryBowlDisease;

    @FXML
    private CheckBox stroke;

    @FXML
    private CheckBox tornMuscleTendon;

    @FXML
    void orderTest(ActionEvent event) throws IOException {
        Main.patient.setBrokenBone(brokenBone.isSelected());
        Main.patient.setHeartAttack(heartAttack.isSelected());
        Main.patient.setLaceration(laceration.isSelected());
        Main.patient.setHivAIDS(hivAids.isSelected());
        Main.patient.setLiverFailure(liverFailure.isSelected());
        Main.patient.setKidneyFailure(kidneyFailure.isSelected());
        Main.patient.setDiabetes(diabetes.isSelected());
        Main.patient.setInfammatoryBowlDisease(inflammatoryBowlDisease.isSelected());
        Main.patient.setStroke(stroke.isSelected());
        Main.patient.setTornMuscleTendon(tornMuscleTendon.isSelected());

        DatabaseInterface.updatePatient(Main.patient);

        Parent orderTestParent = FXMLLoader.load(getClass().getResource("physicianMedicalForm.fxml"));
        Scene orderTestScene = new Scene(orderTestParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderTestScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        brokenBone.setSelected(Main.patient.getBrokenBone());
        heartAttack.setSelected(Main.patient.getHeartAttack());
        laceration.setSelected(Main.patient.getLaceration());
        hivAids.setSelected(Main.patient.getHivAIDS());
        liverFailure.setSelected(Main.patient.getLiverFailure());
        kidneyFailure.setSelected(Main.patient.getKidneyFailure());
        diabetes.setSelected(Main.patient.getDiabetes());
        inflammatoryBowlDisease.setSelected(Main.patient.getInfammatoryBowlDisease());
        stroke.setSelected(Main.patient.getStroke());
        tornMuscleTendon.setSelected(Main.patient.getTornMuscleTendon());
    }
}
