package eus.ehu.concertapp.businessLogic;

import eus.ehu.concertapp.configuration.Config;
import eus.ehu.concertapp.dataAccess.DbAccessManager;
import eus.ehu.concertapp.domain.Users;

import java.util.List;

public class BLFacadeImplementation implements BLFacade{

    DbAccessManager dbManager;
    Config config = Config.getInstance();

    public BLFacadeImplementation()  {
        System.out.println("Creating BlFacadeImplementation instance");
        boolean initialize = config.getDataBaseOpenMode().equals("initialize");
        dbManager = new DbAccessManager(initialize);
        if (initialize)
            dbManager.initializeDB();

    }

    public void register(String name, String email, String password){

        dbManager.register(name, email, password);

    }

    public boolean login(String email, String password){
        return dbManager.login(email, password);
    }

    public boolean loginStaff(String key, String email, String password){
        return dbManager.loginStaff(key, email, password);
    }

    public List<Users> artists(){
        return dbManager.artists();
    }

}
