package memory;

import fileio.ChangeOfTheYearInput;
import updates.ChangeOfTheYear;

import java.util.List;

public class AnnualChanges {
    private final List<ChangeOfTheYear> changes;

    public AnnualChanges() {
        changes = null;
    }

    public AnnualChanges(List<ChangeOfTheYear> changes) {
        this.changes = changes;
    }

    public List<ChangeOfTheYear> getChanges() {
        return changes;
    }

    @Override
    public String toString() {
        return "{" +
                "changes=" + changes +
                '}';
    }
}
