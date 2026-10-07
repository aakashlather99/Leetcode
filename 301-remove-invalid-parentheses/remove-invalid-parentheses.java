class Solution {
    Set<String> res = new HashSet<>();
    String s;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;

        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }

        dfs(0, 0, left, right, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void dfs(int i, int balance, int left, int right, StringBuilder path) {
        if (i == s.length()) {
            if (balance == 0 && left == 0 && right == 0) {
                res.add(path.toString());
            }
            return;
        }

        char c = s.charAt(i);

        if (c == '(') {
            if (left > 0)
                dfs(i + 1, balance, left - 1, right, path);

            path.append(c);
            dfs(i + 1, balance + 1, left, right, path);
            path.deleteCharAt(path.length() - 1);

        } else if (c == ')') {
            if (right > 0)
                dfs(i + 1, balance, left, right - 1, path);

            if (balance > 0) {
                path.append(c);
                dfs(i + 1, balance - 1, left, right, path);
                path.deleteCharAt(path.length() - 1);
            }

        } else {
            path.append(c);
            dfs(i + 1, balance, left, right, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}