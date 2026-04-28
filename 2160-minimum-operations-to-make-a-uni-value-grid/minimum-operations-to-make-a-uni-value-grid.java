class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;

        int[] nums = new int[size];

        int rem = grid[0][0] % x;
        int idx = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                int val = grid[i][j];

                if(val % x != rem)
                    return -1;

                nums[idx++] = val;
            }
        }

        Arrays.sort(nums);

        int median = nums[size/2];

        int ops = 0;

        for(int num : nums){
            ops += Math.abs(num - median) / x;
        }

        return ops;
    }
}