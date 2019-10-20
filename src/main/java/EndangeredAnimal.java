import java.util.Objects;

public class EndangeredAnimal extends Animal {
    private static final String type = "Not Endangered";

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal EndangeredAnimal = (EndangeredAnimal) o;
        return  Objects.equals(name, EndangeredAnimal.name) &&
                Objects.equals(health, EndangeredAnimal.health) &&
                Objects.equals(age, EndangeredAnimal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public static String[] getHealthTypes() {
        return healthTypes;
    }

    public static String[] getAgeTypes() {
        return ageTypes;
    }

}
