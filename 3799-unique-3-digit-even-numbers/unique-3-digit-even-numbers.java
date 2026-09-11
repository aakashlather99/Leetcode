class Solution {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];

        for (int d : digits) cnt[d]++;

        int ans = 0;

        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 8; c += 2) {
                    if (a == b && b == c) {
                        if (cnt[a] >= 3) ans++;
                    } else if (a == b) {
                        if (cnt[a] >= 2 && cnt[c] >= 1) ans++;
                    } else if (a == c) {
                        if (cnt[a] >= 2 && cnt[b] >= 1) ans++;
                    } else if (b == c) {
                        if (cnt[b] >= 2 && cnt[a] >= 1) ans++;
                    } else if (cnt[a] >= 1 && cnt[b] >= 1 && cnt[c] >= 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}