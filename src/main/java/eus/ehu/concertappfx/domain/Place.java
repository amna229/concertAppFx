package eus.ehu.concertappfx.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {
    //place of celebration

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int maxCapacity;
    private String location;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Concert> concerts;

    public Place(String name, String location, int maxCapacity) {
        this.name = name;
        this.location=location;
        this.maxCapacity = maxCapacity;
        concerts = new ArrayList<Concert>();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Place(){
    }

    public void addConcert(Concert c){
        concerts.add(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }


    @Override
    public String toString(){

        return this.location;

    }



}

