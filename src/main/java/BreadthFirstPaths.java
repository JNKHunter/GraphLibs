import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by John on 4/16/18.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] depths;

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.getNumVertices()];
        edgeTo = new int[G.getNumVertices()];
        depths = new int[G.getNumVertices()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        depths[s] = 0;
        while(!q.isEmpty()){
            Integer cur = q.remove();
            for(int w : G.adj(cur)){
                if(!marked[w]){
                    q.add(w);
                    depths[w] = depths[cur] + 1;
                    marked[w] = true;
                    edgeTo[w] = cur;
                }
            }
        }
    }

    public int getDistance(int v){
        return depths[v];
    }
}
