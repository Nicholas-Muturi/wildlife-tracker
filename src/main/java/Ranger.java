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
        return name == ranger.name;
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
    public void save(){}

    public static List<Ranger> all(){
        return null;
    }

    public static Random find(){
        return null;
    }

    public List<Sighting> mySightings(){
        return null;
    }

}
