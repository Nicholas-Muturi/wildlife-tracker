import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class NormalAnimalTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    public NormalAnimal newAnimal() {
        return new NormalAnimal("Goat","Healthy","Young");
    }

    @Test
    public void animal_instantiatesCorrectly_true(){
        NormalAnimal normalAnimal = newAnimal();
        assertTrue(normalAnimal instanceof NormalAnimal);
    }

    @Test
    public void getName_returnAnimalsName(){
        NormalAnimal normalAnimal = newAnimal();
    }

    @Test
    public void getHealth_returnAnimalsHealth(){
        NormalAnimal normalAnimal = newAnimal();
        assertEquals("Healthy", normalAnimal.getHealth());
    }

    @Test
    public void getAge_returnAnimalsAge(){
        NormalAnimal normalAnimal = newAnimal();
        assertEquals("Young", normalAnimal.getAge());
    }

    @Test
    public void getStatus_returnAnimalsStatus(){
        NormalAnimal normalAnimal = newAnimal();
        assertEquals("Not Endangered", normalAnimal.getType());
    }

}