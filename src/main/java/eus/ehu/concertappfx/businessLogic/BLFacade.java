package eus.ehu.concertappfx.businessLogic;

import eus.ehu.concertappfx.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BLFacade {

    public void register(String name, String email, String password);

    public boolean login(String email, String password);

    public boolean loginStaff(String code, String email, String password);

    public List<Users> getArtists();

    public Set<String> getPlaces();

    public Set<String> getCityConcertArtist(Users artist);

    public List<Users> getArtistConcertCity(String place);

    public List<LocalDate> getConcertDates(Users artist, String city);

    public List<Concert> getConcerts(Users artist, String city, LocalDate date);

    public Reservation reserve(int numTickets, Concert concert, ExternalUser user);

    public ExternalUser UserLoggedIn(String email);

    public void addPlace(String name, String location, int maxcap);

    public void addGroup(String name, int year, String leader);

    public void addSoloist(String name, int yearCreation);

    public void addConcert(Users artist, String place, LocalDate date, double ticketPrice, double discount);

    public List<Reservation> getReservation(String artist, String city, String numTickets, String pricePaid);
}
