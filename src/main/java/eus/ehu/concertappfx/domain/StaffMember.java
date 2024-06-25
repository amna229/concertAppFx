package eus.ehu.concertappfx.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STAFFMEMBER")
public class StaffMember extends Users{

    private String key;

    public StaffMember() {
    }

    public StaffMember(String name, String email, String password, String key) {
        super(name, email, password);
        this.key=key;
    }

    public String getKey() {
        return key;
    }


}
