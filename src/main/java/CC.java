/**
 * Created by John on 4/19/18.
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int[] size; //Number of vertices in each connected component
    private int count; //Number of connected components

    public CC(Graph G) {
        marked = new boolean[G.getNumVertices()];
        id = new int[G.getNumVertices()];
        size = new int[G.getNumVertices()];
        count = 0;

        for(int v = 0; v < G.getNumVertices(); v++){
            if(!marked[v]){
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for(int w: G.adj(v)){
            if(!marked[w]) dfs(G, w);
        }
    }

    public int getNumberOfComponents(){
        return count;
    }
}
