package eus.ehu.concertappfx.uiControllers;
import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class StaffInController implements Controller {

        private MainGUI mainGUI;

        private BLFacade bl;

        public StaffInController(BLFacade bl) {
                this.bl = bl;
        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
                this.mainGUI = mainGUI;
        }


        @FXML
        void goToAddConcerts(ActionEvent event) throws IOException {
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
