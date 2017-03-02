package es.urjc.etsii.mtenrero.BusinessLogic.Helpers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by marcostenrero on 2/3/17.
 */
public class ParseHelper {
    /** Return a List with all words in a given String **/
    public static List<String> stringSplitter(String string) {
        String[] words = string.split("\\s+");
        return Arrays.asList(words);
    }
}
