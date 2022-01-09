package workshop;

import fileio.AnnualChangesInput;
import fileio.ChangeOfTheYearInput;
import fileio.ChildrenInput;
import fileio.ChildrenUpdatesInput;
import fileio.GiftInput;
import fileio.InitialDataInput;

import children.Child;
import children.ChildUpdates;
import gifts.Gift;
import memory.AnnualChanges;
import memory.InitialData;
import updates.ChangeOfTheYear;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import scores.AverageScoreStrategy;
import scores.AverageScoreStrategyFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static common.Constants.TEEN_NUMBER;

public final class Santa {
    private static Santa santa = null;
    private int noYears = 0;
    private Double santasBudget = 0.0;
    private InitialData initialData = new InitialData();
    private AnnualChanges annualChanges = new AnnualChanges();
    private List<Child> children = new ArrayList<>();
    private List<Gift> availableGifts = new ArrayList<>();
    private int actualYear = 0;
    private Double budgetUnit = 0.0;
    private List<Child> rewardedChildren = new ArrayList<>();

    private Santa() {
    }

    public void setSantasBudget(final Double santasBudget) {
        this.santasBudget = santasBudget;
    }

    public void setNoYears(final int noYears) {
        this.noYears = noYears;
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

    public void incrementsAge() {

        for (Child child : children) {
            child.setAge(child.getAge() + 1);
        }
    }

    public void addNewChildren(final ChangeOfTheYear change) {
        if (actualYear == 0 || change.getNewChildren() == null) {
            return;
        }

        for (Child child : change.getNewChildren()) {
            children.add(child);
        }
    }

    public void deleteYoungAdults() {
        children.removeIf(child -> child.getAge() > TEEN_NUMBER);
    }

    public void sortChildren() {
        Comparator<Child> idComparator = Comparator.comparing(Child::getId);

        children = children.stream().sorted(idComparator).collect(Collectors.toList());
    }

    public void sortGifts() {
        Comparator<Gift> priceComparator = Comparator.comparing(Gift::getPrice);
        Comparator<Gift> categoryComparator = Comparator.comparing(Gift::getCategory)
                                                        .thenComparing(priceComparator);

        availableGifts = availableGifts.stream().sorted(categoryComparator)
                                                .collect(Collectors.toList());
    }

    public void updateChildren(final ChangeOfTheYear change) {
        if (actualYear == 0 || change.getNewUpdates() == null) {
            return;
        }

        List<ChildUpdates> updates = change.getNewUpdates();
        for (ChildUpdates update : updates) {
            Child updatedChild = null;
            for (Child child : children) {
                if (update.getId() == child.getId()) {
                    updatedChild = child;

                    break;
                }
            }

            if (updatedChild != null) {
                if (update.getNiceScore() != null) {
                    updatedChild.getNiceScore().add(update.getNiceScore());
                }


                List<String> preferences = updatedChild.getGiftsPreferences();

                // lista noua
                List<String> duplicatedNewPreferences = update.getGiftsPreferences();
                // lista noua care e ok si all good
                List<String> uniqueNewPreferences = new ArrayList<>(
                        new LinkedHashSet<>(duplicatedNewPreferences));

                Collections.reverse(uniqueNewPreferences);

                for (String preference : uniqueNewPreferences) {
                    if (preferences.contains(preference)) {
                        preferences.remove(preference);
                    }

                    preferences.add(0, preference);
                }
            }
        }
    }

    public void addNewGifts(final ChangeOfTheYear change) {
        if (actualYear == 0 || change.getNewGifts() == null) {
            return;
        }

        for (Gift gift : change.getNewGifts()) {
            availableGifts.add(gift);
        }
    }

    public void initializeBudget(final ChangeOfTheYear change) {
        santasBudget = change.getNewSantaBudget();
        Double overallAverageScore = 0.0;
        for (Child child : children) {
            overallAverageScore += child.getAverageScore();
        }

        if (overallAverageScore != 0.0) {
            budgetUnit = santasBudget / overallAverageScore;
        } else {
            budgetUnit = santasBudget;
        }

        for (Child child : children) {
            child.setBudget(child.getAverageScore() * budgetUnit);
            child.setInitialBudget(child.getAverageScore() * budgetUnit);
        }
    }

    public void getTypesOfChildren() {
        AverageScoreStrategyFactory factory = new AverageScoreStrategyFactory();

        for (Child child : children) {
            AverageScoreStrategy newStrategy = factory.createStrategy(child.getAge(),
                    child.getNiceScore());
            child.setStrategy(newStrategy);
            child.setAverageScore(child.getStrategy().getAverageScore());
        }
    }

    public void yearDelivery() {
        rewardedChildren.clear();
        for (Child child : children) {
            child.getReceivedGifts().clear();
            ArrayList<String> preferences = child.getGiftsPreferences();

            for (String preferredGift : preferences) {
                for (Gift singleGift : availableGifts) {
                    if (singleGift.getCategory().equals(preferredGift)
                            && singleGift.getPrice() < child.getAssignedBudget()) {
                        child.getReceivedGifts().add(singleGift);
                        child.setBudget(child.getAssignedBudget()
                                - singleGift.getPrice());

                        break;
                    }
                }
            }
        }
    }

    public JSONArray getOutput() {
        JSONArray childrenJSON = new JSONArray();
        for (Child child : children) {
            JSONObject childJSON = child.getJSON();
            childrenJSON.add(childJSON);
        }

        return childrenJSON;
    }

    public int getActualYear() {
        return actualYear;
    }

    public JSONArray startDelivery() {
        JSONArray annualChildrenJSON = new JSONArray();
        actualYear = 0;
        while (true) {
            ChangeOfTheYear annualChange = annualChanges.getChanges().get(actualYear);

            addNewChildren(annualChange);
            deleteYoungAdults();
            sortChildren();
            updateChildren(annualChange);


            addNewGifts(annualChange);
            sortGifts();

            getTypesOfChildren();
            initializeBudget(annualChange);

            yearDelivery();

            JSONObject objJSON = new JSONObject();
            objJSON.put("children", getOutput());
            annualChildrenJSON.add(objJSON);

            if (actualYear == noYears) {
                break;
            }

            incrementsAge();
            actualYear++;
        }

        return annualChildrenJSON;
    }

    public void addInitialData(final InitialDataInput input) {
        if (input == null) {
            return;
        }

        List<ChildrenInput> childrenInput = input.getChildrenList();
        List<GiftInput> giftsInput = input.getGiftsList();
        List<Child> childrenList = santa.addChildren(childrenInput);
        List<Gift> giftsList = santa.addGifts(giftsInput);

        santa.setChildren(childrenList);
        santa.setAvailableGifts(giftsList);
        initialData = new InitialData(childrenList, giftsList);
    }

    public void addAnnualChanges(final AnnualChangesInput input) {
        if (input == null) {
            return;
        }

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

    public ArrayList<Child> addChildren(final List<ChildrenInput> childrenInput) {
        ArrayList<Child> initialChildren = new ArrayList<>();

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
            initialChildren.add(newChild);
        }

        return initialChildren;
    }

    public ArrayList<Gift> addGifts(final List<GiftInput> giftsInput) {
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

    public ArrayList<ChildUpdates> addUpdates(final List<ChildrenUpdatesInput> updatesInput) {
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

    public ChangeOfTheYear addChange() {
        ChangeOfTheYear newChange = new ChangeOfTheYear(santasBudget,
                santa.getInitialData().getGiftsList(),
                santa.getInitialData().getChildrenList(),
                new ArrayList<>()
        );

        return newChange;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public AnnualChanges getAnnualChanges() {
        return annualChanges;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setActualYear(final int actualYear) {
        this.actualYear = actualYear;
    }

    public void setAvailableGifts(final List<Gift> availableGifts) {
        this.availableGifts = availableGifts;
    }

    public void setChildren(final List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{"
                + "noYears=" + noYears
                + ", santasBudget=" + santasBudget
                + ", initialData=" + initialData
                + ", annualChanges=" + annualChanges
                + '}';
    }
}
