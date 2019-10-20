import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

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

}