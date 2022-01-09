package children;

import fileio.ChildrenInput;
import gifts.Gift;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import scores.AverageScoreStrategy;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private int id;
    private final String lastName;
    private final String firstName;
    private int age;
    private final String city;
    private ArrayList<Double> niceScore = new ArrayList<>();
    private final ArrayList<String> giftsPreferences;
    private Double averageScore;
    private AverageScoreStrategy strategy;
    private Double initialBudget;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;

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
        this.niceScore.add(niceScore);
        this.giftsPreferences = giftsPreferences;
        this.averageScore = 0.0;
        this.strategy = null;
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
        this.initialBudget = 0.0;
    }

    public Child() {
        this.id = 0;
        this.lastName = null;
        this.firstName = null;
        this.age = 0;
        this.city = null;
        this.giftsPreferences = null;
        this.averageScore = 0.0;
        this.strategy = null;
        this.assignedBudget = 0.0;
        this.initialBudget = 0.0;
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

    public void setAge(final int age) { this.age = age; }

    public String getCity() {
        return city;
    }

    public ArrayList<Double> getNiceScore() {
        return niceScore;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setBudget(Double budget) {
        this.assignedBudget = budget;
    }

    public AverageScoreStrategy getStrategy() {
        return strategy;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public void setStrategy(AverageScoreStrategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public Double getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(Double initialBudget) {
        this.initialBudget = initialBudget;
    }

    public JSONObject getJSON() {
        JSONObject newChildJSON = new JSONObject();

        newChildJSON.put("id", id);
        newChildJSON.put("lastName", lastName);
        newChildJSON.put("firstName", firstName);
        newChildJSON.put("city", city);
        newChildJSON.put("age", age);

        JSONArray giftPreferencesJSON = new JSONArray();
        for (String preference : giftsPreferences) {
            giftPreferencesJSON.add(preference);
        }
        newChildJSON.put("giftsPreferences", giftPreferencesJSON);
        newChildJSON.put("averageScore", averageScore);

        JSONArray niceScoreHistoryJSON = new JSONArray();
        for (Double score : niceScore) {
            niceScoreHistoryJSON.add(score);
        }
        newChildJSON.put("niceScoreHistory", niceScoreHistoryJSON);

        newChildJSON.put("assignedBudget", initialBudget);

        JSONArray receivedGiftsJSON = new JSONArray();
        for (Gift gift : receivedGifts) {
            JSONObject receivedGiftJSON = new JSONObject();

            receivedGiftJSON.put("productName", gift.getProductName());
            receivedGiftJSON.put("price", gift.getPrice());
            receivedGiftJSON.put("category", gift.getCategory());

            receivedGiftsJSON.add(receivedGiftJSON);
        }

        newChildJSON.put("receivedGifts", receivedGiftsJSON);

        return newChildJSON;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", giftsPreferences=" + giftsPreferences +
                ", averageScore=" + averageScore +
                ", niceScoreHistory=" + niceScore +
                ", assignedBudget=" + initialBudget +
                ", receivedGifts=" + receivedGifts +
                '}';
    }
}
