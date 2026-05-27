class Solution {
    public int numberOfSpecialChars(String word) {
       int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        for (int i = 0; i < 26; i++) {
            lastLower[i] = -1;
            firstUpper[i] = -1;
        }
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lastLower[c - 'a'] = i;
            } else {
                int idx = c - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                ans++;
            }
        }
        
        return ans; 
    }
}