import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 4/16/18.
 */
public class DepthFirstPathsTest {
    private Graph g;
    private DepthFirstPaths dfp;

    @Before
    public void setUp() throws Exception {
        g = new Graph(6);
    }

    @Test
    public void isMarked() throws Exception {
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,5);

        dfp = new DepthFirstPaths(g, 0);

        assertTrue(dfp.isMarked(0));
        assertTrue(dfp.isMarked(1));
        assertTrue(dfp.isMarked(2));
        assertFalse(dfp.isMarked(3));
        assertFalse(dfp.isMarked(4));
        assertFalse(dfp.isMarked(5));
    }

    @Test
    public void edgeTo() throws Exception {
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);

        dfp = new DepthFirstPaths(g, 0);
        assertEquals(4, dfp.getEdgeTo(5));
    }

}