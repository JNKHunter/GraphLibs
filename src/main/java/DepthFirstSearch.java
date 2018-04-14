/**
 * Created by John on 4/14/18.
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    /**
     * 
     * @param G The Graph object
     * @param s The source vertex
     */
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.getNumVertices()];
        validateVertex(s);
        dfs(G,s);
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public boolean isMarked(int v) {
        validateVertex(v);
        return marked[v];
    }
}
