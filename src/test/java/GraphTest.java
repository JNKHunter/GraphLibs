import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by John on 4/14/18.
 */
public class GraphTest {

    public Graph graph;

    @Before
    public void setUp() {
        graph = new Graph(5);
    }

    @Test
    public void adj() throws Exception {
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        Iterator adj = graph.adj(0).iterator();

        Integer n = 0;
        while(adj.hasNext()) {
            n += (Integer)adj.next();
        }
        assertTrue(n == 6);
    }

    @Test
    public void getNumVertices() throws Exception {
        assertTrue(graph.getNumVertices() == 5);
    }

}