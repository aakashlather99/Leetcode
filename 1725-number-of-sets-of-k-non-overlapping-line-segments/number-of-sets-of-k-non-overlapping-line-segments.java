class Solution {
    public int numberOfSets(int n, int k) {
       long MOD = 1000000007;
        int r = 2 * k;

        long[] fact = new long[n + k];
        long[] invFact = new long[n + k];

        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[fact.length - 1] = power(fact[fact.length - 1], MOD - 2, MOD);

        for (int i = fact.length - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        return (int)(fact[n + k - 1] * invFact[r] % MOD * invFact[n + k - 1 - r] % MOD);
    }

    private long power(long a, long b, long mod) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % mod;

            a = a * a % mod;
            b >>= 1;
        }

        return res; 
    }
}