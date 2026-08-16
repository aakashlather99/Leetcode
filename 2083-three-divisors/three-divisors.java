class Solution {
    public boolean isThree(int n) {
        int r = (int) Math.sqrt(n);
        return r * r == n && isPrime(r);
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}