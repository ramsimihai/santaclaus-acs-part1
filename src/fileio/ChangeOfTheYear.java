package fileio;

import java.util.ArrayList;
import java.util.List;

public class ChangeOfTheYear {
    private final Double newSantaBudget;
    private final List<GiftInput> newGifts;
    private final List<ChildrenInput> newChildren;
    private final List<ChildrenUpdatesInput> newUpdates;

    public ChangeOfTheYear(final Double newSantaBudget,
                           final ArrayList<GiftInput> newGifts,
                           final ArrayList<ChildrenInput> newChildren,
                           final ArrayList<ChildrenUpdatesInput> newUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.newUpdates = newUpdates;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public List<ChildrenInput> getNewChildren() {
        return newChildren;
    }

    public List<ChildrenUpdatesInput> getNewUpdates() {
        return newUpdates;
    }

    public List<GiftInput> getNewGifts() {
        return newGifts;
    }

    @Override
    public String toString() {
        return "ChangeOfTheYear{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", newUpdates=" + newUpdates +
                '}';
    }
}
