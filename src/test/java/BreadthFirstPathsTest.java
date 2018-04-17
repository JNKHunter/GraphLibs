import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 4/16/18.
 */
public class BreadthFirstPathsTest {
    private Graph g;
    private BreadthFirstPaths bfp;


    @Before
    public void setUp() throws Exception {
        g = new Graph(6);
    }

    @Test
    public void testDepth() throws Exception {
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,5);

        bfp = new BreadthFirstPaths(g, 0);

        assertEquals(3, bfp.getDistance(4));
    }

}