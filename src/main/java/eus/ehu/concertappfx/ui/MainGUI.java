package eus.ehu.concertappfx.ui;

import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.domain.ExternalUser;
import eus.ehu.concertappfx.uiControllers.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainGUI {

    private Window login, loginStaff, main, mainIn, register, addConcert, addGroup, addPlace, addSoloist, staffIn, purchases;

    private BLFacade businessLogic;
    private Stage stage;
    private Scene scene;
    private ExternalUser user;
    private VBox mainVBox;


    public BLFacade getBusinessLogic() {
        return businessLogic;
    }

    public void setBusinessLogic(BLFacade afi) {
        businessLogic = afi;
    }

    public MainGUI(BLFacade bl) {
        Platform.startup(() -> {
            try {
                setBusinessLogic(bl);
                init(new Stage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setUserInMainIn(ExternalUser user) {
        MainInController mc = (MainInController) mainIn.c;
        mc.setUser(user);
        mc.initialize();
    }


    class Window {
        Controller c;
        Parent ui;
    }

    private Window load(String fxmlfile) throws IOException {
        Window window = new Window();
        //FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource(fxmlfile), ResourceBundle.getBundle("Etiquetas", Locale.getDefault()));
        //FXMLLoader loader = new FXMLLoader(ApplicationLauncher.class.getResource("main.fxml"));
        FXMLLoader loader = new FXMLLoader(ApplicationLauncher.class.getResource(fxmlfile));

        loader.setControllerFactory(controllerClass -> {
            try {
                return controllerClass
                        .getConstructor(BLFacade.class)
                        .newInstance(businessLogic);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        window.ui = loader.load();
        ((Controller) loader.getController()).setMainApp(this);
        window.c = loader.getController();
        return window;
    }

    public void init(Stage stage) throws IOException {

        this.stage = stage;

        main = load("main.fxml");
        login = load("login.fxml");
        loginStaff = load("loginStaff.fxml");
        register = load("register.fxml");
        mainIn = load("mainIn.fxml");
        addConcert = load("addConcert.fxml");
        addGroup = load("addGroup.fxml");
        addPlace = load("addPlace.fxml");
        addSoloist = load("addSoloist.fxml");
        staffIn = load("staffIn.fxml");
        purchases = load("purchases.fxml");

        main.c.setMainApp(this);
        mainVBox= ((MainController)main.c).getMainVBox();


        setupScene(main.ui, "Concert App");
    }


    public void showScene(String scene) throws IOException {

        switch (scene){

            case "Login":
                mainVBox.getChildren().setAll(login.ui);
                break;
            case "LoginStaff":
                mainVBox.getChildren().setAll(loginStaff.ui);

                break;
            case "Register":
                mainVBox.getChildren().setAll(register.ui);
                break;
            case "MainIn":
                MainInController mainInController = (MainInController) mainIn.c;
                mainVBox.getChildren().setAll(mainIn.ui);
                break;
            case "Main":
                main = load("main.fxml");
                mainVBox.getChildren().setAll(main.ui);
                break;
            case "AddConcert":
                mainVBox.getChildren().setAll(addConcert.ui);
                break;
            case "AddGroup":
                mainVBox.getChildren().setAll(addGroup.ui);
                break;
            case "AddPlace":
                mainVBox.getChildren().setAll(addPlace.ui);
                break;
            case "AddSoloist":
                mainVBox.getChildren().setAll(addSoloist.ui);
                break;
            case "StaffIn":
                mainVBox.getChildren().setAll(staffIn.ui);
                break;
            case "Purchases":
                mainVBox.getChildren().setAll(purchases.ui);
                break;

        }
    }

    public void showMain() {
        setupScene(main.ui, "Main");
    }

    public void showLogin() {
        setupScene(login.ui, "Login");
    }

    public void showLoginStaff() {
        setupScene(loginStaff.ui, "LoginStaff");
    }

    public void showRegister() {
        setupScene(register.ui, "Register");
    }

    public void showMainIn() {

        MainInController mainInController = (MainInController) mainIn.c;
        mainInController.setUser(user);
        setupScene(mainIn.ui, "MainIn");

    }

    public void showAddConcert() {
        setupScene(addConcert.ui, "AddConcert");
    }

    public void showAddGroup() {
        setupScene(addGroup.ui, "AddGroup");
    }

    public void showAddPlace() {
        setupScene(addPlace.ui, "AddPlace");
    }

    public void showAddSoloist() {
        setupScene(addSoloist.ui, "AddSoloist");
    }

    public void showStaffIn() {
        setupScene(staffIn.ui, "StaffIn");
    }

    public void showPurchases() {
        setupScene(purchases.ui, "Purchases");
    }



    private void setupScene(Parent ui, String title) {
        if (scene == null) {
            scene = new Scene(ui);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);
        }
       // stage.setWidth(width);
       // stage.setHeight(height);
        //stage.setTitle(ResourceBundle.getBundle("Etiquetas", Locale.getDefault()).getString(title));
        scene.setRoot(ui);
        stage.show();
    }
}


















/*package eus.ehu.concertappfx.ui;

import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.uiControllers.Controller;
import eus.ehu.concertappfx.uiControllers.MainController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainGUI {

    private Window login, loginStaff, main, mainIn, register;

    private BLFacade businessLogic;
    private Stage stage;
    private Scene scene;

    private VBox mainVBox;

    public BLFacade getBusinessLogic() {
        return businessLogic;
    }

    public void setBusinessLogic(BLFacade afi) {
        businessLogic = afi;
    }

    public MainGUI(BLFacade bl) {
        Platform.startup(() -> {
            try {
                setBusinessLogic(bl);
                init(new Stage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    class Window {
       Controller c;
        Parent ui;
    }

    private Window load(String fxmlfile) throws IOException {
        Window window = new Window();
        FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource(fxmlfile), ResourceBundle.getBundle("Etiquetas", Locale.getDefault()));
        loader.setControllerFactory(controllerClass -> {
            try {
                return controllerClass
                        .getConstructor(BLFacade.class)
                        .newInstance(businessLogic);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        window.ui = loader.load();
        ((Controller) loader.getController()).setMainApp(this);
        window.c = loader.getController();
        return window;
    }

    public void init(Stage stage) throws IOException {

        this.stage = stage;

        main = load("main.fxml");
        login = load("login.fxml");
        loginStaff = load("loginStaff.fxml");
        register = load("register.fxml");
        mainIn = load("mainIn.fxml");

        main.c.setMainApp(this);
        mainVBox= ((MainController)main.c).getMainVBox();


        setupScene(main.ui, "Concert App", 1200, 600);
    }


    public void showScene(String scene){

        switch (scene){

            case "Login" -> mainVBox.getChildren().setAll(login.ui);
            case "LoginStaff" -> mainVBox.getChildren().setAll(loginStaff.ui);
            case "Register" -> mainVBox.getChildren().setAll(register.ui);
            case "MainIn" -> mainVBox.getChildren().setAll(mainIn.ui);
            case "Main" -> mainVBox.getChildren().setAll(main.ui);

        }
    }

    public void showMain() {
        setupScene(main.ui, "Main", 320, 250);
    }

    public void showLogin() {
        setupScene(login.ui, "Login", 320, 250);
    }

    public void showLoginStaff() {
        setupScene(loginStaff.ui, "LoginStaff", 320, 250);
    }

    public void showRegister() {
        setupScene(register.ui, "Register", 320, 250);
    }

    public void showMainIn() {
        setupScene(mainIn.ui, "MainIn", 320, 250);
    }



    private void setupScene(Parent ui, String title, int width, int height) {
        if (scene == null) {
            scene = new Scene(ui, width, height);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);
        }
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setTitle(ResourceBundle.getBundle("Etiquetas", Locale.getDefault()).getString(title));
        scene.setRoot(ui);
        stage.show();
    }
}
*/