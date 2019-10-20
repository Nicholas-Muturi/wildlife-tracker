import java.util.Objects;

public class Animal {
    private int id;
    private String name;
    private String health;
    private String age;
    private String status;

    public static final String[] healthTypes = {"Healthy","Sick","Verge of dying"};
    public static final String[] ageTypes = {"New born","Baby","Young adult","Adult","Elderly"};
    public static final String[] statusTypes = {"Endangered","Not Endangered"};

    public Animal(String name, String health, String age, String status) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return  Objects.equals(name, animal.name) &&
                Objects.equals(health, animal.health) &&
                Objects.equals(age, animal.age) &&
                Objects.equals(status, animal.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age, status);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String[] getHealthTypes() {
        return healthTypes;
    }

    public static String[] getAgeTypes() {
        return ageTypes;
    }

    public static String[] getStatusTypes() {
        return statusTypes;
    }
}
