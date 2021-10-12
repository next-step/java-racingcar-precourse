package racinggame;

import java.util.Objects;

public class Record implements Comparable<Record> {
    private final String name;
    private final int position;

    public Record(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public boolean matchPosition(Record record) {
        if (record == null) {
            return false;
        }
        return this.position == record.position;
    }

    @Override
    public int compareTo(Record record) {
        return Integer.compare(this.position, record.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return position == record.position && Objects.equals(name, record.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
