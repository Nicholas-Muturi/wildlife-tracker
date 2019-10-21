package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int animalid;
    private String animalName;
    private int rangerid;
    private String rangerName;
    private String location;
    private Timestamp timestamp;
    private String formattedTimestamp;
    private int id;

    public Sighting(int animalid, String location, int rangerid) {
        this.animalid = animalid;
        this.location = location.trim();
        this.timestamp = new Timestamp(new Date().getTime());
        this.formattedTimestamp = DateFormat.getDateTimeInstance().format(timestamp);
        this.rangerid = rangerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animalid == sighting.animalid &&
                rangerid == sighting.rangerid &&
                Objects.equals(location, sighting.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalid, location, rangerid);
    }

    public int getAnimalid() {
        return animalid;
    }

    public String getLocation() {
        return location;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getProperTimestamp(){
        return formattedTimestamp;
    }

    public int getRangerid() {
        return rangerid;
    }

    public int getId() {
        return id;
    }

    /*-------------- models.DB OPERATIONS --------------*/
    public void save(){
        String sql = "INSERT INTO sightings(animalid,location,timestamp,rangerid) values (:animalid,:location,:timestamp,:rangerid)";
        try(Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalid",this.animalid)
                    .addParameter("location",this.location)
                    .addParameter("timestamp",this.timestamp)
                    .addParameter("rangerid",this.rangerid)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public String getRangerName(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT name FROM rangers WHERE id=:id")
                    .addParameter("id",getRangerid())
                    .executeAndFetchFirst(String.class);
        }
    }

    public String getAnimalName(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT name FROM animals WHERE id=:id")
                    .addParameter("id",getAnimalid())
                    .executeAndFetchFirst(String.class);
        }
    }

    public static List<Sighting> all(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Sighting.class);
        }
    }

    public static Sighting find(int searchId){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id=:id")
                    .addParameter("id",searchId)
                    .executeAndFetchFirst(Sighting.class);
        }
    }

    public static List<String> allLocations(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT location FROM sightings")
                    .executeAndFetch(String.class);
        }
    }

    public static List<Sighting> allSightingsInLocation(String locationFilter){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings where location = :location")
                    .addParameter("location",locationFilter)
                    .executeAndFetch(Sighting.class);
        }
    }

}
