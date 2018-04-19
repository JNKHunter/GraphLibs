import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 4/19/18.
 */
public class CCTest {
    private Graph graph;
    private int sideOfSquare = 3;

    @Before
    public void setUp() throws Exception {
        graph = new Graph((sideOfSquare*sideOfSquare) + 2); //9 * 9 board with 2 dummy vertices

        for(int i = 1; i < graph.getNumVertices() - 1; i++){
            //if last column, don't add right connection
            if(i % 3 != 0){
                graph.addEdge(i, i+1);
            }

            if(i <= (sideOfSquare * sideOfSquare) - sideOfSquare){
                graph.addEdge(i, i+sideOfSquare);
            }
        }

        //Connect dummy vertices to top and bottom rows
        for(int j = 1; j <= sideOfSquare; j++){
            graph.addEdge(0, j);
        }

        int lastRow = (graph.getNumVertices() - sideOfSquare) - 1;
        for(int k = lastRow; k < lastRow + sideOfSquare; k++){
            graph.addEdge(graph.getNumVertices() - 1, k);
        }

        int sfs = 0;

    }

    @Test
    public void testGrid() throws Exception {
        CC cc = new CC(graph);
        assertEquals(1, cc.getNumberOfComponents());
    }



}