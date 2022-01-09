package scores;

import java.util.ArrayList;

public class TeenStrategy implements AverageScoreStrategy {
    private int age;
    private ArrayList<Double> niceScore;

    public TeenStrategy(int age, ArrayList<Double> niceScore) {
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
        Double averageScore = 0.0;

        int noScores = 0;
        int i = 1;
        for (Double score : niceScore) {
            averageScore += i * score;
            noScores += i;
            i++;
        }

        return averageScore / noScores;
    }
}
