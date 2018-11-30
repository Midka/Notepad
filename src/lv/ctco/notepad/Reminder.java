package lv.ctco.notepad;

import java.time.LocalDate;

import static lv.ctco.notepad.Main.askDate;
import static lv.ctco.notepad.Main.askString;

public class Reminder extends Alarm {
    private LocalDate dueDate;

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str) || getFormattedDate().contains(str);
    }

    @Override
    public void askData() {
        super.askData();
        setDueDate(askDate("Enter reminder's due date:"));
    }

    @Override
    public String toString() {
        return "Reminder{" +
                " id='" + getId() + '\'' +
                ", time='" + getTime() + '\'' +
                ", dueDate='" + getFormattedDate() + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    private String getFormattedDate() {
        return dueDate.format(Main.DATE_FORMATTER);
    }
}
