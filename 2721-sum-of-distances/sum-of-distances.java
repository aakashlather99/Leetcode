class Solution {
    public long[] distance(int[] nums) {
         int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Group indices by value
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> pos : map.values()){

            int m = pos.size();
            long[] prefix = new long[m];

            prefix[0] = pos.get(0);

            for(int i=1; i<m; i++){
                prefix[i] = prefix[i-1] + pos.get(i);
            }

            for(int i=0; i<m; i++){

                long idx = pos.get(i);

                long left = (i==0) ? 0 :
                        (long)i * idx - prefix[i-1];

                long right = (i==m-1) ? 0 :
                        (prefix[m-1]-prefix[i])
                        - (long)(m-i-1)*idx;

                ans[(int)idx] = left + right;
            }
        }

        return ans;
    }
}