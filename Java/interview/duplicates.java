public class Solution {
	// DO NOT MODIFY THE LIST
	// time complexity: O(n)
	// space complexity: O(1)
	public int singleNumber(final List<Integer> a) {
	    int result = 0;
	    for (int number : a) 
	        result ^= number;
	    return result;
	}
}
