package eus.ehu.concertappfx.uiControllers;

import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.domain.Concert;
import eus.ehu.concertappfx.domain.Place;
import eus.ehu.concertappfx.domain.Users;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class MainController implements Controller {

        private MainGUI mainGUI;

        @FXML
        private VBox mainVBox;

        @FXML
        private ComboBox<Users> artistcombo;

        @FXML
        private TableColumn<Concert, String> artistinfo;

        @FXML
        private TableColumn<Place, String> citiesinfo;

        @FXML
        private ComboBox<String> citycombo;

        @FXML
        private DatePicker datepicker;

        @FXML
        private TableColumn<Concert, Double> priceInfo;

        @FXML
        private TableColumn<Concert, LocalDate> datesinfo;

        @FXML
        private TableView<Concert> infotable;

        private BLFacade bl;

        public VBox getMainVBox() {
            return mainVBox;
        }

        public MainController(BLFacade bl) {
                this.bl = bl;
        }

        @FXML
        void goToLoginButton(ActionEvent event) throws IOException {
                System.out.println("Login choosed");
                mainGUI.showScene("Login");

        }

        @FXML
        void goToMainButton(ActionEvent event) throws IOException {
                System.out.println("Main choosed");
                mainGUI.showScene("Main");
        }

        @FXML
        void goToRegisterButton(ActionEvent event) throws IOException {
                System.out.println("Register choosed");
                mainGUI.showScene("Register");

        }

        @FXML
        void staffOnlyButton(ActionEvent event) throws IOException {
                System.out.println("LoginStaff choosed");
                mainGUI.showScene("LoginStaff");
        }

        @FXML
        void clearButton(ActionEvent event) {

                artistcombo.setValue(null);
                citycombo.setValue(null);
                datepicker.setValue(null);
                infotable.getItems().clear();

        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
                this.mainGUI = mainGUI;
        }

        @FXML
        public void initialize() {

                if(bl==null){
                        System.out.println("BL not initialized");
                }

                List<Users> listArtists = bl.getArtists();
                Set<String> listPlaces =bl.getPlaces();

                artistcombo.getItems().clear();
                citycombo.getItems().clear();

                artistcombo.getItems().addAll(listArtists);
                citycombo.getItems().addAll(listPlaces);

                System.out.println("MainController initialized" + "\n" + "Artists: " + listArtists + "\n" + "Places: " + listPlaces);


                artistcombo.valueProperty().addListener((obs, oldVal, newVal) -> {
                        if (newVal != null) {
                                System.out.println("Selected Artist: " + newVal.getName());

                                Set<String> relatedCities = bl.getCityConcertArtist(newVal);
                                citycombo.setItems(FXCollections.observableArrayList(relatedCities));
                        }else{

                                citycombo.setItems(FXCollections.observableArrayList(listPlaces));

                        }

                });

                citycombo.valueProperty().addListener((obs, oldVal, newVal) -> {
                        if (newVal != null) {
                                System.out.println("Selected City: " + newVal.toString());

                                List<Users> relatedArtists = bl.getArtistConcertCity(newVal);
                                artistcombo.setItems(FXCollections.observableArrayList(relatedArtists));
                        }else{

                                artistcombo.setItems(FXCollections.observableArrayList(listArtists));

                        }

                        updateDatePicker(artistcombo.getValue(), newVal);
                });

                datepicker.setOnAction(actionEvent -> {

                        infotable.getItems().clear();
                        List<Concert> c = bl.getConcerts(artistcombo.getValue(), citycombo.getValue(), datepicker.getValue());
                        for(Concert cc: c){
                                infotable.getItems().add(cc);
                        }
                });


                artistinfo.setCellValueFactory(new Callback<>() {
                        @Override
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<Concert, String> data) {
                                Users artist = data.getValue().getArtist();
                                return new SimpleStringProperty(artist != null ? artist.getName() : "<no name>");
                        }
                });

                citiesinfo.setCellValueFactory(new PropertyValueFactory<>("place"));
                datesinfo.setCellValueFactory(new PropertyValueFactory<>("date"));
                priceInfo.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));

        }


        private void updateDatePicker(Users artist, String city) {
            if (artist != null && city != null) {
                List<LocalDate> concertDates = bl.getConcertDates(artist, city);

                datepicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(DatePicker param) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                setDisable(empty || !concertDates.contains(item));
                            }
                        };
                    }
                });
            }
        }

}



