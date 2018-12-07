package lv.ctco.notepad;

import java.time.LocalDate;

/**
 * Created by m.troushnikova on 12/7/2018.
 */
public interface WithBirthday {
    LocalDate getBirthay();

    void setBirthday(LocalDate birthday);

    boolean hasBirthdayThisMonth();
}
