class Solution {
    public int subsetXORSum(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x |= n;
        }
        return x << (nums.length - 1);
    }
}