package eus.ehu.concertappfx.ui;

import eus.ehu.concertappfx.businessLogic.BLFacade;
import eus.ehu.concertappfx.businessLogic.BLFacadeImplementation;
import eus.ehu.concertappfx.dataAccess.DbAccessManager;
//import eus.ehu.concertappfx.configuration.Config;

import java.time.LocalDate;
import java.util.Locale;

import static javafx.application.Application.launch;


public class ApplicationLauncher {

    private DbAccessManager dbManager;

    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "GB"));

        //Config config = Config.getInstance();

       // Locale.setDefault(new Locale(config.getLocale()));
        //System.out.println("Locale: " + Locale.getDefault());

        BLFacade businessLogic;

        try {

          /**  if (config.isBusinessLogicLocal()) {
                businessLogic = new BLFacadeImplementation();


                new MainGUI(businessLogic);
            }*/

        businessLogic = new BLFacadeImplementation();
        new MainGUI(businessLogic);


        }
        catch (Exception e) {
            System.err.println("Error in ApplicationLauncher: " + e);
        }

    }


}
