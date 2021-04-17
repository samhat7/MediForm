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

public class physicianMedicalFormController implements Initializable{

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
    private TextField symptoms1;

    @FXML
    private TextField medications1;

    @FXML
    private TextField tests1;

    @FXML
    private TextField diagnosis1;

    @FXML
    private TextField pulseRate1;

    @FXML
    void submitVitals(ActionEvent event) throws IOException {
        Main.patient.setHeight(Float.parseFloat(height1.getText()));
        Main.patient.setWeight(Float.parseFloat(weight1.getText()));
        Main.patient.setTemperature(Float.parseFloat(height1.getText()));
        Main.patient.setBloodPressure(bloodPress1.getText());
        Main.patient.setPulseRate(pulseRate1.getText());

        DatabaseInterface.updatePatient(Main.patient);

        Parent nurseMenuParent = FXMLLoader.load(getClass().getResource("nurseMenu.fxml"));
        Scene nurseMenuScene = new Scene(nurseMenuParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nurseMenuScene);
        window.show();
    }

    @FXML
    void toPhysicianMenu(ActionEvent event) throws IOException {
        Parent physicianMenuParent = FXMLLoader.load(getClass().getResource("physicianMenu.fxml"));
        Scene physicianMenuScene = new Scene(physicianMenuParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(physicianMenuScene);
        window.show();
    }

    @FXML
    void toDiagnose(ActionEvent event) throws IOException {
        Parent diagnoseParent = FXMLLoader.load(getClass().getResource("diagnose.fxml"));
        Scene diagnoseScene = new Scene(diagnoseParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(diagnoseScene);
        window.show();
    }
    
    @FXML
    void toOrderMeds(ActionEvent event) throws IOException {
        Parent orderMedsParent = FXMLLoader.load(getClass().getResource("orderMeds.fxml"));
        Scene orderMedsScene = new Scene(orderMedsParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderMedsScene);
        window.show();
    }

    @FXML
    void toOrderTest(ActionEvent event) throws IOException {
        Parent orderTestParent = FXMLLoader.load(getClass().getResource("orderTest.fxml"));
        Scene orderTestScene = new Scene(orderTestParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderTestScene);
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
    }
}
