package es.urjc.etsii.mtenrero.BusinessLogic;

import es.urjc.etsii.mtenrero.BusinessLogic.Helpers.ListSorter;
import es.urjc.etsii.mtenrero.Entities.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcostenrero on 2/3/17.
 */
public class TestListSorter {

    @Test
    public void testSortWithoutOccurrences() {
        List<Client> clients = new ArrayList<>();

        // Add some data
        clients.add(new Client(1,"Juan","Gregorio"));
        clients.add(new Client(2,"Mario","Torres"));
        clients.add(new Client(3,"Sofia","Reyes"));

        // Order data
        ListSorter listSorter = new ListSorter(clients);
        List sortedList = listSorter.sortByOccurrences();

        // Asserts
        Assert.assertArrayEquals(clients.toArray(), sortedList.toArray());
    }

    @Test
    public void testWithOccurrences() {
        List<Client> clients = new ArrayList<>();

        // Add some data
        clients.add(new Client(1,"Juan","Gregorio"));
        clients.add(new Client(1,"Juan","Gregorio"));
        clients.add(new Client(3,"Sofia","Reyes"));

        // Order data
        ListSorter listSorter = new ListSorter(clients);
        List sortedList = listSorter.sortByOccurrences();

        // Asserts
        Assert.assertTrue(sortedList.size() == 2);
        Assert.assertEquals(sortedList.get(0), clients.get(0));
        Assert.assertEquals(sortedList.get(1), clients.get(2));

    }

}
