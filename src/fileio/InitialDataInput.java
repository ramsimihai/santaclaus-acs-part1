package fileio;

import java.util.ArrayList;
import java.util.List;

public class InitialDataInput {
    private final List<ChildrenInput> childrenList;
    private final List<GiftInput> giftsList;

    public InitialDataInput(final ArrayList<ChildrenInput> childrenList,
                            final ArrayList<GiftInput> giftsList) {
        this.childrenList = childrenList;
        this.giftsList = giftsList;
    }

    public List<ChildrenInput> getChildrenList() {
        return childrenList;
    }

    public List<GiftInput> getGiftsList() {
        return giftsList;
    }

    @Override
    public String toString() {
        return "InitialDataInput{" +
                "childrenList=" + childrenList +
                ", giftsList=" + giftsList +
                '}';
    }
}
