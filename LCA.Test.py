#CSU33012 - Software Engineering
#Python Unit Testing for Lowest Common Ancestor
#Code's use is to pratitce Testing on a new language

import unittest
import LCA

class TestLCA(unittest.TestCase):

    #test null root (None in python)
    def testNull(self):

        LCA.root = None
        self.assertEqual(LCA.findLCA(LCA.root,0,0), None, "Should return None")

    #first test to see if code works
    def test_lca(self):
        
        LCA.root = LCA.Node(1)                       
        LCA.root.left = LCA.Node(0)
        LCA.root.right = LCA.Node(3)
       
        self.assertEqual(LCA.findLCA(LCA.root,0,3).key,1,"LCA should be 1")

    #test for negative root
    def testNegativeRoot(self):

        LCA.root = LCA.Node(-4)                       
        LCA.root.left = LCA.Node(4)
        LCA.root.right = LCA.Node(7)

        self.assertEqual(LCA.findLCA(LCA.root,4,7).key, -4, "LCA should be -4")

    #test for nodes separated by more than one parent node
    def testUnattached(self):

        LCA.root = LCA.Node(6)
        LCA.root.left = LCA.Node(4)
        LCA.root.right = LCA.Node(7)
        LCA.root.left.left = LCA.Node(2)
        LCA.root.left.left.left = LCA.Node(3)
        LCA.root.left.left.right = LCA.Node(1)
        LCA.root.left.left.right.right = LCA.Node(9)
        LCA.root.left.left.right.right.left = LCA.Node(5)
        LCA.root.left.left.right.right.right = LCA.Node(8)
        self.assertEqual(LCA.findLCA(LCA.root,3,8).key, 2, "LCA should be 2")

    #test for nodes separated by more than one parent node
    def testUnattached2(self):

        LCA.root = LCA.Node(6)
        LCA.root.left = LCA.Node(4)
        LCA.root.right = LCA.Node(7)
        LCA.root.left.left = LCA.Node(2)
        LCA.root.left.left.left = LCA.Node(3)
        LCA.root.left.left.right = LCA.Node(1)
        LCA.root.left.left.right.right = LCA.Node(9)
        LCA.root.left.left.right.right.left = LCA.Node(5)
        LCA.root.left.left.right.right.right = LCA.Node(8)
        self.assertEqual(LCA.findLCA(LCA.root,5,7).key, 6, "LCA should be 6")


if __name__ == '__main__':
    unittest.main()       
