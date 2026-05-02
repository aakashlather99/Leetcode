class Solution:
    def rotatedDigits(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 1 
        count = 0
        
        for i in range(1, n + 1):
            if i < 10:
                if i == 1 or i == 8:
                    dp[i] = 1
                elif i == 2 or i == 5 or i == 6 or i == 9:
                    dp[i] = 2
                    count += 1
            else:
                a = dp[i // 10]
                b = dp[i % 10]
                
                if a == 1 and b == 1:
                    dp[i] = 1
                elif a >= 1 and b >= 1:
                    dp[i] = 2
                    count += 1
        return count