package eus.ehu.concertapp.ui;

import eus.ehu.concertapp.businessLogic.BLFacade;
import eus.ehu.concertapp.uiControllers.Controller;
import eus.ehu.concertapp.uiControllers.MainController;
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
        setupScene(main.ui, "Concert App", 320, 250);
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
