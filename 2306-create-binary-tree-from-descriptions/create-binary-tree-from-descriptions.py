# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        nodes = {}
        children = set()
        
        for parent, child, is_left in descriptions:
            if parent not in nodes:
                nodes[parent] = TreeNode(parent)
            if child not in nodes:
                nodes[child] = TreeNode(child)
                
            if is_left:
                nodes[parent].left = nodes[child]
            else:
                nodes[parent].right = nodes[child]
                
            children.add(child)
            
        for node_val in nodes:
            if node_val not in children:
                return nodes[node_val]
                
        return None