class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> Long.compare((long) a * a, (long) b * b));

        int n = arr.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            long square = (long) arr[i] * arr[i];
            if (i < n / 2) {
                ans -= square;
            } else {
                ans += square;
            }
        }

        return ans;
    }
}