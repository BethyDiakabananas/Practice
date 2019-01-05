/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation and return them as an array.
 */
class Solution {
  // Time Complexity: O(n): we perform O(1) operations for each element in the array
  // space complexity: O(n): We return an array.
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) 
            res[i] = res[i >> 1] + (i & 1);
        return res;
    }
