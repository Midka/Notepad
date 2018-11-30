package lv.ctco.notepad;


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
}
