package eus.ehu.concertapp.uiControllers;

import eus.ehu.concertapp.businessLogic.BLFacade;
import eus.ehu.concertapp.domain.Group;
import eus.ehu.concertapp.domain.Place;
import eus.ehu.concertapp.domain.Soloist;
import eus.ehu.concertapp.domain.Users;
import eus.ehu.concertapp.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.Date;
import java.util.List;

public class MainController implements Controller {

        private MainGUI mainGUI;

        @FXML
        private VBox mainVBox;

        @FXML
        private ComboBox<Users> artistcombo;

        @FXML
        private TableColumn<Users, String> artistinfo;

        @FXML
        private TableColumn<Place, String> citiesinfo;

        @FXML
        private ComboBox<Place> citycombo;

        @FXML
        private DatePicker datepicker;

        @FXML
        private TableColumn<?, Date> datesinfo;

        @FXML
        private TableView<Users> infoTable;

        private BLFacade bl;


        public VBox getMainVBox() {
            return mainVBox;
        }

        public MainController(BLFacade bl) {
                this.bl = bl;
        }

        @FXML
        void goToLoginButton(ActionEvent event) {
                mainGUI.showScene("Login");
        }

        @FXML
        void goToMainButton(ActionEvent event) {
                mainGUI.showScene("Main");
        }

        @FXML
        void goToRegisterButton(ActionEvent event) {
                mainGUI.showScene("Register");
        }

        @FXML
        void staffOnlyButton(ActionEvent event) {
                mainGUI.showScene("LoginStaff");
        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
                this.mainGUI = mainGUI;
        }


        @FXML
        public void initialize() {

                List<Users> ar = bl.artists();
                artistcombo.getItems().addAll(ar);

        }

    }

