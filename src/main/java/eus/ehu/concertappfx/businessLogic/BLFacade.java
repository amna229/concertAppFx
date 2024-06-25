package eus.ehu.concertapp.businessLogic;

import eus.ehu.concertapp.domain.Users;

import java.util.List;

public interface BLFacade {

    public void register(String name, String email, String password);

    public boolean login(String email, String password);

    public boolean loginStaff(String key, String email, String password);

    public List<Users> artists();
}
