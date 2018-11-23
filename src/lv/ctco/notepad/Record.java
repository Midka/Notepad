package lv.ctco.notepad;

/**
 * Created by m.troushnikova on 11/23/2018.
 */
public abstract class Record {
    private static
    int counter = 0;
    private int id;
    public Record() {
        counter++;
        id = counter;
    }

    public abstract boolean contains(String str);

    public abstract void askData();

    public int getId() {
        return id;
    }
}
