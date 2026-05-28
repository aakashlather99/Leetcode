class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int bestIdx;
    
    public TrieNode(int idx) {
        this.bestIdx = idx;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int bestGlobalIdx = 0;
        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[bestGlobalIdx].length()) {
                bestGlobalIdx = i;
            }
        }
        
        TrieNode root = new TrieNode(bestGlobalIdx);
        
        for (int i = 0; i < wordsContainer.length; i++) {
            String w = wordsContainer[i];
            TrieNode curr = root;
            for (int j = w.length() - 1; j >= 0; j--) {
                int c = w.charAt(j) - 'a';
                if (curr.children[c] == null) {
                    curr.children[c] = new TrieNode(i);
                }
                curr = curr.children[c];
                
                int currBest = curr.bestIdx;
                if (w.length() < wordsContainer[currBest].length()) {
                    curr.bestIdx = i;
                } else if (w.length() == wordsContainer[currBest].length() && i < currBest) {
                    curr.bestIdx = i;
                }
            }
        }
        
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String q = wordsQuery[i];
            TrieNode curr = root;
            for (int j = q.length() - 1; j >= 0; j--) {
                int c = q.charAt(j) - 'a';
                if (curr.children[c] == null) {
                    break;
                }
                curr = curr.children[c];
            }
            ans[i] = curr.bestIdx;
        }
        
        return ans;
    }
}