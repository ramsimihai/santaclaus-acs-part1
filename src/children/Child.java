package children;

import fileio.ChildrenInput;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final int age;
    private final String city;
    private final Double niceScore;
    private final ArrayList<String> giftsPreferences;

    public Child(final int id,
                 final String lastName,
                 final String firstName,
                 final int age,
                 final String city,
                 final Double niceScore,
                 final ArrayList<String> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public Child() {
        this.id = 0;
        this.lastName = null;
        this.firstName = null;
        this.age = 0;
        this.city = null;
        this.niceScore = 0.0;
        this.giftsPreferences = null;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                '}';
    }
}
