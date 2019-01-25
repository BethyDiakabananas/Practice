class Solution {
    // Iterative Solution:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isHappy(int n) {
        // Create a set of all sums starting with n
        Set<Integer> sums = new HashSet<Integer>();
        int sumOfSquares, digit;
        while (sums.add(n)) {
            sumOfSquares = 0;
            
            // add the squares of the individual digits
            while (n > 0) {
                digit = n % 10; // gets the last digit of the number
                sumOfSquares += (digit*digit);  
                n /= 10; // truncate the last digit
            }
            
            // we found a happy number
            if (sumOfSquares == 1) {
                return true;
            } else {
                // update n to the latest sum
                n = sumOfSquares;
            }
        }
        return false;
    }
    
    // Recursive solution
    // Time complexity: O(n)
    // Space complexity: O(n): Although we aren't using auxillary space,
    // each call is added to the callstack.
    public boolean isHappyRecursive(int n) {
        // Base case: we've found a happy number
        if (n == 1 || n == 7)
            return true;
        
        // if it's a single digit number where the final number doesn't equal one
        // return false
        if (n < 10)
            return false;
        
        int sumOfSquares = 0;
        
        // get the last digit of the number until we've reached zero
        // then add the squares
        while (n > 0) {
            int digit = n % 10;
            sumOfSquares = digit * digit;
            n /= 10;
        }
        // n is now equal to the sum of squares
        // recur until we've reached the base case.
        return isHappyRecursive(sumOfSquares);
    }
}
