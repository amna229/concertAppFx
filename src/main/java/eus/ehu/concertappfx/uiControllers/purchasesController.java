package eus.ehu.concertappfx.uiControllers;
import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.domain.Reservation;
import eus.ehu.concertappfx.ui.MainGUI;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.util.List;


public class purchasesController implements Controller {


        @FXML
        private TextField artistName;

        @FXML
        private TextField cityName;

        @FXML
        private TextFlow infoToShow;

        @FXML
        private TextField numTickets;

        @FXML
        private TextField pricePaid;

        @FXML
        private Text text;

        private MainGUI mainGUI;

        @FXML
        private Label showInfo;

        private BLFacade bl;


        public purchasesController(BLFacade bl) {
            this.bl = bl;
        }

        @Override
        public void setMainApp(MainGUI mainGUI) {
            this.mainGUI = mainGUI;
        }

        @FXML
        void backButton(ActionEvent event) throws IOException {
            mainGUI.showScene("MainIn");
        }

        @FXML
        void logOutButton(ActionEvent event) throws IOException {
            mainGUI.showScene("Main");
        }

    @FXML
    void searchButton(ActionEvent event) {


            if(artistName.getText().isEmpty() || cityName.getText().isEmpty() || numTickets.getText().isEmpty() || pricePaid.getText().isEmpty()) {

                showInfo.setText("Please fill in all the fields");
            }else {

                List<Reservation> found = bl.getReservation(artistName.getText(), cityName.getText(), numTickets.getText(), pricePaid.getText());

                System.out.println("Purchase found: "+found.toString());

                if (!found.isEmpty()) {

                    ObservableList<Reservation> info = FXCollections.observableArrayList(found);
                    text= new Text(found.toString());
                    infoToShow.getChildren().add(text);

                } else if(found.isEmpty()) {

                    showInfo.setText("No reservations found:(   Please try again.");

                }
            }

    }


}
