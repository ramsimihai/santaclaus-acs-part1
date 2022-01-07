package fileio;

import java.util.List;

public class AnnualChangesInput {
    private final List<ChangeOfTheYear> changes;

    public AnnualChangesInput(List<ChangeOfTheYear> changes) {
        this.changes = changes;
    }

    public List<ChangeOfTheYear> getChanges() {
        return changes;
    }

    @Override
    public String toString() {
        return "AnnualChangesInput{" +
                "changes=" + changes +
                '}';
    }
}
