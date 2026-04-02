class Solution {
    public int firstMatchingIndex(String s) {
        char[] chars = s.toCharArray(); 
        int j = chars.length - 1;
        
        for (int i = 0; i <= j; i++, j--) {
            if (chars[i] == chars[j]) {
                return i;
            }
        }       
        
        return -1;
    }
}