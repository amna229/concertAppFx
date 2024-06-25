package eus.ehu.concertappfx.domain;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "USERS") // Renames the table to avoid using a reserved keyword
@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int yearCreation;
    private String leader;


    private String email;
    private String password;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Concert> concerts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearCreation() {
        return yearCreation;
    }

    public void setYearCreation(int yearCreation) {
        this.yearCreation = yearCreation;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(){}

    public Users(String name, int yearCreation){
        this.name = name;
        this.yearCreation = yearCreation;
    }

    public Users(String name, int yearCreation, String leader){
        this.name = name;
        this.yearCreation = yearCreation;
        this.leader = leader;
    }

    public Users(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString(){

        return this.name;

    }

}
