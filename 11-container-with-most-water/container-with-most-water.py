class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        max_water = 0
        
        while left < right:
            h_left = height[left]
            h_right = height[right]
            
            current_water = min(h_left, h_right) * (right - left)
            if current_water > max_water:
                max_water = current_water
                
            if h_left < h_right:
                left += 1
            else:
                right -= 1
                
        return max_water