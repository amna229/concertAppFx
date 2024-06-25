package eus.ehu.concertapp.uiControllers;

import eus.ehu.concertapp.businessLogic.BLFacade;
import eus.ehu.concertapp.ui.MainGUI;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class LoginStaffController implements Controller{

    private MainGUI mainGUI;

    @FXML
    private TextField emailLoginStaff;

    @FXML
    private Label infoLoginStaff;

    @FXML
    private PasswordField keyLoginStaff;

    @FXML
    private PasswordField passwordLoginStaff;

    private BLFacade bl;

    public LoginStaffController(BLFacade bl) {
        this.bl = bl;
    }

    @FXML
    void onClickLoginStaff(ActionEvent event) {

        if(emailLoginStaff.getText().isEmpty() || passwordLoginStaff.getText().isEmpty() || keyLoginStaff.getText().isEmpty()){
            infoLoginStaff.setText("Fill in all fields");
        }

        else if(bl.loginStaff(keyLoginStaff.getText(), emailLoginStaff.getText(), emailLoginStaff.getText())){

            infoLoginStaff.setText("Login successful");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e ->{mainGUI.showScene("mainIn"); //tengo que poner el scene para el staff que me falta crear

            });
            pause.play();

        }else{

            infoLoginStaff.setText("Incorrect credentials");

        }

    }

    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

}

