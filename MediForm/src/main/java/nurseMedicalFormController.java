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

public class nurseMedicalFormController implements Initializable{
    @FXML
    private TextField firstName1;

    @FXML
    private TextField lastName1;

    @FXML
    private TextField height1;

    @FXML
    private TextField temp1;

    @FXML
    private TextField weight1;

    @FXML
    private TextField bloodPress1;

    @FXML
    private TextField pulseRate1;

    @FXML
    private TextField assignedPhysician1;

    @FXML
    void submitVitals(ActionEvent event) throws IOException {
        Main.patient.setHeight(Float.parseFloat(height1.getText()));
        Main.patient.setWeight(Float.parseFloat(weight1.getText()));
        Main.patient.setTemperature(Float.parseFloat(height1.getText()));
        Main.patient.setBloodPressure(bloodPress1.getText());
        Main.patient.setPulseRate(pulseRate1.getText());
        Main.patient.setAssignedPhysician(assignedPhysician1.getText());

        DatabaseInterface.updatePatient(Main.patient);

        Parent nurseMenuParent = FXMLLoader.load(getClass().getResource("nurseMenu.fxml"));
        Scene nurseMenuScene = new Scene(nurseMenuParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nurseMenuScene);
        window.show();
    }

    @FXML
    void toNurseMenu(ActionEvent event) throws IOException {
        Parent nurseMenuParent = FXMLLoader.load(getClass().getResource("nurseMenu.fxml"));
        Scene nurseMenuScene = new Scene(nurseMenuParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nurseMenuScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name = Main.patient.getName();
        String[] nameSplit = name.split(" ");
        firstName1.setText(nameSplit[0]);
        lastName1.setText(nameSplit[1]);

        Float f = (Float) Main.patient.getHeight();
        if(f == 0) height1.setText("");
        else height1.setText(f.toString());

        f = (Float) Main.patient.getWeight();
        if(f == 0) weight1.setText("");
        else weight1.setText(f.toString());

        f = (Float) Main.patient.getTemperature();
        if(f == 0) temp1.setText("");
        else temp1.setText(f.toString());

        String s = Main.patient.getBloodPressure();
        if(s == null) bloodPress1.setText("");
        else bloodPress1.setText(s);

        s = Main.patient.getPulseRate();
        if(s == null) pulseRate1.setText("");
        else pulseRate1.setText(s);

        s = Main.patient.getAssignedPhysician();
        if(s == null) assignedPhysician1.setText("");
        else assignedPhysician1.setText(s);
    }
}
