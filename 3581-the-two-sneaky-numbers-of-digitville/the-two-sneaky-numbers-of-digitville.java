class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        int[] ans = new int[2];
        int j = 0;

        for (int x : nums) {
            if (seen[x]) {
                ans[j++] = x;
            } else {
                seen[x] = true;
            }
        }

        return ans;
    }
}