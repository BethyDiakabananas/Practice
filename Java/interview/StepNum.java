public class Solution {
	public ArrayList<Integer> stepnum(int A, int B) {
	    int i;
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    for (i = A; i <= B; i++) {
	        if (validStepNum(i))
	            res.add(i);
	    }
	    
	    return res;
	    
	}
	
	private boolean validStepNum(int num) {
	    int last = num % 10;
	    int cur;
	    num /= 10;
	    
	    while (num > 0) {
	        cur = num % 10;
	        if (Math.abs(cur - last) == 1) {
	            last = cur;
	            num /= 10;
	        } else {
	            return false;
	        }
	    }
	    
	    return true;
	    
	}
}
