class Solution {
    public int countEven(int num) {
        int sum = 0;
        int x = num;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum % 2 == 0 ? num / 2 : (num - 1) / 2;
    }
}