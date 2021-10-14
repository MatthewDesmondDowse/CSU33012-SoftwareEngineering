#CSU33012 - Software Engineering
#Python program to find the Lowest Common Ancestor of 2 nodes
#Implemented using Method 2 from https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
#Codes' use is to practice uploading to Bitbucket and Github repositories

class Node:

    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

def findLCA(root, n1, n2): 

    if root is None:
        return None

    if root.key == n1 or root.key == n2:
        return root

    left_lca = findLCA(root.left, n1, n2)
    right_lca = findLCA(root.right, n1, n2)

    if left_lca and right_lca:
        return root

    return left_lca if left_lca is not None else right_lca





