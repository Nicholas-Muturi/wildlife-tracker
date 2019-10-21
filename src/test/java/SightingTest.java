import models.Sighting;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SightingTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();
    
    private Sighting newSighting(){
        return new Sighting("Kondoo","Zone A",1);
    }

    private Sighting newSighting2(){return new Sighting("Mbuzi","Zone B",2);}
    
    @Test
    public void sighting_instantiatesCorrectly(){
        Sighting sighting = newSighting();
        assertTrue(sighting instanceof Sighting);
    }

    @Test
    public void getAnimalId_returnAnimalName_true(){
        Sighting sighting = newSighting();
        assertEquals("Kondoo",sighting.getAnimalName());
    }

    @Test
    public void getLocation_returnSightingLocation_true(){
        Sighting sighting = newSighting();
        assertEquals("Zone A",sighting.getLocation());
    }

    @Test
    public void getRangerId_returnRangerId_true(){
        Sighting sighting = newSighting();
        assertEquals(1,sighting.getRangerid());
    }

    @Test
    public void getTimestamp_returnRangerId_true(){
        Sighting sighting = newSighting();
        Timestamp testTimestamp = new Timestamp(new Date().getTime());
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        assertEquals(dateFormat.format(testTimestamp),dateFormat.format(sighting.getTimestamp()));
    }

    @Test
    public void save_savesSightingIntoDB_true(){
        Sighting sighting = newSighting();
        int idBefore = sighting.getId();
        sighting.save();
        assertNotEquals(idBefore,sighting.getId());
    }

    @Test
    public void find_searchForSighting_true(){
        Sighting sighting1 = newSighting();
        Sighting sighting2 = newSighting2();
        sighting1.save();
        sighting2.save();
        System.out.println();
        assertTrue(Sighting.find(sighting2.getId()).equals(sighting2));
    }

    @Test
    public void all_getAllSightings_true(){
        Sighting sighting1 = newSighting();
        Sighting sighting2 = newSighting2();
        sighting1.save();
        sighting2.save();
        assertTrue(Sighting.all().contains(sighting1));
        assertTrue(Sighting.all().contains(sighting2));
    }

    @Test
    public void all_getAllLocations_true(){
        Sighting sighting1 = newSighting();
        Sighting sighting2 = newSighting2();
        sighting1.save();
        sighting2.save();
        assertEquals(2, Sighting.getAllLocations().size());
    }

    @Test
    public void filter_getSightingInSingleLocation_true(){
        Sighting sighting1 = newSighting();
        Sighting sighting2 = newSighting2();
        Sighting sighting3 = new Sighting("Mbwa","Zone A",3);
        sighting1.save();
        sighting2.save();
        sighting3.save();
        assertTrue(Sighting.getAllSightingsInLocation("Zone A").contains(sighting1));
        assertTrue(Sighting.getAllSightingsInLocation("Zone A").contains(sighting3));
    }






}