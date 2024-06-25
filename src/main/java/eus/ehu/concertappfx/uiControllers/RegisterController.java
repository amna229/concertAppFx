package eus.ehu.concertappfx.uiControllers;

import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.domain.ExternalUser;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;


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

    public RegisterController() {
    }

    @FXML
    void onClickRegister(ActionEvent event) {

        if(email.getText().contains("@")){

            if(password.getText().equals(repeatpassword.getText())){

                informativeLabel.setText("User registered");
                bl.register(name.getText(), email.getText(), password.getText());

                ExternalUser user = bl.UserLoggedIn(email.getText());
                mainGUI.setUserInMainIn(user);

                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e ->{
                    try {
                        mainGUI.showScene("MainIn");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                pause.play();

            }else{

                informativeLabel.setText("Passwords do not match");

            }

        }else{

            informativeLabel.setText("Invalid email");

        }

    }

    @FXML
    void onClickReturnR(ActionEvent event) throws IOException {
        mainGUI.showScene("Main");
    }

    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

}
