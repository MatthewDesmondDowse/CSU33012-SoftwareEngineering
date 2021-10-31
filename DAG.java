//First attempt at LCA for DAG
//Implementation using Directed Graph java file from https://algs4.cs.princeton.edu/42digraph/Digraph.java.html

//Second attempt
// Use DFS on one of the 2 nodes
// Remembering each previous parent node
// Create separate subgraph and run LCA on that.

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
	
	// v = tail vertex, w = head vertex
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

//// Will have to change below to include DFS

	Node root; //Root of Binary Tree

	Node findLCA(int n1, int n2)
	{
		return findLCA(root, n1, n2);
	}

	Node findLCA(Node node, int n1, int n2)
	{
		//if node is null
		if(node == null ) return null; 

		//if n1 or n2 equal root's key
		if (node.data == n1 || node.data == n2) return node; 

		//look for keys in left and right subtrees
		Node left_lca = findLCA(node.left, n1, n2);
		Node right_lca = findLCA(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca!=null && right_lca!=null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}
}


