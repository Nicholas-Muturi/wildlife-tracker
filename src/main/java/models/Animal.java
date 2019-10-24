package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
public abstract class Animal {
    public int id;
    public String name;
    public String health;
    public String age;

    public static List<String> allAnimalNames(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT name FROM animals")
                    .executeAndFetch(String.class);
        }
    }



}
