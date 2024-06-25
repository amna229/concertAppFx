package eus.ehu.concertapp.uiControllers;

import eus.ehu.concertapp.businessLogic.BLFacade;
import eus.ehu.concertapp.ui.MainGUI;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class RegisterController implements Controller{

    private MainGUI mainGUI;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField repeatpassword;

    @FXML
    private Label informativeLabel;

    private BLFacade bl;

    public RegisterController(BLFacade bl) {
        this.bl = bl;
    }


    @FXML
    void onClickRegister(ActionEvent event) {

        if(email.getText().contains("@")){

            if(password.getText().equals(repeatpassword.getText())){

                informativeLabel.setText("User registered");
                bl.register(name.getText(), email.getText(), password.getText());
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e ->{mainGUI.showScene("mainIn");
                });
                pause.play();

            }else{

                informativeLabel.setText("Passwords do not match");

            }

        }else{

            informativeLabel.setText("Invalid email");

        }

    }

    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

}
