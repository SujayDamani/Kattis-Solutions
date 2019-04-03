//My solution to "Pick up sticks" problem on Kattis.
//code used from Algorithms Fourth Edition Robert Sedgewick and Kevin Wayne
import java.util.*;
import java.io.*;
import java.util.LinkedList;
public class pickupstick
{
  //taken from text book, but made few changes to it.
 static class Digraph
{
   private final int V;
   private int E;
   private LinkedList<Integer>[] adj;
   public  Digraph(int V)
   {
     this.V = V;
     this.E = 0;
     adj = (LinkedList<Integer>[]) new LinkedList[V];
     for (int v = 0; v < V; v++)
     adj[v] = new LinkedList<Integer>();
   }
   public int V() { return V; }
   public int E() { return E; }
   public void addEdge(int v, int w)
   {
     adj[v].add(w);
     E++;
   }
   public Iterable<Integer> adj(int v)
   { return adj[v];
   }
   public Digraph reverse()
   {
     Digraph R = new Digraph(V);
     for (int v = 0; v < V; v++)
     for (int w : adj(v))
     R.addEdge(w, v);
     return R;
   }
}
//taken from text book, but made few changes to it.
static class DirectedCycle
{
   private boolean[] marked;
   private int[] edgeTo;
   private Stack<Integer> cycle; // vertices on a cycle (if one exists)
   private boolean[] onStack; // vertices on recursive call stack
   public DirectedCycle(Digraph G)
   {
     onStack = new boolean[G.V()];
     edgeTo = new int[G.V()];
     marked = new boolean[G.V()];
     for (int v = 1; v < G.V(); v++)
     if (!marked[v]) dfs(G, v);
   }
   private void dfs(Digraph G, int v)
   {
     onStack[v] = true;
     marked[v] = true;
     for (int w : G.adj(v))
     if (this.hasCycle()){
       //System.out.println("Impossible");
       return;
     }
     else if (!marked[w])
     { edgeTo[w] = v; dfs(G, w); }
     else if (onStack[w])
     {
     cycle = new Stack<Integer>();
     for (int x = v; x != w; x = edgeTo[x])
     cycle.push(x);
     cycle.push(w);
     cycle.push(v);
     }
     onStack[v] = false;
   }
   public boolean hasCycle()
   { return cycle != null; }
   public Iterable<Integer> cycle()
   { return cycle; }
}
//taken from text book, but made few changes to it.
 static class DepthFirstOrder
{
   private boolean[] marked;
   private Stack<Integer> reversePost;
   public DepthFirstOrder(Digraph G)
   {
     reversePost = new Stack<Integer>();
     marked = new boolean[G.V()];
     for (int v = 1; v < G.V(); v++)
     if (!marked[v]) dfs(G, v);
   }
   private void dfs(Digraph G, int v)
   {
     marked[v] = true;
     for (int w : G.adj(v))
     if (!marked[w])
     dfs(G, w);
     reversePost.push(v);
   }
   public Iterable<Integer> reversePost()
   { return reversePost; }
}
//taken from text book, but made few changes to it.
static class Topological
{
   private Iterable<Integer> order;
   public Topological(Digraph G)
   {
     DepthFirstOrder dfs = new DepthFirstOrder(G);
     order = dfs.reversePost();

   }
   public Iterable<Integer> order()
   { return order; }
   public boolean isDAG()
   { return order == null; }
}
//The main is written by me.
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String[] line = br.readLine().split(" ");
    int sticks=Integer.parseInt(line[0]);
    int lines =Integer.parseInt(line[1]);
    StringBuilder tmp = new StringBuilder();
    Digraph G=new Digraph(sticks+1);
     for (int i = 0; i < lines; i++){
       line = br.readLine().split(" ");
       G.addEdge(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
     }
     DirectedCycle cyclefinder = new DirectedCycle(G);
     if (cyclefinder.hasCycle()){
       System.out.println("Impossible");
     }
     else{
       G=G.reverse();
       Topological reachable = new Topological(G);

       for (int w : reachable.order())
       {
           tmp.append(w);
           tmp.append("\n");

       }
       System.out.print(tmp);
     }
  }
}
