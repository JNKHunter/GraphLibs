import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by John on 4/16/18.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;

    private void bfs(Graph G, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        while(!q.isEmpty()){
            Integer cur = q.remove();
            for(int w : G.adj(cur)){
                q.add(w);
                marked[w] = true;
                edgeTo[w] = cur;
            }
        }
    }
}
