class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        for (int i = 25, j = 0; i >= 0; i--, j++) {
            ans += freq[i] * (j / 8 + 1);
        }

        return ans;

    }
}