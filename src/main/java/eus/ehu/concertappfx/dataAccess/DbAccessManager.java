package eus.ehu.concertapp.dataAccess;

import eus.ehu.concertapp.configuration.Config;
import eus.ehu.concertapp.configuration.UtilDate;
import eus.ehu.concertapp.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DbAccessManager {

        protected EntityManager db;
        protected EntityManagerFactory emf;

       /** public DbAccessManager() {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                emf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(registry);
            }

            db = emf.createEntityManager();
            System.out.println("DataBase opened");

        }*/

    public DbAccessManager() {

        this.open();

    }

    public DbAccessManager(boolean initializeMode) {

        this.open(initializeMode);

    }

    public void open() {
        open(false);
    }


   /** public void open(boolean initializeMode) {

        Config config = Config.getInstance();

        System.out.println("Opening DataAccess instance => isDatabaseLocal: " +
                config.isDataAccessLocal() + " getDatabBaseOpenMode: " + config.getDataBaseOpenMode());

        String fileName = config.getDatabaseName();
        if (initializeMode) {
            fileName = fileName + ";drop";
            System.out.println("Deleting the DataBase");
        }

        if (config.isDataAccessLocal()) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                emf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                StandardServiceRegistryBuilder.destroy(registry);
            }

            System.out.println(emf);

            db = emf.createEntityManager();
            System.out.println("DataBase opened");
        }
    }*/

   public void open(boolean initializeMode) {
       Config config = Config.getInstance();

       System.out.println("Opening DataAccess instance => isDatabaseLocal: " +
               config.isDataAccessLocal() + " getDatabBaseOpenMode: " + config.getDataBaseOpenMode());

       String fileName = config.getDatabaseName();
       if (initializeMode) {
           fileName = fileName + ";drop";
           System.out.println("Deleting the DataBase");
       }

       if (config.isDataAccessLocal()) {
           final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                   .configure() // configures settings from hibernate.cfg.xml
                   .build();
           try {
               emf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
           } catch (Exception e) {
               StandardServiceRegistryBuilder.destroy(registry);
               System.out.println("Error creating EntityManagerFactory:");
               e.printStackTrace();
           }

           if (emf == null) {
               System.out.println("EntityManagerFactory is null, check configuration.");
           } else {
               db = emf.createEntityManager();
               System.out.println("DataBase opened");
           }
       }
   }


    public void close() {
            db.close();
            System.out.println("DataBase is closed");
        }



        //for populating the database
        public void initializeDB() {

            try {

                Calendar today = Calendar.getInstance();

                int month = today.get(Calendar.MONTH);
                int year = today.get(Calendar.YEAR);
                if (month == 12) {
                    month = 1;
                    year += 1;
                }

            Soloist soloist1 = new Soloist("John Smith", 1990);
            Soloist soloist2 = new Soloist("Emma Johnson", 1985);
            Soloist soloist3 = new Soloist("Michael Brown", 2000);
            Soloist soloist4 = new Soloist("Sophia Martinez", 1998);
            Soloist soloist5 = new Soloist("William Taylor", 1995);

            Group group1 = new Group("The Beatles", 1960, "John Lennon");
            Group group2 = new Group("Queen", 1970, "Freddie Mercury");
            Group group3 = new Group("Led Zeppelin", 1968, "Robert Plant");
            Group group4 = new Group("Pink Floyd", 1965, "Roger Waters");
            Group group5 = new Group("The Rolling Stones", 1962, "Mick Jagger");

            ExternalUser externalUser1 = new ExternalUser("Alice Johnson", "alice@example.com", "password123");
            ExternalUser externalUser2 = new ExternalUser("Bob Smith", "bob@example.com", "securePassword");
            ExternalUser externalUser3 = new ExternalUser("Charlie Brown", "charlie@example.com", "strongPassword");
            ExternalUser externalUser4 = new ExternalUser("Diana Parker", "diana@example.com", "password456");
            ExternalUser externalUser5 = new ExternalUser("Eva Garcia", "eva@example.com", "secretPassword");

            StaffMember staffMember1 = new StaffMember("Ana López", "ana@example.com", "contraseña123", "XYZ123");
            StaffMember staffMember2 = new StaffMember("Pedro Martínez", "pedro@example.com", "contraseñaSegura", "ABC789");
            StaffMember staffMember3 = new StaffMember("María García", "maria@example.com", "maria123", "DEG220");
            StaffMember staffMember4 = new StaffMember("Luis Hernández", "luis@example.com", "luisPassword", "MNO004");
            StaffMember staffMember5 = new StaffMember("Sofía Rodríguez", "sofia@example.com", "sofiaPass", "QRS777");
            StaffMember staffMember6 = new StaffMember("Javier Fernández", "javier@example.com", "javier456", "WZY456");

            Place place1 = new Place("WiZink Center", "MADRID", 2);
            Place place2 = new Place("Estadio Santiago Bernabéu", "MADRID", 3);
            Place place3 = new Place("Estadio de San Mamés", "BILBAO", 5);
            Place place4 = new Place("Bilbao Exhibition Centre", "BILBAO", 4);
            Place place5 = new Place("Estadio Benito Villamarín", "SEVILLA" ,1);
            Place place6 = new Place("Estadio de la Cartuja", "SEVILLA" , 7);
            Place place7 = new Place("Palau Sant Jordi", "BARCELONA", 2);
            Place place8 = new Place("Estadi Olímpic Lluís Companys", "BARCELONA", 3);
            Place place9 = new Place("Ciudad de las Artes y las Ciencias", "VALENCIA" , 4);
            Place place10 = new Place("Plaza de Toros de Valencia", "VALENCIA" , 1);

            Concert concert1= new Concert(place1, UtilDate.newDate(year, month, 2), 150, 20);
            Concert concert2= new Concert(place2, UtilDate.newDate(year, month, 31), 200, 35);
            Concert concert3= new Concert(place3, UtilDate.newDate(year, month, 8), 70, 10);
            Concert concert4= new Concert(place4, UtilDate.newDate(year, month, 4), 50, 20);
            Concert concert5= new Concert(place5, UtilDate.newDate(year, month, 6), 35, 25);
            Concert concert6= new Concert(place6, UtilDate.newDate(year, month, 18), 40, 45);
            Concert concert7= new Concert(place7, UtilDate.newDate(year, month, 22), 170, 15);
            Concert concert8= new Concert(place8, UtilDate.newDate(year, month, 14), 55, 20);
            Concert concert9= new Concert(place9, UtilDate.newDate(year, month, 1), 20, 10);
            Concert concert10= new Concert(place10, UtilDate.newDate(year, month, 18), 25, 5);
            Concert concert11= new Concert(place1, UtilDate.newDate(year, month, 9), 77.50, 7);
            Concert concert12= new Concert(place2, UtilDate.newDate(year, month, 11), 199.99, 25);
            Concert concert13= new Concert(place7, UtilDate.newDate(year, month, 16), 110.50, 15);
            Concert concert14= new Concert(place9, UtilDate.newDate(year, month, 5), 35.5, 10);
            Concert concert15= new Concert(place4, UtilDate.newDate(year, month, 13), 89.9, 30);



                db.getTransaction().begin();
            db.persist(soloist1);
            db.persist(soloist2);
            db.persist(soloist3);
            db.persist(soloist4);
            db.persist(soloist5);
            db.persist(group1);
            db.persist(group2);
            db.persist(group3);
            db.persist(group4);
            db.persist(group5);
            db.persist(externalUser1);
            db.persist(externalUser2);
            db.persist(externalUser3);
            db.persist(externalUser4);
            db.persist(externalUser5);
            db.persist(staffMember1);
            db.persist(staffMember2);
            db.persist(staffMember3);
            db.persist(staffMember4);
            db.persist(staffMember5);
            db.persist(staffMember6);
            db.persist(concert1);
            db.persist(concert2);
            db.persist(concert3);
            db.persist(concert4);
            db.persist(concert5);
            db.persist(concert6);
            db.persist(concert7);
            db.persist(concert8);
            db.persist(concert9);
            db.persist(concert10);
            db.persist(concert11);
            db.persist(concert12);
            db.persist(concert13);
            db.persist(concert14);
            db.persist(concert15);
            db.getTransaction().commit();

                System.out.println("Db initialized");

            } catch (Exception e) {
                System.out.println("Error in initializing the database");
                e.printStackTrace();
            }

        }

        public void register(String name, String email, String password) {
            db.getTransaction().begin();
            ExternalUser usuario = new ExternalUser(name, email, password);
            db.persist(usuario);
            db.getTransaction().commit();
        }

        public boolean login(String email, String password) {

            ExternalUser e = db.find(ExternalUser.class, email);

            if (e != null && e.getPassword().equals(password)) {
                return true;
            } else {

                return false;

            }
        }


    public boolean loginStaff(String key, String email, String password) {

        StaffMember s = db.find(StaffMember.class, email);

        if (s != null && s.getPassword().equals(password) && s.getKey().equals(key)){
            return true;
        } else {

            return false;

        }
    }

    public List<Users> artists(){

        List<Users> artists = new ArrayList<Users>();

        List<Soloist> soloists = db.createQuery("SELECT s FROM Soloist s", Soloist.class).getResultList();
        artists.addAll(soloists);

        List<Group> groups = db.createQuery("SELECT g FROM Group g", Group.class).getResultList();
        artists.addAll(groups);


        return artists;
    }



}
