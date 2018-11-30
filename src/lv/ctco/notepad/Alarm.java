package lv.ctco.notepad;

import java.time.LocalTime;

public class Alarm extends StickyNote {

    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    private String getFormattedTime() {
        return time.format(Main.TIME_FORMATTER);
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str) || getFormattedTime().contains(str);
    }

    @Override
    public void askData() {
        super.askData();
        setTime(Main.askTime("Enter time:"));
    }

    @Override
    public String toString() {
        return "Alarm{" +
                " id='" + getId() + '\'' +
                ", text='" + getText() + '\'' +
                ", time=" + time +
                '}';
    }
}
