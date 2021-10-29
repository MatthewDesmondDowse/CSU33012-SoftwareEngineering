//First attempt at LCA for DAG
//Implementation using Directed Graph java file from https://algs4.cs.princeton.edu/42digraph/Digraph.java.html

import java.util.ArrayList;

public class DAG
{
	private  int V;          			// number of vertices in this digraph
	private int E;              		// number of edges in this digraph
	private int[] indegree;     		// indegree[v] = indegree of vertex v
	private ArrayList<Integer>[] adj;   //adjacency list for vertices
	
	
    public DAG(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }
    
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }
    
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }
    
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    
    public DAG reverse() {
        DAG reverse = new DAG(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
}

