class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        
        if (left < n) {
            sb.append('(');
            backtrack(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (right < left) {
            sb.append(')');
            backtrack(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}