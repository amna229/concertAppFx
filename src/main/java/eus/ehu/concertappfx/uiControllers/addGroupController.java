package eus.ehu.concertappfx.uiControllers;
import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class addGroupController implements Controller {

        private MainGUI mainGUI;

        private BLFacade bl;

        public addGroupController(BLFacade bl) {
                this.bl = bl;
        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
                this.mainGUI = mainGUI;
        }

        @FXML
        private TextField leaderGroup;

        @FXML
        private TextField nameGroup;

        @FXML
        private TextField yearCreationGroup;

        @FXML
        private Label isitaddedtext;


        @FXML
        void addGroup(ActionEvent event) {

        if(nameGroup.getText().isEmpty() || yearCreationGroup.getText().isEmpty() || leaderGroup.getText().isEmpty()) {
                isitaddedtext.setText("Please fill all the fields");
        }else{

                bl.addGroup(nameGroup.getText(), Integer.parseInt(yearCreationGroup.getText()), leaderGroup.getText());
                isitaddedtext.setText("Group added successfully");

                nameGroup.clear();
                yearCreationGroup.clear();
                leaderGroup.clear();

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
