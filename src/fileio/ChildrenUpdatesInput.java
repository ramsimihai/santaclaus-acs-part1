package fileio;

import java.util.ArrayList;

public class ChildrenUpdatesInput {
    private final int id;
    private final Double niceScore;
    private final ArrayList<String> giftsPreferences;

    public ChildrenUpdatesInput(final int id,
                                final Double niceScore,
                                final ArrayList<String> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public int getId() {
        return id;
    }
}
