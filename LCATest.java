import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//test class to test LCA.java

public class LCATest {

	//Test to see when root is null 
	@Test
	public void testNullRootNode() {
		
		LCA lca = new LCA();
		lca.root = null; 
		
		assertEquals("To check if node is eqaual to null", null, lca.root);	
	}
	
	//Test to make sure findLCA returns correct output
	@Test
	public void test()
	{
		//initial test, only one ancestor
		LCA lca = new LCA();
		lca.root = new Node(1);
		lca.root.left = new Node(0);
		lca.root.right = new Node(3);
		assertEquals("To check that LCA is 1", 1, lca.findLCA(0,3).data);	
	}
	
	@Test
	public void testNegativeRoot()
	{
		LCA lca2 = new LCA();
		lca2.root = new Node(-4);
		lca2.root.left = new Node(4);
		lca2.root.right = new Node(7);
		assertEquals("To check that LCA is -4", -4, lca2.findLCA(4,7).data);
	}
	
	@Test 
	public void testUnattached()
	{
		//test for lca with more nodes (increased height)
		LCA lca3 = new LCA();
		lca3.root = new Node(6);
		lca3.root.left = new Node(4);
		lca3.root.right = new Node(7);
		lca3.root.left.left = new Node(2);
		lca3.root.left.left.left = new Node(3);
		lca3.root.left.left.right = new Node(1);
		lca3.root.left.left.right.right = new Node(9);
		lca3.root.left.left.right.right.left = new Node(5);
		lca3.root.left.left.right.right.right = new Node(8);
		//test for nodes separated by more than one parent node
		assertEquals("To check that LCA is 2", 2, lca3.findLCA(3,8).data);

	}
	
	@Test 
	public void testUnattached2()
	{
		//test for lca with more nodes (increased height)
		LCA lca3 = new LCA();
		lca3.root = new Node(6);
		lca3.root.left = new Node(4);
		lca3.root.right = new Node(7);
		lca3.root.left.left = new Node(2);
		lca3.root.left.left.left = new Node(3);
		lca3.root.left.left.right = new Node(1);
		lca3.root.left.left.right.right = new Node(9);
		lca3.root.left.left.right.right.left = new Node(5);
		lca3.root.left.left.right.right.right = new Node(8);
		//test for nodes separated by more than one parent node
		assertEquals("To check that LCA is 6", 6, lca3.findLCA(5,7).data);
	}
	
///// tests I will run when I get DAG.java to work
	
	// first test with no node 
	@Test
	public void testDAG()
	{
		DAG dag = new DAG(0);
		dag.root = null;
		assertEquals("Check that LCA is null", null, dag.root);
	}
	
	//Test for 1 node (parent node)
	
//	@Test
//	public void testDAG2()
//	{
//		DAG dag = new DAG(1);
//		dag.root = new Node(1);
//		assertEquals("Check that LCA is 1", 1, dag.root);
//		
//	}
	
//	//5 vertices, 8 edges
//	@Test 
//	public void testDAG3()
//	{
//		DAG dag = new DAG(5);
//		dag.root = new Node(1);
//		
//		dag.node = new Node(5);	//cant use .left or .right anymore .... 
//		dag.addEdge(1,5);
//		
//		dag.node = new Node(3);
//		dag.addEdge(1,3);
//		
//		dag.node = new Node(6);
//		dag.addEdge(1,6);
//		
//		dag.node = new Node(9);
//		dag.addEdge(1,9);
//		
//		dag.addEdge(5,3);
//		dag.addEdge(6,3);
//		dag.addEdge(3,9);
//		dag.addEdge(6,9);
//		
//		assertEquals("Check LCA for 9 and 3 is 1", 1, dag.findLCA(9,3).data);
//	}
}
