class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        min_land_end = min(s + d for s, d in zip(landStartTime, landDuration))
        min_water_end = min(s + d for s, d in zip(waterStartTime, waterDuration))
        
        land_then_water = min(max(min_land_end, s) + d for s, d in zip(waterStartTime, waterDuration))
        water_then_land = min(max(min_water_end, s) + d for s, d in zip(landStartTime, landDuration))
        
        return min(land_then_water, water_then_land)