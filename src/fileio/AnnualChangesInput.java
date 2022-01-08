package fileio;

import java.util.List;

public class AnnualChangesInput {
    private final List<ChangeOfTheYearInput> changes;

    public AnnualChangesInput(List<ChangeOfTheYearInput> changes) {
        this.changes = changes;
    }

    public List<ChangeOfTheYearInput> getChanges() {
        return changes;
    }

    @Override
    public String toString() {
        return "{" +
                "changes=" + changes +
                '}';
    }
}
