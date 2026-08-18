class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.res = 0       
        def traverse(node):
            if not node:
                return
            
            # 1. Traverse left subtree
            traverse(node.left)
            
            # 2. Process current node
            self.count += 1
            if self.count == k:
                self.res = node.val
                return  # Optimization: stop early
            
            # 3. Traverse right subtree
            traverse(node.right)
        
        traverse(root)
        return self.res