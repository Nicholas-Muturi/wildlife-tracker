import java.sql.Timestamp;
import java.util.Objects;

public class Sighting {
    private int animalid;
    private String location;
    private Timestamp time;
    private int rangerid;

    public Sighting(int animalid, String location, Timestamp time, int rangerid) {
        this.animalid = animalid;
        this.location = location;
        this.time = time;
        this.rangerid = rangerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animalid == sighting.animalid &&
                rangerid == sighting.rangerid &&
                Objects.equals(location, sighting.location) &&
                Objects.equals(time, sighting.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalid, location, time, rangerid);
    }

    public int getAnimalid() {
        return animalid;
    }

    public String getLocation() {
        return location;
    }

    public Timestamp getTime() {
        return time;
    }

    public int getRangerid() {
        return rangerid;
    }



}
