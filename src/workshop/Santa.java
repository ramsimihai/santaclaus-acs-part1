package workshop;

import children.Child;
import children.ChildUpdates;
import fileio.*;
import gifts.Gift;
import memory.AnnualChanges;
import memory.InitialData;
import updates.ChangeOfTheYear;

import java.util.ArrayList;
import java.util.List;

public class Santa {
    private static Santa santa = null;
    private int noYears = 0;
    private Double santasBudget = 0.0;
    private InitialData initialData = new InitialData();
    private AnnualChanges annualChanges = new AnnualChanges();

    private Santa() {
    }

    public Santa(final int noYears,
                 final Double santasBudget) {
        this.noYears = noYears;
        this.santasBudget = santasBudget;
        this.initialData = null;
        this.annualChanges = null;
    }

    /**
     * @return gets the instance of Database
     */
    public static Santa getInstance() {
        if (santa == null) {
            santa = new Santa();
        }

        return santa;
    }

    public void addInitialData(InitialDataInput input) {
        List<ChildrenInput> childrenInput = input.getChildrenList();
        List<GiftInput> giftsInput = input.getGiftsList();
        List<Child> childrenList = santa.addChildren(childrenInput);
        List<Gift> giftsList = santa.addGifts(giftsInput);

        initialData = new InitialData(childrenList, giftsList);
    }

    public void addAnnualChanges(AnnualChangesInput input) {
        List<ChangeOfTheYearInput> changesInput = input.getChanges();
        List<ChangeOfTheYear> changes = new ArrayList<>();

        for (ChangeOfTheYearInput oneChange : changesInput) {
            ArrayList<Child> childrenList = santa.addChildren(oneChange.getNewChildren());
            ArrayList<Gift> giftsList = santa.addGifts(oneChange.getNewGifts());
            ArrayList<ChildUpdates> updates = santa.addUpdates(oneChange.getNewUpdates());

            ChangeOfTheYear newChange = new ChangeOfTheYear(
                    oneChange.getNewSantaBudget(),
                    giftsList,
                    childrenList,
                    updates
            );
            changes.add(newChange);
        }

        annualChanges = new AnnualChanges(changes);
    }

    public ArrayList<Child> addChildren(List<ChildrenInput> childrenInput) {
        ArrayList<Child> children = new ArrayList<>();

        for (ChildrenInput childInput : childrenInput) {
            Child newChild = new Child(
                    childInput.getId(),
                    childInput.getLastName(),
                    childInput.getFirstName(),
                    childInput.getAge(),
                    childInput.getCity(),
                    childInput.getNiceScore(),
                    childInput.getGiftsPreferences()
            );
            children.add(newChild);
        }

        return children;
    }

    public ArrayList<Gift> addGifts(List<GiftInput> giftsInput) {
        ArrayList<Gift> gifts = new ArrayList<>();

        for (GiftInput giftInput : giftsInput) {
            Gift newGift = new Gift(
                    giftInput.getProductName(),
                    giftInput.getPrice(),
                    giftInput.getCategory()
            );

            gifts.add(newGift);
        }

        return gifts;
    }

    public ArrayList<ChildUpdates> addUpdates(List<ChildrenUpdatesInput> updatesInput) {
        ArrayList<ChildUpdates> updates = new ArrayList<>();

        for (ChildrenUpdatesInput updateInput : updatesInput) {
            ChildUpdates newUpdate = new ChildUpdates(
                    updateInput.getId(),
                    updateInput.getNiceScore(),
                    updateInput.getGiftsPreferences()
            );

            updates.add(newUpdate);
        }

        return updates;
    }

    public int getNoYears() {
        return noYears;
    }

    public Double getSantasBudget() {
        return santasBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public AnnualChanges getAnnualChanges() {
        return annualChanges;
    }

    @Override
    public String toString() {
        return "{" +
                "noYears=" + noYears +
                ", santasBudget=" + santasBudget +
                ", initialData=" + initialData +
                ", annualChanges=" + annualChanges +
                '}';
    }
}
