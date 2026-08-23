class Solution {
    public boolean sumGame(String num) {
        int n = num.length() / 2;
        int diff = 0;
        int q = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            if (c == '?') {
                q += i < n ? 1 : -1;
            } else if (i < n) {
                diff += c - '0';
            } else {
                diff -= c - '0';
            }
        }

        return diff * 2 != -9 * q;
    }
}