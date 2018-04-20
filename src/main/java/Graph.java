import java.util.List;

/**
 * Created by John on 4/13/18.
 */
public class Graph {

    private final int V;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<>();
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    public int getNumVertices() {
        return V;
    }



}
