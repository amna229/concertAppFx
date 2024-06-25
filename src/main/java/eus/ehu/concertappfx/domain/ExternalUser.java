package eus.ehu.concertappfx.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("EXTERNAL_USER")
public class ExternalUser extends Users {

    @OneToMany(mappedBy = "externaluser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public ExternalUser() {
    }

    public ExternalUser(String name, String email, String password, List<Reservation> reservations) {
        super(name, email, password);
        this.reservations = reservations = new ArrayList<>();
    }

}
