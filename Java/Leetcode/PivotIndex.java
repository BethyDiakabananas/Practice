class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0, currentSum = 0;
        for (int num : nums)
            total += num;
        for (int i = 0; i < nums.length; currentSum += nums[i++]) {
            if (currentSum * 2 == total - nums[i])
                return i;
        }
        return -1;
    }
}
