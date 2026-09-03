class Solution {
    private int[][] wc;
    private int[] ws;
    private int[] cnt;
    private int[] score;
    private int[][] words;

    public int maxScoreWords(String[] wordsInput, char[] letters, int[] scoreInput) {
        int n = wordsInput.length;
        this.score = scoreInput;
        this.wc = new int[n][26];
        this.ws = new int[n];
        this.cnt = new int[26];
        for (char c : letters) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            String word = wordsInput[i];
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                wc[i][idx]++;
                ws[i] += score[idx];
            }
        }

        return dfs(0);
    }

    private int dfs(int i) {
        if (i == wc.length) return 0;

        int ans = dfs(i + 1); 
        boolean possible = true;
        for (int j = 0; j < 26; j++) {
            if (wc[i][j] > cnt[j]) {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (int j = 0; j < 26; j++) {
                cnt[j] -= wc[i][j];
            }
            ans = Math.max(ans, ws[i] + dfs(i + 1));
            for (int j = 0; j < 26; j++) {
                cnt[j] += wc[i][j];
            }
        }

        return ans;
    }
}