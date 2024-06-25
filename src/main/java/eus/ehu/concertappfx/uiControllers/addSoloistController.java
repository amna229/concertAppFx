package eus.ehu.concertappfx.uiControllers;
import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class addSoloistController implements Controller {

        private MainGUI mainGUI;

        private BLFacade bl;

        public addSoloistController(BLFacade bl) {
                this.bl = bl;
        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
                this.mainGUI = mainGUI;
        }

        @FXML
        private TextField nameSoloist;

        @FXML
        private TextField yearCreationSoloist;

        @FXML
        private Label isitaddedtext;


        @FXML
        void addSoloist(ActionEvent event) {

                if(nameSoloist.getText().isEmpty() || yearCreationSoloist.getText().isEmpty()){
                        isitaddedtext.setText("Please fill all the fields");
                }else{

                        bl.addSoloist(nameSoloist.getText(), Integer.parseInt(yearCreationSoloist.getText()));
                        isitaddedtext.setText("Soloist added successfully");

                }


        }

        @FXML
        void goToAddConcert(ActionEvent event)throws IOException {
                mainGUI.showScene("AddConcert");

        }

        @FXML
        void goToAddGroups(ActionEvent event) throws IOException {
                mainGUI.showScene("AddGroup");

        }

        @FXML
        void goToAddPlaces(ActionEvent event) throws IOException {
                mainGUI.showScene("AddPlace");

        }

        @FXML
        void goToAddSoloist(ActionEvent event) throws IOException {
                mainGUI.showScene("AddSoloist");

        }

        @FXML
        void logoutButton(ActionEvent event) throws IOException {
                mainGUI.showScene("Main");

        }

}
