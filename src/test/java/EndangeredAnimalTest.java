import models.EndangeredAnimal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private EndangeredAnimal newAnimal() {
        return new EndangeredAnimal("Goat","Healthy","Young");
    }

    @Test
    public void animal_instantiatesCorrectly_true(){
        EndangeredAnimal endangeredAnimal = newAnimal();
        assertTrue(endangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void getName_returnAnimalsName(){
        EndangeredAnimal endangeredAnimal = newAnimal();
        assertEquals("Goat", endangeredAnimal.getName());
    }

    @Test
    public void getHealth_returnAnimalsHealth(){
        EndangeredAnimal endangeredAnimal = newAnimal();
        assertEquals("Healthy", endangeredAnimal.getHealth());
    }

    @Test
    public void getAge_returnAnimalsAge(){
        EndangeredAnimal endangeredAnimal = newAnimal();
        assertEquals("Young", endangeredAnimal.getAge());
    }

    @Test
    public void getStatus_returnAnimalsStatus(){
        EndangeredAnimal endangeredAnimal = newAnimal();
        assertEquals("Not Endangered", endangeredAnimal.getType());
    }

    @Test
    public void save_savedToDb_int(){
        EndangeredAnimal endangeredAnimal = newAnimal();
        endangeredAnimal.save();
        assertEquals(endangeredAnimal.getId(), EndangeredAnimal.all().get(0).getId());
    }

    @Test
    public void find_locateEndangeredAnimal_Name(){
        EndangeredAnimal endangeredAnimal = newAnimal();
        endangeredAnimal.save();
        EndangeredAnimal foundAnimal = EndangeredAnimal.find(endangeredAnimal.getId());
        assertEquals(endangeredAnimal,foundAnimal);
    }

}