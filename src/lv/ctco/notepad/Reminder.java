package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static lv.ctco.notepad.Main.askDate;

public class Reminder extends Alarm {
    private LocalDate dueDate;
    private boolean dismissed = false;

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public void dismiss() {
        dismissed = true;
    }

    @Override
    public boolean isExpired() {
        if (dismissed) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dt = LocalDateTime.of(getDueDate(), getTime());
        return now.isAfter(dt);
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
