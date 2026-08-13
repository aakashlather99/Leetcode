class Solution {
    public int countLargestGroup(int n) {
        int[] freq = new int[37];

        for (int x = 1; x <= n; x++) {
            int sum = 0;
            int num = x;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            freq[sum]++;
        }

        int max = 0;
        for (int x : freq) {
            max = Math.max(max, x);
        }

        int ans = 0;
        for (int x : freq) {
            if (x == max) {
                ans++;
            }
        }

        return ans;
    }
}