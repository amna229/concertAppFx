package eus.ehu.concertappfx.dataAccess;

//import eus.ehu.concertappfx.configuration.Config;
import eus.ehu.concertappfx.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.time.LocalDate;
import java.util.*;

/**public class DbAccessManager {

        protected EntityManager db;
        protected EntityManagerFactory emf;

    public DbAccessManager() {

        this.open();

    }

    public DbAccessManager(boolean initializeMode) {

        this.open(initializeMode);

    }

    public void open() {
        open(false);
    }


    public void open(boolean initializeMode) {

       /** Config config = Config.getInstance();

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

            db = emf.createEntityManager();
            System.out.println("DataBase opened");
        }
    }*/

public class DbAccessManager {

    protected EntityManager db;
    protected EntityManagerFactory emf;

    public DbAccessManager() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            emf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

        db = emf.createEntityManager();
        System.out.println("DataBase opened");

    }

    public void close() {
        db.close();
        System.out.println("DataBase is closed");
    }


    public void initializeDB() {

        try {
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

            ExternalUser externalUser1 = new ExternalUser("Alice Johnson", "alice@example.com", "password123", new ArrayList<Reservation>());
            ExternalUser externalUser2 = new ExternalUser("Bob Smith", "bob@example.com", "securePassword", new ArrayList<Reservation>());
            ExternalUser externalUser3 = new ExternalUser("Charlie Brown", "charlie@example.com", "strongPassword", new ArrayList<Reservation>());
            ExternalUser externalUser4 = new ExternalUser("Diana Parker", "diana@example.com", "password456", new ArrayList<Reservation>());
            ExternalUser externalUser5 = new ExternalUser("Eva Garcia", "eva@example.com", "secretPassword", new ArrayList<Reservation>());

            StaffMember staffMember1 = new StaffMember("Ana López", "ana@example.com", "contraseña123", "XYZ123");
            StaffMember staffMember2 = new StaffMember("Pedro Martínez", "pedro@example.com", "contraseñaSegura", "ABC789");
            StaffMember staffMember3 = new StaffMember("María García", "maria@example.com", "maria123", "DEG220");
            StaffMember staffMember4 = new StaffMember("Luis Hernández", "luis@example.com", "luisPassword", "MNO004");
            StaffMember staffMember5 = new StaffMember("Sofía Rodríguez", "sofia@example.com", "sofiaPass", "QRS777");
            StaffMember staffMember6 = new StaffMember("Javier Fernández", "javier@example.com", "javier456", "WZY456");

            Place place1 = new Place("WiZink Center", "MADRID", 20);
            Place place2 = new Place("Estadio Santiago Bernabéu", "MADRID", 5);
            Place place3 = new Place("Estadio de San Mamés", "BILBAO", 15);
            Place place4 = new Place("Bilbao Exhibition Centre", "BILBAO", 7);
            Place place5 = new Place("Estadio Benito Villamarín", "SEVILLA", 8);
            Place place6 = new Place("Estadio de la Cartuja", "SEVILLA", 11);
            Place place7 = new Place("Palau Sant Jordi", "BARCELONA", 10);
            Place place8 = new Place("Estadi Olímpic Lluís Companys", "BARCELONA", 6);
            Place place9 = new Place("Ciudad de las Artes y las Ciencias", "VALENCIA", 4);
            Place place10 = new Place("Plaza de Toros de Valencia", "VALENCIA", 9);

            int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

            Concert concert1 = new Concert(soloist1, place1, LocalDate.of(year, 6, 26), 150, 20);
            Concert concert2 = new Concert(soloist2, place2, LocalDate.of(year, 6, 27), 200, 35);
            Concert concert3 = new Concert(soloist3, place3, LocalDate.of(year, 6, 28), 70, 10);
            Concert concert4 = new Concert(soloist4, place4, LocalDate.of(year, 6, 29), 50, 20);
            Concert concert5 = new Concert(soloist5, place5, LocalDate.of(year, 6, 30), 35, 25);
            Concert concert6 = new Concert(group1, place6, LocalDate.of(year, 7, 1), 40, 45);
            Concert concert7 = new Concert(group2, place7, LocalDate.of(year, 7, 5), 170, 15);
            Concert concert8 = new Concert(group3, place8, LocalDate.of(year, 7, 8), 55, 20);
            Concert concert9 = new Concert(group4, place9, LocalDate.of(year, 7, 10), 20, 10);
            Concert concert10 = new Concert(group5, place10, LocalDate.of(year, 7, 14), 25, 5);
            Concert concert11 = new Concert(soloist2, place1, LocalDate.of(year, 8, 18), 77.50, 7);
            Concert concert12 = new Concert(group2, place2, LocalDate.of(year, 8, 19), 199.99, 25);
            Concert concert13 = new Concert(soloist4, place7, LocalDate.of(year, 8, 22), 110.50, 15);
            Concert concert14 = new Concert(group4, place9, LocalDate.of(year, 8, 24), 35.5, 10);
            Concert concert15 = new Concert(soloist1, place4, LocalDate.of(year, 8, 25), 89.9, 30);


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
            db.persist(place1);
            db.persist(place2);
            db.persist(place3);
            db.persist(place4);
            db.persist(place5);
            db.persist(place6);
            db.persist(place7);
            db.persist(place8);
            db.persist(place9);
            db.persist(place10);
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
        ExternalUser usuario = new ExternalUser(name, email, password, new ArrayList<Reservation>());
        db.persist(usuario);
        db.getTransaction().commit();
    }


    public boolean login(String email, String password) {
        List<ExternalUser> users = db.createQuery("SELECT e FROM ExternalUser e WHERE e.email = :email", ExternalUser.class)
                .setParameter("email", email)
                .getResultList();

        if (!users.isEmpty() && users.get(0).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


   public boolean loginStaff(String code, String email, String password) {
    List<StaffMember> staffMembers = db.createQuery("SELECT s FROM StaffMember s WHERE s.email = :email AND s.code = :code", StaffMember.class)
            .setParameter("email", email)
            .setParameter("code", code)
            .getResultList();

    if (!staffMembers.isEmpty() && staffMembers.get(0).getPassword().equals(password)) {
        return true;
    } else {
        return false;
    }
}

    public List<Users> getArtists() {

        List<Users> artists = new ArrayList<Users>();

        List<Soloist> soloists = db.createQuery("SELECT s FROM Soloist s", Soloist.class).getResultList();
        artists.addAll(soloists);

        List<Group> groups = db.createQuery("SELECT g FROM Group g", Group.class).getResultList();
        artists.addAll(groups);


        return artists;
    }

    public Set<String> getPlaces() {

        List<String> places = db.createQuery("SELECT p.location FROM Place p", String.class).getResultList();
        return new HashSet<>(places);

    }

    public Set<String> getCityConcertArtist(Users artist) {
        List<String> places = db.createQuery("SELECT c.place.location FROM Concert c WHERE c.artist = :artist", String.class)
                .setParameter("artist", artist)
                .getResultList();
        return new HashSet<>(places);
    }

    public List<Users> getArtistConcertCity(String city) {
        List<Users> artists = db.createQuery("SELECT c.artist FROM Concert c WHERE c.place.location = :city", Users.class)
                .setParameter("city", city)
                .getResultList();
        return artists;
    }

    public List<LocalDate> getConcertDates(Users artist, String city) {

        List<LocalDate> d = db.createQuery("SELECT c.date FROM Concert c WHERE c.artist = :artist AND c.place.location = :city", LocalDate.class)
                .setParameter("artist", artist)
                .setParameter("city", city)
                .getResultList();
        return d;

    }


    public List<Concert> getConcerts(Users artist, String city, LocalDate date) {
        List<Concert> concerts = db.createQuery("SELECT c FROM Concert c WHERE c.artist = :artist AND c.place.location = :city AND c.date = :date", Concert.class)
                .setParameter("artist", artist)
                .setParameter("city", city)
                .setParameter("date", date)
                .getResultList();
        return concerts;
    }


    public Reservation reserve(int numTickets, Concert concert, ExternalUser user) {

            double pricePaid = concert.getTicketPrice() * numTickets;

            if (pricePaid <= 200) {

                db.getTransaction().begin();

                concert.setNumTickets(concert.getNumTickets() - numTickets);

                LocalDate date = concert.getDate();
                LocalDate today = LocalDate.now();

                boolean isDiscounted = false;

                if (today.isBefore(date.minusDays(30))) {

                    pricePaid = pricePaid -( pricePaid * (concert.getDiscount() / 100));
                    isDiscounted = true;

                }

                Reservation r = new Reservation(concert, numTickets, user);
                r.setPricePaid(pricePaid);
                r.setDiscounted(isDiscounted);
                user.addReservation(r);

                concert.addReservation(r);
                db.persist(concert);
                db.persist(r);
                db.getTransaction().commit();
                System.out.println("Reservation made");
                return r;
            }

        return null;
    }

    public ExternalUser UserLoggedIn(String email) {

        List<ExternalUser> users = db.createQuery("SELECT e FROM ExternalUser e WHERE e.email = :email", ExternalUser.class)
                .setParameter("email", email)
                .getResultList();
        return users.get(0);
    }

    public void addSoloist(String name, int year) {
        db.getTransaction().begin();
        Soloist soloist = new Soloist(name, year);
        db.persist(soloist);
        db.getTransaction().commit();
    }

    public void addGroup(String name, int year, String leader) {
        db.getTransaction().begin();
        Group group = new Group(name, year, leader);
        db.persist(group);
        db.getTransaction().commit();
    }

    public void addPlace(String name, String location, int maxcap) {
        db.getTransaction().begin();
        Place place = new Place(name, location, maxcap);
        db.persist(place);
        db.getTransaction().commit();
    }

    public void addConcert(Users artist, String place, LocalDate date, double ticketPrice, double discount) {
        db.getTransaction().begin();

        List<Place> places = db.createQuery("SELECT p FROM Place p WHERE p.location = :location", Place.class)
                .setParameter("location", place)
                .getResultList();

        Concert concert = new Concert(artist, places.get(0), date, ticketPrice, discount);
        concert.setNumTickets(places.get(0).getMaxCapacity());
        places.get(0).addConcert(concert);
        db.persist(concert);
        db.getTransaction().commit();
    }

    public List<Reservation> getReservation(String artist, String city, String numTickets, String pricePaid){

        int numtic = Integer.parseInt(numTickets);
        double pp = Double.parseDouble(pricePaid);
        String c= city.toUpperCase();

        System.out.println("artist: " + artist + " city: " + c + " numTickets: " + numtic + " pricePaid: " + pp);

        List<Reservation> reservs = db.createQuery("SELECT r FROM Reservation r WHERE r.concert.artist.name= :artist AND r.concert.place.location= :c AND r.numTickets= :numtic AND r.pricePaid= :pp", Reservation.class)
                .setParameter("artist", artist)
                .setParameter("c", c)
                .setParameter("numtic", numtic)
                .setParameter("pp", pp)
                .getResultList();

        System.out.println("Reservations found in database: "+reservs.toString());

        return reservs;
    }



}
