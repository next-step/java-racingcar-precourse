package racingcar.model;

import java.util.HashSet;
import java.util.Set;

public class Name {
    private String name;
    private String[] nameList;

    public Name(String name) {
        this.name = name;
    }

    public Name(String[] nameList) {
        this.nameList = nameList;
    }

    public String getName() {
        return name;
    }

    public boolean checkLength() {
        return !(name.length() > 5);
    }

    public boolean checkDuplication() {
        Set<String> duplicationSet = new HashSet<>();
        for (String name : nameList) {
            duplicationSet.add(name);
        }
        return (duplicationSet.size() == nameList.length);
    }
}