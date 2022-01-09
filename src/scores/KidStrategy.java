package scores;

import java.util.ArrayList;

public class KidStrategy implements AverageScoreStrategy {
    private int age;
    private ArrayList<Double> niceScore;

    public KidStrategy(int age, ArrayList<Double> niceScore) {
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
        Double sum = 0.0;
        for (Double score : niceScore) {
            sum += score;
        }

        return sum / niceScore.size();
    }
}
