class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        for (int step = 0; step < n; step++) {
            int right = (startIndex + step) % n;
            int left = (startIndex - step + n) % n;

            if (words[right].equals(target) || words[left].equals(target)) {
                return step;
            }
        }

        return -1;
    }
}