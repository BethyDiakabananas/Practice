class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
     public boolean containsDuplicate(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();
         for (int num : nums) {
             if (set.contains(num))
                 return true;
             set.add(num);
         }
         return false;
     }
    
    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
}
