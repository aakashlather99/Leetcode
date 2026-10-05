class Solution {
    public int scoreOfParentheses(String s) {
        int[] stack = new int[s.length()];
        int top = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++top] = 0;
            } else {
                int x = stack[top--];
                stack[top] += Math.max(2 * x, 1);
            }
        }

        return stack[0];
    }
}