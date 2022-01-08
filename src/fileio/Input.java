package fileio;

public class Input {
    private final int noYears;
    private final Double santasBudget;
    private final InitialDataInput initialData;
    private final AnnualChangesInput annualChanges;

    public Input(final int noYears,
                 final Double santasBudget,
                 final InitialDataInput initialData,
                 final AnnualChangesInput annualChanges) {
        this.noYears = noYears;
        this.santasBudget = santasBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    public AnnualChangesInput getAnnualChanges() {
        return annualChanges;
    }

    public Double getSantasBudget() {
        return santasBudget;
    }

    public InitialDataInput getInitialData() {
        return initialData;
    }

    public int getNoYears() {
        return noYears;
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
