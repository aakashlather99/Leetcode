class Solution {
    public int numberOfSpecialChars(String word) {
        int lower = 0;
        int upper = 0;
        
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower |= (1 << (c - 'a'));
            } else {
                upper |= (1 << (c - 'A'));
            }
        }
        
        return Integer.bitCount(lower & upper);
    }
}