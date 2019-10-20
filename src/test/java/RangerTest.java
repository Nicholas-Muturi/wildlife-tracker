import models.Ranger;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ConstantConditions")
public class RangerTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private Ranger newRanger(){
        return new Ranger("Nike");
    }

    @Test
    public void ranger_instantiatesCorrectly(){
        Ranger ranger = newRanger();
        assertTrue(ranger instanceof Ranger);
    }

    @Test
    public void getName_returnRangerName_true(){
        Ranger ranger = newRanger();
        assertEquals("Nike",ranger.getName());
    }

    @Test
    public void save_getRangerId(){
        Ranger ranger = newRanger();
        int idBefore = ranger.getId();
        ranger.save();
        assertNotEquals(idBefore,ranger.getId());
    }

    @Test
    public void all_getAllRangers(){
        Ranger ranger = newRanger();
        Ranger ranger1 = new Ranger("Stark");
        ranger.save();
        ranger1.save();
        assertTrue(Ranger.all().contains(ranger));
        assertTrue(Ranger.all().contains(ranger1));
    }

    @Test
    public void find_getParticularRanger(){
        Ranger ranger = newRanger();
        Ranger ranger1 = new Ranger("Stark");
        ranger.save();
        ranger1.save();
        assertTrue(Ranger.find(ranger.getId()).equals(ranger));
    }

    @Test
    public void add_preventDuplicateRanger(){
        Ranger ranger1 = newRanger();
        Ranger ranger2 = newRanger();
        ranger1.save();
        ranger2.save();
        for(Ranger ranger:Ranger.all()){
            if (ranger2.equals(ranger)){
                ranger2.delete();
                break;
            }
        }
        assertEquals(1,Ranger.all().size());
    }





}