package eus.ehu.concertappfx.uiControllers;
import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class addPlaceController implements Controller {

        private MainGUI mainGUI;

        private BLFacade bl;

        public addPlaceController(BLFacade bl) {
                this.bl = bl;
        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
                this.mainGUI = mainGUI;
        }

        @FXML
        private TextField locationPlace;

        @FXML
        private TextField maxcapPlace;

        @FXML
        private TextField namePlace;

        @FXML
        private Label isitaddedtext;


        @FXML
        void addPlace(ActionEvent event) {

                if(namePlace.getText().isEmpty() || locationPlace.getText().isEmpty() || maxcapPlace.getText().isEmpty()) {
                        isitaddedtext.setText("Please fill all the fields");
                }else{

                        bl.addPlace(namePlace.getText(), locationPlace.getText().toUpperCase(), Integer.parseInt(maxcapPlace.getText()));
                        isitaddedtext.setText("Place added successfully");

                        namePlace.clear();
                        locationPlace.clear();
                        maxcapPlace.clear();

                }


        }

        @FXML
        void goToAddConcert(ActionEvent event)throws IOException {
                mainGUI.showScene("AddConcert");

        }

        @FXML
        void goToAddGroup(ActionEvent event) throws IOException {
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
