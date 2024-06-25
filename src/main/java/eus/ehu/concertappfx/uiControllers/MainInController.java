package eus.ehu.concertappfx.uiControllers;

import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.domain.*;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class MainInController extends MainController implements Controller {


    private MainGUI mainGUI;

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
    private TableColumn<Concert, LocalDate> datesinfo;

    @FXML
    private TableView<Concert> infotable;

    @FXML
    private Spinner<Integer> numTickets;

    @FXML
    private TableColumn<Concert, Double> priceInfo;

    private ExternalUser user;

    @FXML
    private Label showInfoReservation;

    public void setUser(ExternalUser user) {
        this.user = user;
    }

    @FXML
    void logOutButton(ActionEvent event) throws IOException {
        mainGUI.showScene("Main");
    }

    private BLFacade bl;

    public MainInController(BLFacade bl) {
        super(bl);
        this.bl = bl;
    }

    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }


    @FXML
    public void initialize() {

        super.initialize();

       infotable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            int availableTickets = newSelection.getNumTickets();
            if (availableTickets > 0) {
                numTickets.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, availableTickets, 1));
                numTickets.setDisable(false);
            } else {
                numTickets.setDisable(true);
                showInfoReservation.setText("No tickets left");
            }
        }
});

        System.out.println("MainInController initialized");


        /**  if(bl==null){
         System.out.println("BL not initialized");
         }

         List<Users> listArtists = bl.getArtists();
         Set<String> listPlaces =bl.getPlaces();

         artistcombo.getItems().clear();
         citycombo.getItems().clear();

         artistcombo.getItems().addAll(listArtists);
         citycombo.getItems().addAll(listPlaces);

         System.out.println("MainInController initialized" + "\n" + "Artists: " + listArtists + "\n" + "Places: " + listPlaces);


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
         priceInfo.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));*/

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


    @FXML
    void reserveButton(ActionEvent event) {

        Concert selectedConcert = infotable.getSelectionModel().getSelectedItem();
        if(selectedConcert!=null) {

            int tickets = numTickets.getValue();

            if (selectedConcert.getNumTickets() >= tickets){

                System.out.println("Selected concert: " + selectedConcert.toString() + " number of tickets: "+ tickets);

                Reservation isReserved = bl.reserve(tickets, selectedConcert, user);

                if(isReserved!=null){

                    System.out.println("Reservation done successful");

                    if(isReserved.isDiscounted()) {
                        showInfoReservation.setText("Reservation done successful!!\n your total is " + isReserved.getPricePaid() + "€\n" +
                                "(discount of " + selectedConcert.getDiscount() + "% has been applied)");
                        PauseTransition pause = new PauseTransition(Duration.seconds(7));
                        pause.setOnFinished(e ->{
                            ;
                            showInfoReservation.setText("");

                        });
                        pause.play();
                    }else {

                        showInfoReservation.setText("Reservation done successful!!\n your total is " + isReserved.getPricePaid() + "€");
                        PauseTransition pause = new PauseTransition(Duration.seconds(7));
                        pause.setOnFinished(e ->{
                            ;
                            showInfoReservation.setText("");

                        });
                        pause.play();

                    }

                    artistcombo.setValue(null);
                    citycombo.setValue(null);
                    datepicker.setValue(null);
                    infotable.getItems().clear();
                    numTickets.getEditor().clear();

                }else{

                    showInfoReservation.setText("Sorry for security reasons a purchase\nworth more than 200€ cannot be made");

                }


            }

        }

    }


    @FXML
    void consultPurchasesButton(ActionEvent event) throws IOException {
        mainGUI.showScene("Purchases");
    }

}

