class Solution:
    def minJumps(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
            
        max_val = max(nums)
        
        is_prime = [True] * (max_val + 1)
        is_prime[0] = is_prime[1] = False
        for i in range(2, int(max_val**0.5) + 1):
            if is_prime[i]:
                for j in range(i * i, max_val + 1, i):
                    is_prime[j] = False
                    
        val_to_indices = [[] for _ in range(max_val + 1)]
        for i, val in enumerate(nums):
            val_to_indices[val].append(i)
            
        q = deque([0])
        visited_idx = bytearray(n)
        visited_idx[0] = 1
        visited_prime = bytearray(max_val + 1)
        
        steps = 0
        while q:
            for _ in range(len(q)):
                u = q.popleft()
                
                if u == n - 1:
                    return steps
                    
                for v in (u - 1, u + 1):
                    if 0 <= v < n and not visited_idx[v]:
                        visited_idx[v] = 1
                        q.append(v)
                        
                val = nums[u]
                if is_prime[val] and not visited_prime[val]:
                    visited_prime[val] = 1
                    for m in range(val, max_val + 1, val):
                        if val_to_indices[m]:
                            for v in val_to_indices[m]:
                                if not visited_idx[v]:
                                    visited_idx[v] = 1
                                    q.append(v)
                            val_to_indices[m].clear()
                            
            steps += 1
            
        return -1