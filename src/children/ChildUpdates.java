package children;

import java.util.ArrayList;

public class ChildUpdates {
    private final int id;
    private final Double niceScore;
    private final ArrayList<String> giftsPreferences;

    /**
     * constructor for a child updates object
     * @param id of the child wanted to be updated
     * @param niceScore the newNiceScore for the list
     * @param giftsPreferences the new preferences
     */
    public ChildUpdates(final int id,
                        final Double niceScore,
                        final ArrayList<String> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public final ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final int getId() {
        return id;
    }

    @Override
    public final String toString() {
        return "{"
                + "id=" + id
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + '}';
    }
}
