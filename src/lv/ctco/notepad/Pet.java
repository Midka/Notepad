package lv.ctco.notepad;

import java.time.LocalDate;

/**
 * Created by m.troushnikova on 12/7/2018.
 */
public class Pet extends Record implements WithBirthday {
    private String name;
    private LocalDate birthday;

    @Override
    public boolean contains(String str) {
        return false;
    }

    @Override
    public void askData() {

    }

    @Override
    public LocalDate getBirthay() {
        return null;
    }

    @Override
    public void setBirthday(LocalDate birthday) {

    }

    @Override
    public boolean hasBirthdayThisMonth() {
        return false;
    }
}
