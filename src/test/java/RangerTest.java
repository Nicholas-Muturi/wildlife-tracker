import org.junit.Rule;
import org.junit.Test;

import java.util.List;

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

}