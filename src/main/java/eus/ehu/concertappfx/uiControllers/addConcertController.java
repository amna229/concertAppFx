package eus.ehu.concertappfx.uiControllers;
import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.domain.Place;
import eus.ehu.concertappfx.domain.Users;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class addConcertController implements Controller {

        private MainGUI mainGUI;

        private BLFacade bl;

        public addConcertController(BLFacade bl) {
                this.bl = bl;
        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
                this.mainGUI = mainGUI;
        }

        @FXML
        private ComboBox<Users> artistsConcert;

        @FXML
        private DatePicker dateConcertPicker;

        @FXML
        private TextField discountConcert;

        @FXML
        private ComboBox<String> placeConcert;

        @FXML
        private TextField ticketpriceConcert;

        @FXML
        private Label isitaddedtext;

        public void initialize(){

                List<Users> listArtists = bl.getArtists();
                Set<String> listPlaces =bl.getPlaces();

                artistsConcert.getItems().clear();
                placeConcert.getItems().clear();

                artistsConcert.getItems().addAll(listArtists);
                placeConcert.getItems().addAll(listPlaces);

                System.out.println("list or artists: "+listArtists);
                System.out.println("list or places: "+listPlaces);

        }

        @FXML
        void refreshButton(ActionEvent event) {

                List<Users> listArtists = bl.getArtists();
                Set<String> listPlaces =bl.getPlaces();

                artistsConcert.getItems().clear();
                placeConcert.getItems().clear();

                artistsConcert.getItems().addAll(listArtists);
                placeConcert.getItems().addAll(listPlaces);

                System.out.println("list of artists: "+listArtists);
                System.out.println("list of places: "+listPlaces);

        }


        @FXML
        void addConcert(ActionEvent event) {

                if(artistsConcert.getValue() == null || placeConcert.getValue() == null || dateConcertPicker.getValue() == null || ticketpriceConcert.getText().isEmpty() || discountConcert.getText().isEmpty()) {
                        isitaddedtext.setText("Please fill all the fields");
                }else{

                        bl.addConcert(artistsConcert.getValue(), placeConcert.getValue(), dateConcertPicker.getValue(), Integer.parseInt(ticketpriceConcert.getText()), Integer.parseInt(discountConcert.getText()));
                        isitaddedtext.setText("Concert added successfully");

                        artistsConcert.setValue(null);
                        placeConcert.setValue(null);
                        dateConcertPicker.setValue(null);
                        ticketpriceConcert.clear();
                        discountConcert.clear();

                }


        }


        @FXML
        void goToAddConcerts(ActionEvent event)throws IOException {
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
