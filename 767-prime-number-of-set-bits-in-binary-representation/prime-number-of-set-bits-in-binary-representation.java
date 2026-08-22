class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for (int x = left; x <= right; x++) {
            int bits = Integer.bitCount(x);

            if (isPrime(bits)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7 ||
               n == 11 || n == 13 || n == 17 || n == 19;
    }
}