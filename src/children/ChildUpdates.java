package children;

import java.util.ArrayList;

public class ChildUpdates {
    private final int id;
    private final Double niceScore;
    private final ArrayList<String> giftsPreferences;

    public ChildUpdates(final int id,
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

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                '}';
    }
}
