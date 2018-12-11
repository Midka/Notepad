package lv.ctco.notepad;


import java.util.Objects;

public abstract class Record {
    private static
    int counter = 0;
    private int id;
    Record() {
        counter++;
        id = counter;
    }

    public abstract boolean contains(String str);

    public abstract void askData();

    int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        return id == record.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
//        return id;
    }
}
