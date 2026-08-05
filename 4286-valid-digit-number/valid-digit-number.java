class Solution {
    public boolean validDigit(int n, int x) {
         String s = String.valueOf(n);
        char d = (char) ('0' + x);
        return s.charAt(0) != d && s.indexOf(d) != -1;
    }
}