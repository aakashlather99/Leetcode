class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0, digitSum = 0;

        for (int x : nums) {
            elementSum += x;
            while (x > 0) {
                digitSum += x % 10;
                x /= 10;
            }
        }

        return Math.abs(elementSum - digitSum);
    }
}