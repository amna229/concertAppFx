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

public class LoginController implements Controller{

    private MainGUI mainGUI;

    @FXML
    private TextField emailLogin;

    @FXML
    private Label infoLogin;

    @FXML
    private PasswordField passwordLogin;

    private BLFacade bl;

    public LoginController(BLFacade bl) {
        this.bl = bl;
    }



    @FXML
    void onClickLogin(ActionEvent event) {

        if(emailLogin.getText().isEmpty() || passwordLogin.getText().isEmpty()){
            infoLogin.setText("Fill in all fields");
        }

        else if(bl.login(emailLogin.getText(), passwordLogin.getText())){

            infoLogin.setText("Login successful");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e ->{
                mainGUI.showScene("mainIn");

            });
            pause.play();

        }else{

            infoLogin.setText("Incorrect credentials");

        }

    }

    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

}

