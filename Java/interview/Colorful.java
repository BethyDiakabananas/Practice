/**
EXAMPLE:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
*/

// Time complexity: O(N)
// Space complexity: O(N)
public class Solution {
	public int colorful(int a) {
	    List<Integer> digits = getDigits(a);
	    Set<Integer> products = new HashSet<Integer>();
	    for (int i = 0; i < digits.size(); i++) {
	        int color = 1; 
	        for (int j = 0; i + j < digits.size(); j++) {
	            color *= digits.get(i+j);
	            if (products.contains(color)) {
	                return 0;
	            }
	           products.add(color);
	        }
	    }
	    return 1;
	}
	
	List<Integer> getDigits(int a) {
	    List<Integer> digits = new ArrayList<>();
	    while (a > 0) {
	        digits.add(a % 10);
	        a /= 10;
	    }
	    return digits;
	}
}
