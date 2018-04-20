import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by John on 4/19/18.
 */
public class CCTest {
    private Graph autoGraph;
    private Graph manualGraph;
    private int sideOfSquare = 3;

    @Before
    public void setUp() throws Exception {
        autoGraph = setupBoardAutomated(sideOfSquare);
        manualGraph = setup2Components(sideOfSquare);
    }

    @Test
    public void testGridAutomated() throws Exception {
        CC cc = new CC(autoGraph);
        assertEquals(1, cc.getNumberOfComponents());
    }

    @Test
    public void test2ComponentGrid() throws Exception {

        CC cc = new CC(manualGraph);
        assertEquals(2, cc.getNumberOfComponents());
        
    }

    //This board sets up 
    private Graph setup2Components(int sideOfSquare){
        Graph graph = new Graph((sideOfSquare*sideOfSquare) + 2); //9 * 9 board with 2 dummy vertices

        //setup array
        //(List<Integer>[])
        List<Integer>[] edgeList = new ArrayList[graph.getNumVertices()];
        for(int i = 0; i < graph.getNumVertices(); i++) {
            edgeList[i] = new ArrayList<>();
        }

        //Create first component
        edgeList[1].add(2);
        edgeList[2].add(3);

        //Create second component
        edgeList[4].add(5);
        edgeList[4].add(7);
        edgeList[5].add(6);
        edgeList[5].add(8);
        edgeList[6].add(9);

        edgeList[7].add(8);
        edgeList[8].add(9);

        //Connect dummy vertices to top and bottom rows
        edgeList[0].add(1);
        edgeList[0].add(2);
        edgeList[0].add(3);

        edgeList[7].add(10);
        edgeList[8].add(10);
        edgeList[9].add(10);

        for(int i = 0; i < edgeList.length; i++){
            for(Integer vertex : edgeList[i]) {
                graph.addEdge(i, vertex);
            }
        }
        return graph;
    }
    

    private Graph setupBoardAutomated(int sideOfSquare) {
        Graph graph = new Graph((sideOfSquare*sideOfSquare) + 2); //9 * 9 board with 2 dummy vertices
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
        return graph;
    }
}