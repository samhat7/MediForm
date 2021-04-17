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


public class orderTestController implements Initializable {

    @FXML
    private CheckBox nucleicAcid;

    @FXML
    private CheckBox coagulationPanel;

    @FXML
    private CheckBox dheaSulfateSerum;

    @FXML
    private CheckBox cReactiveProtein;

    @FXML
    private CheckBox alc;

    @FXML
    private CheckBox xRay;

    @FXML
    private CheckBox mri;

    @FXML
    private CheckBox ctScan;

    @FXML
    private CheckBox urinalysis;

    @FXML
    private CheckBox stoolCulture;

    @FXML
    void orderTest(ActionEvent event) throws IOException {
        Main.patient.setNucleicAcid(nucleicAcid.isSelected());
        Main.patient.setCoagulationPanel(coagulationPanel.isSelected());
        Main.patient.setDheaSulfateSerum(dheaSulfateSerum.isSelected());
        Main.patient.setcReactiveProtein(cReactiveProtein.isSelected());
        Main.patient.setAlc(alc.isSelected());
        Main.patient.setXray(xRay.isSelected());
        Main.patient.setMri(mri.isSelected());
        Main.patient.setCtScan(ctScan.isSelected());
        Main.patient.setUrinalysis(urinalysis.isSelected());
        Main.patient.setStoolCultures(stoolCulture.isSelected());

        DatabaseInterface.updatePatient(Main.patient);

        Parent orderTestParent = FXMLLoader.load(getClass().getResource("physicianMedicalForm.fxml"));
        Scene orderTestScene = new Scene(orderTestParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderTestScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nucleicAcid.setSelected(Main.patient.getNucleicAcid());
        coagulationPanel.setSelected(Main.patient.getCoagulationPanel());
        dheaSulfateSerum.setSelected(Main.patient.getDheaSulfateSerum());
        cReactiveProtein.setSelected(Main.patient.getcReactiveProtein());
        alc.setSelected(Main.patient.getAlc());
        xRay.setSelected(Main.patient.getXray());
        mri.setSelected(Main.patient.getMri());
        ctScan.setSelected(Main.patient.getCtScan());
        urinalysis.setSelected(Main.patient.getUrinalysis());
        stoolCulture.setSelected(Main.patient.getStoolCultures());
    }
}
