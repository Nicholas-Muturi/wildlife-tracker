import org.sql2o.Connection;

@SuppressWarnings("ALL")
public abstract class Animal {
    public int id;
    public String name;
    public String health;
    public String age;
    public static final String[] healthTypes = {"Healthy","Sick","Verge of dying"};
    public static final String[] ageTypes = {"New born","Baby","Young adult","Adult","Elderly"};

}
