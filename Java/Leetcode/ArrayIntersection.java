class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Time Complexity: O(n)
        // Space Complexity:O(n)
        HashSet<Integer> numbers = new HashSet<Integer>();
        HashSet<Integer> intersections = new HashSet<Integer>();
        
        // add all possible values to the first set
        for (int num : nums1)
            numbers.add(num);
        
        // if we find an intersection, add that number to the intersection set
        for (int num : nums2) {
            if (numbers.contains(num))
                intersections.add(num);
        }
        
        // add numbers in the intersection set to the result array
        int[] result = new int[intersections.size()];
        int i = 0;
        for (int num : intersections) {
            result[i++] = num;
        }
        return result;
    }
}
