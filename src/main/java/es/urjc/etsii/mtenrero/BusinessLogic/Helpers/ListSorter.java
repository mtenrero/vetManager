package es.urjc.etsii.mtenrero.BusinessLogic.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcostenrero on 2/3/17.
 */
public class ListSorter<T> {
    private List<T> originalList;
    private HashMap<T,Integer> counterAid;
    private List<T> newList;

    public ListSorter() {
        newList = new ArrayList<>();
        counterAid = new HashMap<>();
    }

    public ListSorter(List<T> originalList) {
        this.originalList = originalList;
        newList = new ArrayList<>();
        counterAid = new HashMap<>();
    }

    public List<T> sortByOccurrences() {
        feedCounter();
        generateSortedListByOccurrence();
        return newList;
    }

    /** Fill the counterAid data structure **/
    private void feedCounter() {
        for (T object : originalList) {
            addToCountAid(object);
        }
    }

    /** Checks if the Object exists and if it's yes, increment the counter 0**/
    private void addToCountAid(T object) {
        if (counterAid.containsKey(object)) {
            counterAid.replace(object, counterAid.get(object) + 1);
        } else {
            counterAid.put(object, 1);
        }
    }

    /** Fills the new List with sorted values and without repetitions **/
    private void generateSortedListByOccurrence() {
        for (Map.Entry<T, Integer> entry : counterAid.entrySet()) {
            newList.add(originalList.get(originalList.indexOf(entry.getKey())));
        }
    }
}
