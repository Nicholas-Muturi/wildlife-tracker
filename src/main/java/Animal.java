import org.sql2o.Connection;

import java.util.List;

@SuppressWarnings("ALL")
public abstract class Animal {
    public int id;
    public String name;
    public String health;
    public String age;
    public static final String[] healthTypes = {"Healthy","Sick","Verge of dying"};
    public static final String[] ageTypes = {"New born","Baby","Young adult","Adult","Elderly"};

    public static List<String> allAnimalNames(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT name FROM animals")
                    .executeAndFetch(String.class);
        }
    }

}
