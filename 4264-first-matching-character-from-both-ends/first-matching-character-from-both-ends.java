class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int limit = (n - 1) / 2;
        
        for (int i = 0; i <= limit; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) {
                return i;
            }
        }
        
        return -1;
    }
}