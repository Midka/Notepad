package lv.ctco.notepad;

import static lv.ctco.notepad.Main.askString;

/**
 * Created by m.troushnikova on 11/23/2018.
 */
public class StickyNote extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StickyNote{" +
                " id='" + getId() + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return text.toLowerCase().contains(str);
    }

    @Override
    public void askData() {
        setText(askString("Enter note's text:"));
    }
}
