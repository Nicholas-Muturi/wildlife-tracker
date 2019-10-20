import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class EndangeredAnimal extends Animal {
    private static final String type = "Not Endangered";

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal EndangeredAnimal = (EndangeredAnimal) o;
        return  Objects.equals(name, EndangeredAnimal.name) &&
                Objects.equals(health, EndangeredAnimal.health) &&
                Objects.equals(age, EndangeredAnimal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    /*public static String[] getHealthTypes() {
        return healthTypes;
    }

    public static String[] getAgeTypes() {
        return ageTypes;
    }*/

    /* ----------------- DB OPERATIONS ---------------- */
    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals(name,health, age, type) values (:name,:health,:age,:type)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age",this.age)
                    .addParameter("type",type)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM animals where type=:type";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("type",type)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int searchId){
        String sql = "SELECT * FROM animals where (id=:id AND type=:type)";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",searchId)
                    .addParameter("type",type)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }

}
