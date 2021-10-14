//CSU33012 - Software Engineering
//Java program to find the Lowest Common Ancestor of 2 nodes
//Implemented using Method 2 from https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//Codes' use is to practice uploading to Bitbucket and Github repositories


//Node class with left and right child of current node, and key value. 
class Node {

    Node left, right;
    int data;

    public Node(int item){

        data = item;
        left = right = null;
    }
}

//class implemented using Binary Tree
public class LCA {

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
