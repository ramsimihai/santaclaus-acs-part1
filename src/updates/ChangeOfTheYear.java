package updates;

import children.Child;
import children.ChildUpdates;
import gifts.Gift;

import java.util.ArrayList;
import java.util.List;

public class ChangeOfTheYear {
    private final Double newSantaBudget;
    private final List<Gift> newGifts;
    private final List<Child> newChildren;
    private final List<ChildUpdates> newUpdates;

    public ChangeOfTheYear(final Double newSantaBudget,
                           final List<Gift> newGifts,
                           final List<Child> newChildren,
                           final List<ChildUpdates> newUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.newUpdates = newUpdates;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public List<Gift> getNewGifts() {
        return newGifts;
    }

    public List<Child> getNewChildren() {
        return newChildren;
    }

    public List<ChildUpdates> getNewUpdates() {
        return newUpdates;
    }

    @Override
    public String toString() {
        return "{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", newUpdates=" + newUpdates +
                '}';
    }
}
