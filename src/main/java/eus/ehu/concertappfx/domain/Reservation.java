package eus.ehu.concertappfx.domain;

import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Concert concert;
    private int numTickets;
    private double pricePaid;
    private boolean isDiscounted;

    @ManyToOne
    private ExternalUser externaluser;

    public Reservation() {
    }

    public Reservation(Concert concert, int numTickets, ExternalUser user) {
        this.concert = concert;
        this.numTickets = numTickets;
        this.externaluser = user;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public ExternalUser getExternalUser(){
        return externaluser;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

  /**  @Override
    public String toString() {
        return "Reservation{" +
                "concert=" + concert +
                ", numTickets=" + numTickets +
                ", externaluser=" + externaluser +
                ", pricePaid=" + pricePaid +
                '}';
    }*/

    @Override
    public String toString(){

        return "Artist: " + concert.getArtist().getName() +
                " City: " + concert.getPlace().getLocation()+
                " Stadium: " + concert.getPlace().getName()+
                " Date: " + concert.getDate() +
                " No. of tickets: " + numTickets +
                " Price paid: " + pricePaid + "€";

    }

}
