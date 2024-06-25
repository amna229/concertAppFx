package eus.ehu.concertappfx.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GROUP")
public class Group extends Users {

    public Group() {
    }

    public Group(String name, int year, String leader) {
        super(name, year, leader);
    }

}
