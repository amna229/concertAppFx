package eus.ehu.concertappfx.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EXTERNAL_USER")
public class ExternalUser extends Users{

    public ExternalUser() {
    }

    public ExternalUser(String name, String email, String password) {
        super(name, email, password);
    }

}
