package lv.ctco.notepad;

import static lv.ctco.notepad.Main.askString;
import static lv.ctco.notepad.Main.validatePhone;

/**
 * Created by m.troushnikova on 11/16/2018.
 */
public class Person extends Record {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String gender;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                " id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return name.toLowerCase().contains(str)
                || surname.toLowerCase().contains(str)
                || phone.toLowerCase().contains(str)
                || email.toLowerCase().contains(str);
    }

    @Override
    public void askData() {
        setName(askString("Enter person's name:"));
        setSurname(askString("Enter person's surname:"));
        setPhone(validatePhone());
        setEmail(askString("Enter person's e-mail:"));
    }
}
