package memory;

import children.Child;
import gifts.Gift;

import java.util.List;

public class InitialData {
    private final List<Child> childrenList;
    private final List<Gift> giftsList;

    public InitialData() {
        childrenList = null;
        giftsList = null;
    }

    public InitialData(List<Child> childrenList, List<Gift> giftsList) {
        this.childrenList = childrenList;
        this.giftsList = giftsList;
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public List<Gift> getGiftsList() {
        return giftsList;
    }

    @Override
    public String toString() {
        return "{" +
                "childrenList=" + childrenList +
                ", giftsList=" + giftsList +
                '}';
    }
}
