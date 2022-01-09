package updates;

import children.Child;
import children.ChildUpdates;
import gifts.Gift;

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

    /**
     * getter of new santa budget
     */
    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * getter of list of new gifts in an annual change
     */
    public List<Gift> getNewGifts() {
        return newGifts;
    }

    /**
     * getter of list of new children in an annual change
     */
    public List<Child> getNewChildren() {
        return newChildren;
    }

    /**
     * getter of list of new updates in an annual change
     */
    public List<ChildUpdates> getNewUpdates() {
        return newUpdates;
    }

    @Override
    public final String toString() {
        return "{"
                + "newSantaBudget=" + newSantaBudget
                + ", newGifts=" + newGifts
                + ", newChildren=" + newChildren
                + ", newUpdates=" + newUpdates
                + '}';
    }
}
