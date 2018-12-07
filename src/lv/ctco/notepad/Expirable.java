package lv.ctco.notepad;

/**
 * Created by m.troushnikova on 12/7/2018.
 */
public interface Expirable {
    boolean isExpired();

    default void dismiss(){
        System.out.println("DISMISS IS NOT YET IMPLEMENTED!!! AAAA! OLJARM!");
    };

}
