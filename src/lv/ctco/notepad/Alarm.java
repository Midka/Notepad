package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalTime;

public class Alarm extends StickyNote implements Expirable {

    private LocalTime time;
    private LocalDate dismissedAt;

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
    public void dismiss() {
        dismissedAt = LocalDate.now();
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

    @Override
    public boolean isExpired() {
        LocalDate nowDate = LocalDate.now();
        if (dismissedAt != null && dismissedAt.isEqual(nowDate)) {
            return false;
        }
        LocalTime now = LocalTime.now();
        return time.isBefore(now);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alarm alarm = (Alarm) o;

        return time.equals(alarm.time);
    }

    @Override
    public int hashCode() {
        return time.hashCode();
    }
}
