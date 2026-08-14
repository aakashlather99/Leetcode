class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int i = s.charAt(right) - 'a';
            freq[i]++;

            while (freq[i] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}