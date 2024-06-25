package eus.ehu.concertappfx.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SOLOIST")
public class Soloist extends Users {

    public Soloist() {
    }

public Soloist(String name, int year) {
        super(name, year);
    }


}
