class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        ans = []

        for x, y, r in queries:
            count = 0
            for px, py in points:
                if (px - x) ** 2 + (py - y) ** 2 <= r ** 2:
                    count += 1
            ans.append(count)

        return ans