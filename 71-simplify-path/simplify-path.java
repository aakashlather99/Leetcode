class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.addLast(part);
            }
        }
        return "/" + String.join("/", stack);
    }
}