import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Sighting {
    private int animalid;
    private String location;
    private Timestamp timestamp;
    private int rangerid;

    public Sighting(int animalid, String location, int rangerid) {
        this.animalid = animalid;
        this.location = location;
        this.timestamp = new Timestamp(new Date().getTime());
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

    public int getRangerid() {
        return rangerid;
    }



}
