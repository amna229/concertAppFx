package eus.ehu.concertappfx.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Concert {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private Place place;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservation;

    @ManyToOne
    private Users artist;

    private LocalDate date;
    private double ticketPrice;
    private double discount; //for the advance purchases only
    private int numTickets;

    public Users getArtist() {
        return artist;
    }
    public void setArtist(Users artist) {
        this.artist = artist;
    }
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public void addReservation(Reservation reservation) {
        this.reservation.add(reservation);
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public Concert(Users artist, Place place, LocalDate date, double ticketPrice, double discount) {
        this.artist = artist;
        this.place= place;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.discount = discount;
        this.numTickets = place.getMaxCapacity();
        this.reservation= new ArrayList<Reservation>();
    }
    public Concert() {
    }

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + id +
                ", place=" + place +
                ", artist=" + artist +
                ", date=" + date +
                ", ticketPrice=" + ticketPrice +
                ", discount=" + discount +
                ", numTickets=" + numTickets +
                '}';
    }


}
