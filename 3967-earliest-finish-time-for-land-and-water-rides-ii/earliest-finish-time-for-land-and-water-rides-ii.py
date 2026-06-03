class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        min_land_end = min(s + d for s, d in zip(landStartTime, landDuration))
        min_water_end = min(s + d for s, d in zip(waterStartTime, waterDuration))
        
        ans = float('inf')
        for ws, wd in zip(waterStartTime, waterDuration):
            ans = min(ans, max(min_land_end, ws) + wd)
            
        for ls, ld in zip(landStartTime, landDuration):
            ans = min(ans, max(min_water_end, ls) + ld)
            
        return int(ans) 