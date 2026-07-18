class Solution {
    public int findGCD(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        while (maxVal != 0) {
            int temp = maxVal;
            maxVal = minVal % maxVal;
            minVal = temp;
        }

        return minVal;
    }
}