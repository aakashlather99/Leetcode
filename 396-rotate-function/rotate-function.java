class Solution {
    public int maxRotateFunction(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        int currentF = 0;
        
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            currentF += i * nums[i];
        }
        
        int maxF = currentF;
        
        for (int i = 1; i < n; i++) {
            currentF += totalSum - n * nums[n - i];
            if (currentF > maxF) {
                maxF = currentF;
            }
        }
        
        return maxF;
    }
}