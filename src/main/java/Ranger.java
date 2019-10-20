import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Ranger {
    private int id;
    private String name;

    public Ranger(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return name.equals(ranger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*-------------- DB OPERATIONS --------------*/
    public void save(){
        String sql = "INSERT INTO rangers(name) VALUES(:name)";
        try(Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public static List<Ranger> all(){
       try(Connection con = DB.sql2o.open()){
           return con.createQuery("SELECT * FROM rangers")
                   .executeAndFetch(Ranger.class);
       }
    }

    public static Random find(int searchId){
        return null;
    }

    public List<Sighting> mySightings(){
        return null;
    }

}
