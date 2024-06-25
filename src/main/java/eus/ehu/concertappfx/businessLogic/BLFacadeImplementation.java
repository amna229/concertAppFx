package eus.ehu.concertappfx.businessLogic;

//import eus.ehu.concertappfx.configuration.Config;
import eus.ehu.concertappfx.dataAccess.DbAccessManager;
import eus.ehu.concertappfx.domain.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BLFacadeImplementation implements BLFacade{

    DbAccessManager dbManager;
   // Config config = Config.getInstance();

   /** public BLFacadeImplementation()  {
        System.out.println("Creating BlFacadeImplementation instance");
        /**boolean initialize = config.getDataBaseOpenMode().equals("initialize");
        dbManager = new DbAccessManager(initialize);
        if (initialize)
            dbManager.initializeDB();

        dbManager.initializeDB();

    }*/

   public BLFacadeImplementation() {
       try {
           System.out.println("Creating BlFacadeImplementation instance");
           dbManager = new DbAccessManager();
           dbManager.initializeDB();
       } catch (Exception e) {
           System.err.println("Error in BLFacadeImplementation constructor: " + e);
       }
   }


    public void register(String name, String email, String password){

        dbManager.register(name, email, password);

    }

    public boolean login(String email, String password){
        return dbManager.login(email, password);
    }

    public boolean loginStaff(String code, String email, String password){
        return dbManager.loginStaff(code, email, password);
    }

    public List<Users> getArtists(){
        return dbManager.getArtists();
    }

    public Set<String> getPlaces(){
        return dbManager.getPlaces();
    }

    public Set<String> getCityConcertArtist(Users artist){
        return dbManager.getCityConcertArtist(artist);
    }

    public List<Users> getArtistConcertCity(String place){
        return dbManager.getArtistConcertCity(place);
    }

    /**public List<LocalDate> getConcertDates(Users artist, String city){
        return dbManager.getConcertDates(artist, city);
    }*/

    public List<LocalDate> getConcertDates(Users artist, String city){
    List<LocalDate> dates = dbManager.getConcertDates(artist, city);
    return dates;
}

    public List<Concert> getConcerts(Users artist, String city, LocalDate date){
        return dbManager.getConcerts(artist, city, date);
    }

    public Reservation reserve(int numTickets, Concert concert, ExternalUser user){

        return dbManager.reserve(numTickets, concert, user);

    }

    public ExternalUser UserLoggedIn(String email){

        return dbManager.UserLoggedIn(email);

    }

    public void addPlace(String name, String location, int maxcap){
        dbManager.addPlace(name, location, maxcap);
    }

    public void addGroup(String name, int year, String leader){
        dbManager.addGroup(name, year, leader);
    }

    public void addSoloist(String name, int yearCreation){
        dbManager.addSoloist(name, yearCreation);
    }

    public void addConcert(Users artist, String place, LocalDate date, double ticketPrice, double discount){
        dbManager.addConcert(artist, place, date, ticketPrice, discount);
    }

    public List<Reservation> getReservation(String artist, String city, String numTickets, String pricePaid){
        return dbManager.getReservation(artist, city, numTickets, pricePaid);
    }


}
