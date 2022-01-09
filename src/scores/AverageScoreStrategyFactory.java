package scores;

import java.util.ArrayList;

public class AverageScoreStrategyFactory {
    public AverageScoreStrategy createStrategy(final int age,
                                               final ArrayList<Double> niceScore) {
        if (age < 5) {
            return new BabyStrategy(age, niceScore);
        } else if (age >= 5 && age < 12) {
            return new KidStrategy(age, niceScore);
        } else if (age >= 12 && age <= 18) {
            return new TeenStrategy(age, niceScore);
        } else {
            return new YoungAdultStrategy(age, niceScore);
        }
    }
}
