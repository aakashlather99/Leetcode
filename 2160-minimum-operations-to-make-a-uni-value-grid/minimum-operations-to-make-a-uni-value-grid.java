class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();

        int rem = grid[0][0] % x;

        for(int[] row : grid){
            for(int num : row){

                if(num % x != rem)
                    return -1;

                nums.add(num);
            }
        }

        Collections.sort(nums);

        int median = nums.get(nums.size()/2);

        int ops = 0;

        for(int num : nums){
            ops += Math.abs(num-median)/x;
        }

        return ops;
    }
}