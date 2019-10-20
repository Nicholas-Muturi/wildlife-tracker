import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class AnimalTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    public Animal newAnimal() {
        return new Animal("Goat","Healthy","Young","Endangered");
    }

    @Test
    public void animal_instantiatesCorrectly_true(){
        Animal animal = newAnimal();
        assertTrue(animal instanceof Animal);
    }

    @Test
    public void getName_returnAnimalsName(){
        Animal animal = newAnimal();
    }

    @Test
    public void getHealth_returnAnimalsHealth(){
        Animal animal = newAnimal();
        assertEquals("Healthy",animal.getHealth());
    }

    @Test
    public void getAge_returnAnimalsAge(){
        Animal animal = newAnimal();
        assertEquals("Young",animal.getAge());
    }

    @Test
    public void getStatus_returnAnimalsStatus(){
        Animal animal = newAnimal();
        assertEquals("Endangered",animal.getStatus());
    }

}