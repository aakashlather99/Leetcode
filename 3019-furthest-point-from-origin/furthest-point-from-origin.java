class Solution {
    public int furthestDistanceFromOrigin(String moves) {
         int balance = 0;
        int blanks = 0;

        for(char c : moves.toCharArray()){
            if(c == 'L') balance--;
            else if(c == 'R') balance++;
            else blanks++;
        }

        return Math.abs(balance) + blanks;
    }
}