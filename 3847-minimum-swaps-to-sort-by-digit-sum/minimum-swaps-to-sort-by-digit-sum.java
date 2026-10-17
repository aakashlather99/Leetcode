class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int sa = digitSum(a), sb = digitSum(b);
            if (sa != sb) return Integer.compare(sa, sb);
            return Integer.compare(a, b);
        });

        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(nums[i], i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != arr[i]) {
                int j = pos.get(arr[i]);
                pos.put(nums[i], j);
                pos.put(arr[i], i);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ans++;
            }
        }

        return ans;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}