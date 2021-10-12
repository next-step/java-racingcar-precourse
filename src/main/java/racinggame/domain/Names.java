package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    List<Name> names;

    public Names() {
        this.names = new ArrayList<>();
    }

    public void addName(Name name) {
        names.add(name);
    }

    public String printNames() {
        StringBuilder printName = new StringBuilder();
        for (Name name : names) {
            printName.append(name.getName());
            printName.append(",");
        }
        return printName.substring(0, printName.length() - 1);
    }
}
