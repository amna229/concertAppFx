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

    public LoginController() {
    }


    @FXML
    void onClickLogin(ActionEvent event) {

        if(emailLogin.getText().isEmpty() || passwordLogin.getText().isEmpty()){
            infoLogin.setText("Fill in all fields");
        }

        else if(bl.login(emailLogin.getText(), passwordLogin.getText())){

            ExternalUser user = bl.UserLoggedIn(emailLogin.getText());
            mainGUI.setUserInMainIn(user);


            infoLogin.setText("Login successful");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e ->{
                try {;
                    mainGUI.showScene("MainIn");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            });
            pause.play();

        }else{

            infoLogin.setText("Incorrect credentials");

        }

    }

    @FXML
    void onClickReturnL(ActionEvent event) throws IOException {
        mainGUI.showScene("Main");
    }

    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

}

