package eus.ehu.concertappfx.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Concert {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private Place place;

    private Date date;
    private double ticketPrice;
    private double discount; //for the advance purchases only


    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
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
    public Concert(Place place, Date date, double ticketPrice, double discount) {

        this.place= place;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.discount = discount;
    }
    public Concert() {
    }


}
