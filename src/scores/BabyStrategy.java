package scores;

import java.util.ArrayList;

public class BabyStrategy implements AverageScoreStrategy {
    private int age;
    private ArrayList<Double> niceScore;

    public BabyStrategy(int age, ArrayList<Double> niceScore) {
        this.age = age;
        this.niceScore = niceScore;
    }

    public ArrayList<Double> getNiceScore() {
        return niceScore;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Double getAverageScore() {
        return 10.0;
    }
}
