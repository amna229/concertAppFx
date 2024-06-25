package eus.ehu.concertapp.ui;

import eus.ehu.concertapp.businessLogic.BLFacade;
import eus.ehu.concertapp.businessLogic.BLFacadeImplementation;
import eus.ehu.concertapp.configuration.Config;
import java.util.Locale;


public class ApplicationLauncher {

    public static void main(String[] args) {

        Config config = Config.getInstance();

        Locale.setDefault(new Locale(config.getLocale()));
        System.out.println("Locale: " + Locale.getDefault());

        BLFacade businessLogic;

        try {

            if (config.isBusinessLogicLocal()) {
                businessLogic = new BLFacadeImplementation();

                new MainGUI(businessLogic);
            }
        }
        catch (Exception e) {
            System.err.println("Error in ApplicationLauncher: " + e);
        }

    }


}
