import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

/**
 * Created by John on 4/13/18.
 */
public class BagTest {

    private Bag<Integer> bag;

    @Before
    public void setUp() throws Exception {
        bag = new Bag<>();
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(bag.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertTrue(bag.size() == 0);
        bag.add(10);
        bag.add(20);
        assertTrue(bag.size() == 2);
    }

    @Test
    public void iterator() throws Exception {
        List<Integer> myList = new ArrayList<>();

        bag.add(10);
        bag.add(20);

        Iterator iterator= bag.iterator();

        while(iterator.hasNext()){
            myList.add((Integer)iterator.next());
        }

        int count = 0;
        for(Integer i : myList){
            count += i;
        }

        assertEquals(count, 30);

    }

}