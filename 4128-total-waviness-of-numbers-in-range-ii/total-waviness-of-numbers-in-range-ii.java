class Solution {
    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;
        String s = String.valueOf(n);
        long[][][][][] memo = new long[s.length()][2][12][12][2];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 12; k++) {
                    for (int l = 0; l < 12; l++) {
                        memo[i][j][k][l][0] = -1;
                    }
                }
            }
        }
        
        return dp(s, 0, true, true, -1, -1, memo)[1];
    }

    private long[] dp(String s, int idx, boolean isTight, boolean isLz, int ppD, int pD, long[][][][][] memo) {
        if (idx == s.length()) {
            return new long[]{1, 0};
        }
        
        int mlz = isLz ? 1 : 0;
        int mpp = ppD + 1;
        int mp = pD + 1;

        if (!isTight && memo[idx][mlz][mpp][mp][0] != -1) {
            return memo[idx][mlz][mpp][mp];
        }

        int limit = isTight ? s.charAt(idx) - '0' : 9;
        long tCnt = 0;
        long tWav = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nTight = isTight && d == limit;
            boolean nLz = isLz && d == 0;
            int nPp = nLz ? -1 : pD;
            int nP = nLz ? -1 : d;

            int addWav = 0;
            if (ppD != -1 && pD != -1) {
                if ((ppD < pD && pD > d) || (ppD > pD && pD < d)) {
                    addWav = 1;
                }
            }

            long[] res = dp(s, idx + 1, nTight, nLz, nPp, nP, memo);
            tCnt += res[0];
            tWav += res[1] + addWav * res[0];
        }

        long[] ans = new long[]{tCnt, tWav};
        if (!isTight) {
            memo[idx][mlz][mpp][mp] = ans;
        }
        return ans;
    }
}