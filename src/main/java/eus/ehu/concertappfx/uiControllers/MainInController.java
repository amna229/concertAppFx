package eus.ehu.concertapp.uiControllers;

import eus.ehu.concertapp.businessLogic.BLFacade;
import eus.ehu.concertapp.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainInController implements Controller{

    private MainGUI mainGUI;

    @FXML
    private ComboBox<?> artistcomboIn;

    @FXML
    private TableColumn<?, ?> artistinfo;

    @FXML
    private TableColumn<?, ?> citiesinfo;

    @FXML
    private ComboBox<?> citycomboIn;

    @FXML
    private DatePicker datepickerIn;

    @FXML
    private TableColumn<?, ?> datesinfo;

    @FXML
    private TableView<?> infotableIn;

    @FXML
    void logOutButton(ActionEvent event) {

    }

    private BLFacade bl;

    public MainInController(BLFacade bl) {
        this.bl = bl;
    }

    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

}

