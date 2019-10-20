import org.junit.Rule;
import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

public class SightingTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();
    
    private Sighting newSighting(){
        return new Sighting(1,"Zone A",1);
    }
    
    @Test
    public void sighting_instantiatesCorrectly(){
        Sighting sighting = newSighting();
        assertTrue(sighting instanceof Sighting);
    }

    @Test
    public void getAnimalId_returnAnimalId_true(){
        Sighting sighting = newSighting();
        assertEquals(1,sighting.getAnimalid());
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
        Sighting sighting2 = new Sighting(2,"Zone 2",2);
        sighting1.save();
        sighting2.save();
        assertTrue(Sighting.find(sighting2.getId()).equals(sighting2));
    }





}