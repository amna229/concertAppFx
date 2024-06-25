package eus.ehu.concertappfx.domain;

import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "place")
    private List<Concert> concerts;

    public Place(String name, String location, int maxCapacity) {
        this.name = name;
        this.location=location;
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Place(){
    }
}
