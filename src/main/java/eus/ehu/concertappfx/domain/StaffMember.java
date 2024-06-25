package eus.ehu.concertappfx.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STAFFMEMBER")
public class StaffMember extends Users {

    private String code;

    public StaffMember() {
    }

    public StaffMember(String name, String email, String password, String code) {
        super(name, email, password);
        this.code=code;
    }

    public String getCode() {
        return code;
    }


}
